package com.zj.easychema.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import com.zj.easychema.pojo.*;
import com.zj.easychema.pojo.Properties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import com.zj.easychema.servies.TypeService;
import lombok.experimental.Accessors;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
public class TypeController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private TypeService typeService;
    @RequestMapping("posts")
    public Map<String,Object> getType(MultipartFile file) throws Exception {
        Map<String,Object> datamap = new HashMap<>();
        String name = FilenameUtils.getName(file.getOriginalFilename());
        String fileName =  name.substring(0, name.lastIndexOf("."));
        System.out.println(fileName);
        Query query1 = new Query(Criteria.where("nameZh").regex(fileName));
        List<Type> findSheetName = mongoTemplate.find(query1, Type.class);
        System.out.println(findSheetName);
        List findSheetlist = new ArrayList<>();

        for(int i=0;i<findSheetName.size();i++){
            findSheetlist.add(findSheetName.get(i).getNameZh());
        }
        datamap.put("sheetName",findSheetlist);
        System.out.println(file);
        List list = new ArrayList<>();
        List<Object> cellList = new ArrayList<>();

        byte [] byteArr=file.getBytes();
        InputStream inputStream = new ByteArrayInputStream(byteArr);
        Sheet sheet; //工作表
        Cell cell;    //单元格
        // 创建excel工作簿
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        Workbook workbook =null; //用于存储解析后的Excel文件
        if(".csv".equals(fileType)){
            try {
                CSVReader csvReader = new CSVReaderBuilder(
                        new BufferedReader(
                                new InputStreamReader(file.getInputStream(), "utf-8"))).build();
                String[] strings = csvReader.readNext();
                List<String> list1 = Arrays.asList(strings);
                list=list1;

            } catch (Exception e) {
                System.out.println("CSV文件读取异常");

            }
        }else {
            if(".xls".equals(fileType)){
                workbook= new HSSFWorkbook(inputStream);//HSSFWorkbook专门解析.xls文件
            }else if(".xlsx".equals(fileType)){
                workbook = new XSSFWorkbook(inputStream);//XSSFWorkbook专门解析.xlsx文件
            }
            sheet = workbook.getSheetAt(0);//获取sheet
            org.apache.poi.ss.usermodel.Row row = sheet.getRow(0);
            for (int k = row.getFirstCellNum() ; k < row.getLastCellNum(); k++) {//这里需要注意的是getLastCellNum()的返回值为“下标+1”
                cell = row.getCell(k);
                list.add(cell);

            }
        }
        for(int i=0;i<list.size();i++){
            List<String> reslist = new ArrayList<>();
            List<String> reslist1 = new ArrayList<>();
            CellRes cellRess = new CellRes();
            Map<String,Object> cellRes = new HashMap<>();
            Query query = new Query(Criteria.where("nameZh").regex(list.get(i).toString()));
            query.fields().include("nameZh");
            cellRess.setCellName(list.get(i).toString());
            List<Type> list1 = mongoTemplate.find(query, Type.class);

            for(int j=0;j<list1.size();j++){
                reslist.add(list1.get(j).getNameZh());
            }
            List<Properties> list2 = mongoTemplate.find(query, Properties.class);
            for(int x=0;x<list2.size();x++){
                reslist1.add(list2.get(x).getNameZh());
            }

            cellRess.setTypeList(reslist);
            cellRess.setPropertiesList(reslist1);
            cellList.add(cellRess);
        }
        datamap.put("cellRes",cellList);

        System.out.println("aa0"+datamap);

        return datamap;
    }
    @RequestMapping("/getCNschema")
    public Map<String,Object> getCNschema(){
        List<Type> all = mongoTemplate.findAll(Type.class);
        Map<String,Object> map = new HashMap<>();
        map.put("menuTree",all);
        System.out.println(all);
        return map;
    }
    @RequestMapping("/there")
    public Map<String,List<String>> creatThere(MultipartFile file, String jsonfile, String filename) throws IOException {
        Map<String,List<String>> map =typeService.parsefile(file);
        String name = FilenameUtils.getName(file.getOriginalFilename());
        String fileName =  name.substring(0, name.lastIndexOf("."));
        List<String[]> data=new ArrayList<>();
        try {
//            FileReader fileReader = new FileReader(file1);
//            Reader reader = new InputStreamReader(new FileInputStream(file1), "utf-8");
//            int ch = 0;
//            StringBuffer sb = new StringBuffer();
//            while ((ch = reader.read()) != -1) {
//                sb.append((char) ch);
//            }
//            fileReader.close();
//            reader.close();
//            jsonStr = sb.toString();
            JSONArray jsonArray = JSONArray.parseArray(jsonfile);
            List<Myschema> myschemas = jsonArray.toJavaList(Myschema.class);
            List<Myschema> collect = myschemas.stream().filter(myschema -> fileName.equals(myschema.getLabel())).collect(Collectors.toList());
            Myschema myschema=collect.get(0);
            while (myschema.getSubTypeOf()!=null && !myschema.getSubTypeOf().equals("")){
                Myschema finalMyschema = myschema;
                Myschema myschema2 = myschemas.stream().filter(myschema1 -> finalMyschema.getSubTypeOf().equals(myschema1.getLabel())).collect(Collectors.toList()).get(0);
                String[] strings=new String[3];
                strings[0]=myschema2.getLabel();
                strings[1]="包含";
                strings[2]=myschema.getLabel();
                System.out.println(strings.toString());
                data.add(strings);
                myschema=myschema2;
            }
            List<String> list = map.get(filename);
            Set<String> keyset = map.keySet();
            List<String> keylist = new ArrayList<>();
            keylist.addAll(keyset);
            for (int i=0;i<keylist.size();i++){
                String key=keylist.get(i);
                List<String> datalist=map.get(key);
                if(!key.equals(filename)){
                    for (int j=0;j<list.size();j++){
                        if(datalist.get(j) !=null&&list.get(j)!=null){
                            String[] strings=new String[3];
                            strings[0]=list.get(j);
                            strings[1]=keylist.get(i);
                            strings[2]=datalist.get(j);
                            data.add(strings);
                        }

                    }
                }

            }
//            JSONObject jsonObj = JSONObject.parseObject(jsonStr);
//            String array =jsonObj.getString("children");


//            List<Relationship> list = jsonArray.toJavaList(Relationship.class);

//            CSVWriter csvWriter = new CSVWriter(new FileWriter("C:\\Users\\ggg\\Desktop\\list.csv"));
            CSVWriter csvWriter = new CSVWriter(new FileWriter("\\home\\lxr\\easyschema\\list.csv"));
            csvWriter.writeAll(data);
            csvWriter.close();
            System.out.println(data);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
//        Set<String> strings = map.keySet();
//        String[] row1 = new String[3];
//        row1[0]="head";
//        row1[1]="and";
//        row1[2]="end";
//        List<Relationship> list = jsonToList(jsonfile);
//        List<String[]> data=new ArrayList<>();
//        data.add(row1);
//        for (int i=0;i<list.size();i++){
//            Relationship relationship = list.get(i);
//            if(strings.contains(relationship.getSource()) && strings.contains(relationship.getTarget())){
//
//                List<String> headlist = map.get(relationship.getSource());
//                List<String> endlist = map.get(relationship.getTarget());
//                for (int j=0;j<headlist.size();j++){
//                    if(!headlist.get(j).equals("")&&!endlist.get(j).equals("")){
//                        String[] row = new String[3];
//                        row[0]=headlist.get(j);
//                        row[1]=relationship.getLabel();
//                        row[2]=endlist.get(j);
//                        data.add(row);
//                    }
//
//                }
//
//            }
//        }

    }

    public List<Relationship> jsonToList(MultipartFile file) throws IOException {
        System.out.println(file);
        File file1 = MultipartFileToFile(file);
        String jsonStr = "";
        try {
            FileReader fileReader = new FileReader(file1);
            Reader reader = new InputStreamReader(new FileInputStream(file1), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();

            JSONObject jsonObj = JSONObject.parseObject(jsonStr);
            String array =jsonObj.getString("edges");
            JSONArray jsonArray = JSONArray.parseArray(array);

            List<Relationship> list = jsonArray.toJavaList(Relationship.class);
            System.out.println(list.get(0));
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
    public static File MultipartFileToFile(MultipartFile multipartFile) {

        File file = null;
        //判断是否为null
        if (multipartFile.equals("") || multipartFile.getSize() <= 0) {
            return file;
        }
        //MultipartFile转换为File
        InputStream ins = null;
        OutputStream os = null;
        try {
            ins = multipartFile.getInputStream();
            file = new File(multipartFile.getOriginalFilename());
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ins != null){
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    @RequestMapping("/do")
    public void downloadFile( HttpServletResponse response) throws Exception {

            File file = new File("\\home\\lxr\\easyschema\\list.csv");
            if (file.exists()){
                // 设置强制下载不打开
                response.setContentType("application/force-download");
                // 设置文件名
                response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode("list.csv", "UTF-8"));
                response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                byte[] buffer = new byte[10240];
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
}
