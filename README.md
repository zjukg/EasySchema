
<!--<p align="center">
    <a href=""> <img src="pics/logo.png" width="400"/></a>
<p>
<p align="center">  
    <a href="http://neuralkg.zjukg.cn/">
        <img alt="Website" src="https://img.shields.io/badge/website-online-orange">
    </a>
    <a href="https://pypi.org/project/neuralkg/">
        <img alt="Pypi" src="https://img.shields.io/pypi/v/neuralkg">
    </a>
    <a href="https://github.com/zjukg/NeuralKG/blob/main/LICENSE">
        <img alt="Pypi" src="https://img.shields.io/badge/license-Apache--2.0-yellowgreen">
    </a>
    <a href="">
        <img alt="LICENSE" src="https://img.shields.io/badge/license-MIT-brightgreen">
    </a>
    <a href="https://zjukg.github.io/NeuralKG/index.html">
        <img alt="Documentation" src="https://img.shields.io/badge/Doc-online-blue">
    </a>
</p>-->
<h1 align="center">
    <p>EasySchema</p>
    <p>开放的中文图谱schema编辑工具</p>
</h1>

EasySchema是一个支持cnSchema中文图谱的编辑工具，其中实现了对cnSchema实体和属性表进行编辑并生成用户自定义的MySchema概念和属性表，以及生成MySchema三元组文件。同时为初学者提供了详细的[文档](https://zjukg.github.io/.../index.html)以及一个开放共享的知识图谱学习社区[网站](http://cnschema.openkg.cn/)。

<br>

# 目录

<!--
- [目录](#目录)
- [😃最新消息](#最新消息)
  - [2022年10月](#2022年10月)
  - [2022年9月](#2022年9月)
  - [2022年6月](#2022年6月)
  - [2022年3月](#2022年3月)
  - [2022年2月](#2022年2月)
- [工具概览](#工具概览)
- [运行示例](#运行示例)
- [实现模型](#实现模型)
- [快速上手](#快速上手)
  - [下载](#下载)
  - [模型训练](#模型训练)
  - [模型测试](#模型测试)
  - [超参调节](#超参调节)
- [复现结果](#复现结果)
- [Notebook教程](#notebook教程)
- [详细文档](#详细文档)
- [引用](#引用)
- [NeuralKG核心团队](#neuralkg核心团队)-->
<!-- * [To do](#to-do) -->

<br>

<!--
# 😃最新消息
## 2022年10月
* 我们添加了[DualE](https://ojs.aaai.org/index.php/AAAI/article/view/16850)模型

## 2022年9月
* 我们添加了[PairRE](https://arxiv.org/pdf/2011.03798.pdf)模型

## 2022年6月
* 我们添加了[HAKE](https://arxiv.org/abs/1911.09419)模型

## 2022年3月
* 我们提供了一个[Google Colab教程](https://drive.google.com/drive/folders/1OyuxvdjRNFzRuheNZaGGCsPe75T1pW1P?usp=sharing)帮助用户使用我们的工具包
* 我们提供了一篇[博客](http://neuralkg.zjukg.org/uncategorized/neuralkg-for-recommendation%ef%bf%bc/)来介绍我们的工具包在自定义数据集上的使用方式

## 2022年2月
* 我们发布了关于该工具包的论文[NeuralKG: An Open Source Library for Diverse Representation Learning of Knowledge Graphs](https://arxiv.org/abs/2202.12571)
-->
<br>

# 工具概览
<!--
<h3 align="center">
    <img src="pics/overview.png", width="600">
</h3>



NeuralKG工具包整体基于[PyTorch Lightning](https://www.pytorchlightning.ai/)框架，并提供了一个用于多种知识图谱表示学习模型的通用工作流程且高度模块化。NeuralKG具有如下特性：

+  **支持多种方法。** NeuralKG提供了对三类知识图谱嵌入方法的代码实现，包括**传统知识图谱嵌入**, **基于图神经网络的知识图谱嵌入**, 以及**基于规则的知识图谱嵌入**。


+ **方便快速的客制化。** NeuralKG对知识图谱表示模型进行细化的模块解耦以方便使用者快速定制自己的模型，其中包括知识图谱数据处理模块，负采样模块，超参数监控模块，训练模块以及模型验证模块。这些模块被广泛应用于不同的知识图谱嵌入模型中
+ **长期技术支持。** NeuralKG的核心开发团队将提供长期的技术支持，同时我们也欢迎开发者们对本项目进行pull requests。
-->
<br>

# 运行示例

<!--
NeuralKG在自定义知识图谱demo_kg上运行的示例。

<img src="pics/demo.gif">-->


<br>

# 技术栈
小工具是前台是基于vue + d3.js ,后台是springboot
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

# 快速上手

## 下载
<!--
**Step1** 使用 ```Anaconda``` 创建虚拟环境，并进入虚拟环境

```bash
conda create -n neuralkg python=3.8
conda activate neuralkg
```
**Step2** 下载适用您CUDA版本的的PyTorch的DGL，下面我们提供一个基于CUDA 11.1的下载样例 

+  下载PyTorch
```
pip install torch==1.9.1+cu111 -f https://download.pytorch.org/whl/torch_stable.html
```
+ 下载DGL
```
pip install dgl-cu111 dglgo -f https://data.dgl.ai/wheels/repo.html
```

**Step3** 安装NeuralKG

+ 基于Pypi
```bash
pip install neuralkg
```

+ 或基于源码

```bash
git clone https://github.com/zjukg/NeuralKG.git
cd NeuralKG
python setup.py install
```
## 模型训练
```
# Use bash script
sh ./scripts/your-sh

# Use config
python main.py --load_config --config_path <your-config>

```

## 模型测试
```
python main.py --test_only --checkpoint_dir <your-model-path>
```
## 超参调节
NeuralKG使用[Weights&Biases](https://wandb.ai/site)进行超参数调节，支持多种超参优化例如网格搜索、随机搜索和贝叶斯优化。搜索类型和搜索空间可以通过配置（*.yaml）文件进行设置。

下面展示了在FB15k-237上训练TransE，并使用贝叶斯搜索（bayes search）进行超参数调节的配置文件：

```
command:
  - ${env}
  - ${interpreter}
  - ${program}
  - ${args}
program: main.py
method: bayes
metric:
  goal: maximize
  name: Eval|hits@10
parameters:
  dataset_name:
    value: FB15K237
  model_name:
    value: TransE
  loss_name:
    values: [Adv_Loss, Margin_Loss]
  train_sampler_class:
    values: [UniSampler, BernSampler]
  emb_dim:
    values: [400, 600]
  lr:
    values: [1e-4, 5e-5, 1e-6]
  train_bs:
    values: [1024, 512]
  num_neg:
    values: [128, 256]
```
<br>

# 复现结果
下面展示了使用NeuralKG的不同模型在FB15k-237上的结果，更多结果请访问[此处](https://zjukg.github.io/NeuralKG/result.html)。


|Method | MRR | Hit@1 | Hit@3 | Hit@10 |
|:------:|:---:|:-----:|:-----:|:------:|
|TransE|0.32|0.23|0.36|0.51|
|TransR|0.23|0.16|0.26|0.38|
|TransH|0.31|0.2|0.34|0.50|
|DistMult|0.30|0.22|0.33|0.48|
|ComplEx|0.25|0.17|0.27|0.40|
|SimplE|0.16|0.09|0.17|0.29|
|ConvE|0.32|0.23|0.35|0.50|
|RotatE|0.33|0.23|0.37|0.53|
|BoxE|0.32|0.22|0.36|0.52|
|HAKE|0.34|0.24|0.38|0.54|
|PairRE|0.35|0.25|0.38|0.54|
|DualE|0.33|0.24|0.36|0.52|
|XTransE|0.29|0.19|0.31|0.45|
|RGCN|0.25|0.16|0.27|0.43|
|KBAT*|0.28|0.18|0.31|0.46|
|CompGCN|0.34|0.25|0.38|0.52|
|IterE|0.26|0.19|0.29|0.41|

*:在KBAT的原论文作者实现中存在标签泄漏的问题，所以正确的结果相对较低，具体可以查看https://github.com/deepakn97/relationPrediction/issues/28
-->
<br>

# Notebook教程

<!--
😃我们使用colab提供部分notebook供用户使用我们的工具包

[![Colab Notebook](https://colab.research.google.com/assets/colab-badge.svg)](https://drive.google.com/drive/folders/1OyuxvdjRNFzRuheNZaGGCsPe75T1pW1P?usp=sharing)
-->
<br>

# 未来计划
我们提供长期技术维护和答疑解惑。如有疑问，请提交issues
<!--
https://zjukg.github.io/NeuralKG/neuralkg.html-->


<!-- <br> -->

<!-- # To do -->

<br>

# 引用
<!--
如果您使用了NeuralKG，请引用我们的论文

```bibtex
@article{zhang2022neuralkg,
      title={NeuralKG: An Open Source Library for Diverse Representation Learning of Knowledge Graphs}, 
      author={Zhang, Wen and Chen, Xiangnan and Yao, Zhen and Chen, Mingyang and Zhu, Yushan and Yu, Hongtao and Huang, Yufeng and others},
      journal={arXiv preprint arXiv:2202.12571},
      year={2022},
}

```
-->
<br>

# 核心团队

**浙江大学**: <!--张文，陈湘楠，姚祯，陈名杨，朱渝珊，俞洪涛，黄雨峰，许泽众，徐雅静，叶鹏，张溢弛，张宁豫，郑国轴，陈华钧-->
