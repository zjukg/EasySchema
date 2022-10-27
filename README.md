EasySchema  
拥有的功能： 
1.cnSchema
2.可下拉选择
3.可动态请求子层级节点
4.可批量选中
4.功能性复选框选择
---
![Image text](https://github.com/lky5230/tree-grid-by-vue/blob/master/src/assets/image1.png)
![Image text](https://github.com/lky5230/tree-grid-by-vue/blob/master/src/assets/image2.png)
![Image text](https://github.com/lky5230/tree-grid-by-vue/blob/master/src/assets/demo.png)
>######样例1
```
<tree-grid
     :columns="columns"  // 表示列
     :rowdata="data"     //表示数据
     :leafUrl="http://api.fan.dev?parentid="   //动态请求子节点时的接口url，会拼接点击的节点的id, 此时数据需要isleaf = 0
     :needUpdate="needUpdate"  //更新数据源，需要传入他触发更新，比如传
 Date.now()
     :onlyLineEdit="true" //是否每行只能编辑，不能创建兄弟节点和子节点
      /* 当funcList存在时必须存在funcListAlias！这是功能性复选框选择的功能 */
      /* 
        表示从请求的数组数据里面，比如用 
        permission: [
              {permission_id:1, permission_name: '删除', checked: true }, 
              {permission_id:2, permission_name: '审核', checked: false}，
              {permission_id:3, permission_name: '更新', checked: false}
        ]  
        作为数据时，如下
      */
        :funcListAlias="{     
             funcList: 'permission',
             id: 'permission_id',
             name: 'permission_name',
             checked: 'select',
         }"
     @currentDate="currentDate" //当每次对tree-grid有一些改动时，可以监听它
 >
</tree-grid>
```
>######样例2
```
<tree-grid
     :columns="columns"
     :rowdata="data"
     :needUpdate="needUpdate"
     :onlyAddOne="true"   //表示只能在已存在的节点下添加子节点
     :treeLoading="treeLoading"  //loading，布尔值
     :showDeleteBtn="false"  //是否在删除列表头显示删除按钮，默认false
    @currentDate="currentDate"
    @uploadmodify="uploadmodify"   //有操作列时，点上传会触发它，参数 [data（修改过的数据集合）, successFn, faildFn], 数据是data，成功则调用successFn('成功！')， 失败调用faildFn('失败！')
    @uploaddelete="uploaddelete"  //点击复选框列th的删除按钮时会触发它（可以控制台查看按钮id，手动触发 window.document.querySelector('#tree_grid___id').click();），参数 [data, successFn, faildFn], 数据是data（选中的id集合），成功则调用successFn('成功！')， 失败调用faildFn('失败！')>
</tree-grid>
```
> ######列的定义：columns
```
  /*
    'name'    //该列title名称
    'prop',    //该列取数据源的哪个属性
    'width',   //该列宽度
    'delete',  //该列是不是复选框列（有它就不需要不需要其他了）
    'isTree',  //该列是不是层级列
    'edit',     //该列可不可以编辑
    'operate',  //该列是不是操作列（有它就不需要不需要其他了）
    'select',   //该列可不可以下拉
    'optionList' //和select一起使用，值：['下拉1','下拉2','下拉3']
    "funcList"  //该列是不是(功能性复选框选择)列
  */
columns: [ 
    {name: 'ID', prop: 'id', width: 120},
    {name: '删除',  delete: true, width: 60 },
    {name: 'name字段', prop: 'name', width: 250, isTree: true, edit: true},
    {name: '操作',  operate: true, width: 60 },
    {name: 'level', prop: 'level', width: 120, select: true, optionList: ['下拉1', '下拉2']},
    {name: 'url', prop: 'url', edit: true},
     /*
     功能选择：取得的数据，prop对应字段: 比如'func' = [
         {permission_id:1, permission_name: '删除', checked: true }, 
         {permission_id:2, permission_name: '审核', checked: false}，
         {permission_id:3, permission_name: '更新', checked: false}
     ],
     注意：对接 funcListAlias 属性！
     */
     { name: '功能选择', prop: 'func', funcList: true, width: 50 },
] 
```
> ######行数据的格式：rowdata
```
rowdata: [{  
    "id": 87, //必须，唯一id 
    "parentid": 22, //必须，父层的id，若自己就是顶层节点，则parentid=0 
    "isleaf"?: 0或1  //【当需要动态获取子节点功能时】就需要它，表示是否含有子节点（0：动态获取子节点，1：无子节点）
    ......
}]
```
