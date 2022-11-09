<h1 align="center">
    <img alt="logo" src="https://i.postimg.cc/tgKqsL9Y/easyschema.png" width="400">
</h1>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EasySchema是一个支持cnSchema中文图谱的编辑工具，其中实现了对cnSchema概念和属性表编辑功能并生成用户自定义的MySchema概念和属性表，以及生成相关联的三元组文件。同时为初学者提供了详细的[文档](https://zjukg.github.io/.../index.html)以及一个开放共享的知识图谱学习社区[网站](http://cnschema.openkg.cn/)。

<br>

# 运行示例
<img alt="demo" src="https://i.postimg.cc/4xrv3xHt/home.png" width="800"><br>
<a href="http://116.62.19.215:1111/">demo演示地址</a>
<br>

# 技术栈
小工具前端是基于Vue + Electron ,后端是基于Springboot + MySQL
<br>
<br>

# 实现的基本功能
**1** cnSchema概念表查看、搜索功能，导出节点功能<br>
**2** cnSchema概念表知识图谱可视化展示<br>
**3** cnSchema属性表查看、搜索功能，导出节点功能<br>
**4** Myschema概念表增删改查功能、导入数据功能、导出文件功能<br>
**5** Myschema概念表知识图谱可视化展示<br>
**6** Myschema属性表增删改查功能、导出文件功能<br>
**7** 生成Myschema三元组
<br>
# 后续优化
**1** 支持多个概念类之间进行关联生成三元组文件<br>
**2** 支持cnSchema抽取模型<br>
**3** 支持NeuralKG模型<br>
**4** 导入实例数据文件进行模糊匹配时，运用词向量进行匹配筛选<br>
**5** 目前EasySchema只支持Mac和Windows系统平台，针对Mac系统运用的单架构包只能运行 X64 或者 ARM64 指令集，在不匹配的硬件上不能运行，将进行优化构建双架构包能够同时运行 X64 和 ARM64 指令集，在 Intel CPU 上执行 X64 指令，在 Mac M1 芯片上执行 ARM64 指令；并支持生成Linux系统的应用程序包
<br>
# 运行与启动

## 下载

**Step1** tool文件夹下提供了不同系统平台的应用程序包<br>

<img alt="demo" src="https://i.postimg.cc/CxXCKH6m/load.png" width="200"><br>

**Step2** 下载适用您电脑系统的应用程序包，下面我们提供一个基于Mac-arm64系统的下载样例<br>

+  打开EasySchema.dmg,将图标拖到文件夹中，自动添加到电脑的应用程序中 <br>
<img alt="dmg" src="https://i.postimg.cc/wMDzfGtB/tu1.png" width="400"><br>

+  桌面应用程序界面 <br>
<img alt="dmg" src="https://i.postimg.cc/Y9bY4d2h/tu2.png" width="400"><br>

## 使用说明
**1.cnschema概念表** cnschema概念表-支持搜索、查看的功能，可以勾选部分概念导出到Myschema概念表中对其进行编辑，以及节点知识图谱可视化展示<br>
<img alt="dmg" src="https://i.postimg.cc/NjNf3Z0J/tu3.png" width="500"><br>
**2.cnschema属性表** cnschema属性表-支持搜索、查看的功能，可以勾选部分属性导出到Myschema属性表中对其进行编辑<br>
<img alt="dmg" src="https://i.postimg.cc/WbFBNKSY/tu4.png" width="500"><br>
**3.myschema概念表** myschema概念表-支持增删改查的功能、导入/导出数据的功能、以及节点知识图谱可视化展示<br>
<img alt="dmg" src="https://i.postimg.cc/LXJcJb2s/tu5.png" width="500"><br>
新增概念有三种形式：<br>
+  +  从cnschema概念表中选出部分节点到Myschema中 <br>
+  +  导入实例数据，根据匹配结果新增 <br>
+  +  点击新增按钮新增 <br>

**4.myschema属性表** myschema属性表-支持增删改查的功能、导出数据的功能<br>
<img alt="dmg" src="https://i.postimg.cc/50zPddf8/tu6.png" width="500"><br>
新增属性有三种形式：<br>
+  +  从cnschema属性表中选出部分节点到Myschema中 <br>
+  +  导入实例数据，根据匹配结果新增 <br>
+  +  点击新增按钮新增 <br>

**5.增删改查功能** 
+ 搜索<br>
+ 查看<br>
+ 新增<br>
+ + 新增一级节点<br>
+ + 新增子级节点<br>
+ 删除<br>
+ + 单个删除<br>
+ + 批量删除<br>

**6.导入数据-模糊匹配功能** 目前只支持上传单个表文件进行模糊匹配<br>
<img alt="dmg" src="https://i.postimg.cc/4yCvRB5M/tu7.png" width="500"><br>
+ 将表名、表头字段与数据库中的cnschema概念、属性的字符串进行模糊查询，页面中会显示哪些字段存在相似情况、哪些字段不存在，可以根据匹配结果将字段添加到对应的概念表和属性表中<br>

**7.导出功能** 导出json文件<br>
**8.生成三元组功能** 上传实例文件、myschema文件，可以生成相关数据的三元组文件，下载到本地<br>
<img alt="dmg" src="https://i.postimg.cc/g2TbqZ4j/tu8.png" width="500"><br>

<br>

# 问题反馈
我们提供长期技术维护和答疑解惑。如有疑问，请提交issues。
<br>

# 核心团队

**浙江大学知识引擎实验室**
