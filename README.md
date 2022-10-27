# EasySchema


Website Pypi Pypi Documentation

An Open Source Library for Diverse Representation Learning of Knowledge Graphs

English | 中文

NeuralKG is a python-based library for diverse representation learning of knowledge graphs implementing Conventional KGEs, GNN-based KGEs, and Rule-based KGEs. We provide comprehensive documents for beginners and an online website to organize an open and shared KG representation learning community.


Table of Contents
Table of Contents
😃What's New
Oct, 2022
Sep, 2022
Jun, 2022
Mar, 2022
Feb, 2022
Overview
Demo
Implemented KGEs
Quick Start
Installation
Training
Evaluation
Hyperparameter Tuning
Reproduced Results
Notebook Guide
Detailed Documentation
Citation
NeuralKG Core Team

😃What's New
Oct, 2022
We add the DualE model for our library
Sep, 2022
We add the PairRE model for our library
Jun, 2022
We add the HAKE model for our library
Mar, 2022
We have provided Google Colab Tutotials help users use our library
We have provided a new blog about how to use NeuralKG on custom datasets
Feb, 2022
We have released a paper NeuralKG: An Open Source Library for Diverse Representation Learning of Knowledge Graphs

Overview

NeuralKG is built on PyTorch Lightning. It provides a general workflow of diverse representation learning on KGs and is highly modularized, supporting three series of KGEs. It has the following features:

Support diverse types of methods. NeuralKG, as a library for diverse representation learning of KGs, provides implementations of three series of KGE methods, including Conventional KGEs, GNN-based KGEs, and Rule-based KGEs.

Support easy customization. NeuralKG contains fine-grained decoupled modules that are commonly used in different KGEs, including KG Data Preprocessing, Sampler for negative sampling, Monitor for hyperparameter tuning, Trainer covering the training, and model validation.

long-term technical maintenance. The core team of NeuralKG will offer long-term technical maintenance. Other developers are welcome to pull requests.


Demo
There is a demonstration of NeuralKG.




Implemented KGEs
Components	Models
KGEModel	TransE, TransH, TransR, ComplEx, DistMult, RotatE, ConvE, BoxE, CrossE, SimplE, HAKE, PairRE, DualE
GNNModel	RGCN, KBAT, CompGCN, XTransE
RuleModel	ComplEx-NNE+AER, RUGE, IterE
Quick Start
Installation
Step1 Create a virtual environment using Anaconda and enter it

conda create -n neuralkg python=3.8
conda activate neuralkg
Step2 Install the appropriate PyTorch and DGL according to your cuda version

Here we give a sample installation based on cuda == 11.1

Install PyTorch
pip install torch==1.9.1+cu111 -f https://download.pytorch.org/whl/torch_stable.html
Install DGL
pip install dgl-cu111 dglgo -f https://data.dgl.ai/wheels/repo.html
Step3 Install package

From Pypi
pip install neuralkg
From Source
git clone https://github.com/zjukg/NeuralKG.git
cd NeuralKG
python setup.py install
Training
# Use bash script
sh ./scripts/your-sh

# Use config
python main.py --load_config --config_path <your-config>

Evaluation
python main.py --test_only --checkpoint_dir <your-model-path>
Hyperparameter Tuning
NeuralKG utilizes Weights&Biases supporting various forms of hyperparameter optimization such as grid search, Random search, and Bayesian optimization. The search type and search space are specified in the configuration file in the format "*.yaml" to perform hyperparameter optimization.

The following config file displays hyperparameter optimization of the TransE on the FB15K-237 dataset using bayes search:

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

Reproduced Results
There are some reproduced model results on FB15K-237 dataset using NeuralKG as below. See more results in here

Method	MRR	Hit@1	Hit@3	Hit@10
TransE	0.32	0.23	0.36	0.51
TransR	0.23	0.16	0.26	0.38
TransH	0.31	0.2	0.34	0.50
DistMult	0.30	0.22	0.33	0.48
ComplEx	0.25	0.17	0.27	0.40
SimplE	0.16	0.09	0.17	0.29
ConvE	0.32	0.23	0.35	0.50
RotatE	0.33	0.23	0.37	0.53
BoxE	0.32	0.22	0.36	0.52
HAKE	0.34	0.24	0.38	0.54
PairRE	0.35	0.25	0.38	0.54
DualE	0.33	0.24	0.36	0.52
XTransE	0.29	0.19	0.31	0.45
RGCN	0.25	0.16	0.27	0.43
KBAT*	0.28	0.18	0.31	0.46
CompGCN	0.34	0.25	0.38	0.52
IterE	0.26	0.19	0.29	0.41
*:There is a label leakage error in KBAT, so the corrected result is poor compared with the paper result. Details in deepakn97/relationPrediction#28


Notebook Guide
😃We use colab to provide some notebooks to help users use our library.

Colab Notebook


Detailed Documentation
https://zjukg.github.io/NeuralKG/neuralkg.html


Citation
Please cite our paper if you use NeuralKG in your work

@article{zhang2022neuralkg,
      title={NeuralKG: An Open Source Library for Diverse Representation Learning of Knowledge Graphs}, 
      author={Zhang, Wen and Chen, Xiangnan and Yao, Zhen and Chen, Mingyang and Zhu, Yushan and Yu, Hongtao and Huang, Yufeng and others},
      journal={arXiv preprint arXiv:2202.12571},
      year={2022},
}

NeuralKG Core Team
Zhejiang University: Wen Zhang, Xiangnan Chen, Zhen Yao, Mingyang Chen, Yushan Zhu, Hongtao Yu, Yufeng Huang, Zezhong Xu, Yajing Xu, Peng Ye, Yichi Zhang, Ningyu Zhang, Guozhou Zheng, Huajun Chen
