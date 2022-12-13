<h1 align="center">
    <img alt="logo" src="https://i.postimg.cc/tgKqsL9Y/easyschema.png" width="400">
</h1>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EasySchema是一个开源的、支持cnSchema的中文知识图谱Schema编辑工具，使用者可以基于cnSchema快速的定制、扩展、编辑自己的Schema概念和属性表，并基于该Schema生成相关联的三元组文件。EasySchema为初学者提供了详细的文档以及一个开放共享的知识图谱学习社区平台。EasySchema由OpenKG组织开发。

<br>

# 目录

- [目录](#目录)
- [运行示例](#运行示例)
- [技术栈](#技术栈)
- [实现的基本功能](#实现的基本功能)
- [后续优化](#后续优化)
- [运行与启动](#运行与启动)
  - [下载](#下载)
  - [案例实现](#案例实现)
  - [使用说明](#使用说明)
- [问题反馈](#问题反馈)
- [开发团队](#开发团队)
<!-- * [To do](#to-do) -->

<br>

# 运行示例
<img alt="demo" src="https://i.postimg.cc/MTktGg0f/shouye.jpg" width="800"><br>
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
**4** Myschema概念表增删改查功能、重置功能、导入数据功能、导出文件功能<br>
**5** Myschema概念表知识图谱可视化展示<br>
**6** Myschema属性表增删改查功能、重置功能、导出文件功能<br>
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

## 案例实现

**Step1** 有一个博物馆.xls的数据表格，目标是生成博物馆的schema.json文件、以及博物馆的三元组csv文件<br>

<img alt="demo" src="https://i.postimg.cc/KcsXG8k1/s1.jpg" width="600"><br>

**Step2** 点击Myschema概念表，导入表格，进行模糊匹配查询<br>

**Step3** 第一步：表名匹配，点击加号按钮选择适配的概念【博物馆.xls文件，博物馆是表名，选择“博物馆”】<br>

<img alt="demo" src="https://i.postimg.cc/ZRV8qmZZ/3.jpg" width="600"><br>

**Step4** 第二步：表头字段匹配，选择适配的概念和属性，注意选择一个主属性，【博物馆.xls，表头字段有：博物馆地址、联系方式、博物馆性质、主键、行政区划名称、博物馆名称；其中博物馆名称就是博物馆的主属性】<br>

<img alt="demo" src="https://i.postimg.cc/HxRQM2JP/4.jpg" width="600"><br>

**Step5** 第三步：查看选择的概念、再进行二次编辑，生成三元组文件<br>

<img alt="demo" src="https://i.postimg.cc/nzyDrh5y/5.jpg" width="600"><br>

<img alt="demo" src="https://i.postimg.cc/85JZxsM9/6.jpg" width="600"><br>

<img alt="demo" src="https://i.postimg.cc/HktW7kJq/8.jpg" width="600"><br>

+ myschema.json文件样例<br>
<img alt="demo" src="https://i.postimg.cc/RVkJThZq/691670901140-pic.jpg" width="600"><br>

+ 三元组文件样例<br>
<img alt="demo" src="https://i.postimg.cc/sXLgDHB1/701670901186-pic.jpg" width="600"><br>

## 使用说明
**1.cnschema概念表** cnschema概念表-支持搜索、查看的功能，可以勾选部分概念导出到Myschema概念表中对其进行编辑，以及节点知识图谱可视化展示<br>
<img alt="dmg" src="https://i.postimg.cc/NjNf3Z0J/tu3.png" width="500"><br>
+ cnschema概念表可视化展示：树状图、泡泡图
<img alt="dmg" src="https://i.postimg.cc/3NGDxsB7/tu9.png" width="500"><br>
<img alt="dmg" src="https://i.postimg.cc/6Q17LWbt/tu10.png" width="500"><br>
**2.cnschema属性表** cnschema属性表-支持搜索、查看的功能，可以勾选部分属性导出到Myschema属性表中对其进行编辑<br>
<img alt="dmg" src="https://i.postimg.cc/WbFBNKSY/tu4.png" width="500"><br>
**3.myschema概念表** myschema概念表-支持增删改查的功能、导入/导出数据的功能、以及节点知识图谱可视化展示<br>
<img alt="dmg" src="https://i.postimg.cc/LXJcJb2s/tu5.png" width="500"><br>
+ myschema概念表可视化展示<br>
<img alt="dmg" src="https://i.postimg.cc/zBKJb89d/tu11.png" width="500"><br>
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
+ 重置<br>

**6.导入数据-模糊匹配功能** 目前只支持上传单个表文件进行模糊匹配<br>

<img alt="demo" src="https://i.postimg.cc/ZRV8qmZZ/3.jpg" width="600"><br>
+ 参考- [案例实现](#案例实现)<br>

**7.导出功能** 导出json文件<br>
**8.生成三元组功能** 上传实例文件、myschema文件，可以生成相关数据的三元组文件，下载到本地<br>
参考- [案例实现](#案例实现)

<br>

# 问题反馈
我们提供长期技术维护和答疑解惑。如有疑问，请提交issues。
<br>

# 开发团队

郑国轴、李欣荣、甘坤、...、张文、陈华钧
