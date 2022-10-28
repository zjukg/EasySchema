package com.zj.easychema.servies;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeService {

    public Map<String, List<String>> parsefile(MultipartFile file) throws IOException {
        byte[] byteArr = file.getBytes();
        InputStream inputStream = new ByteArrayInputStream(byteArr);
        Sheet sheet; //工作表
        Cell cell;    //单元格
        // 创建excel工作簿
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        Map<String, List<String>> map = new HashMap<>();
        Workbook workbook = null; //用于存储解析后的Excel文件
        if (".csv".equals(fileType)) {
            try {
                CSVReader csvReader = new CSVReaderBuilder(
                        new BufferedReader(
                                new InputStreamReader(file.getInputStream(), "gbk"))).build();
                String[] strings = csvReader.readNext();
                List<String[]> strings1 = csvReader.readAll();
                for (int i = 0; i < strings.length; i++) {
                    List<String> datalist = new ArrayList<>();
                    for (int j = 0; j < strings1.size(); j++) {

                        datalist.add(strings1.get(j)[i] + "");
                    }
                    map.put(strings[i], datalist);

                }
                System.out.println(map);

            } catch (Exception e) {
                System.out.println("CSV文件读取异常");

            }
        } else {
            if (".xls".equals(fileType)) {
                workbook = new HSSFWorkbook(inputStream);//HSSFWorkbook专门解析.xls文件
            } else if (".xlsx".equals(fileType)) {
                workbook = new XSSFWorkbook(inputStream);//XSSFWorkbook专门解析.xlsx文件
            }
            sheet = workbook.getSheetAt(0);
            List<String> xlslist = new ArrayList<>();
            org.apache.poi.ss.usermodel.Row row = sheet.getRow(0);
            for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {//这里需要注意的是getLastCellNum()的返回值为“下标+1”
                cell = row.getCell(k);
                xlslist.add(cell.toString());
            }
            for (int i = 0; i < xlslist.size(); i++) {
                List<String> xlsdata = new ArrayList<>();
                for (int j = 1; j <sheet.getLastRowNum(); j++) {
                    org.apache.poi.ss.usermodel.Row rows = sheet.getRow(j);
                    if(rows.getCell(i)!=null){
                        xlsdata.add(rows.getCell(i).toString());

                    }else {
                        xlsdata.add("");

                    }
                }
                map.put(xlslist.get(i), xlsdata);
            }
        }
        return map;
    }
}
