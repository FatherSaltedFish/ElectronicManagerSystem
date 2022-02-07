电力工程信息管理系统

项目分析

​	1、项目为基准

​	2、能够通过项目查询到所有支出、收入、采购产品、发票信息、客户信息、合同信息扫描件、发票信息、是否受到甲方是公款的时间，并计算出利润率、盈亏金额。

​	3、项目完成后按照总金额的1%，按照设置比例给项目经理和项目参与人员。离职自动转接给交接同事，没有则重新划分。

​	3、未完成提醒经理跟进。



​	表格建立

​		1、项目表 Project

​				项目编号 <u>Project_Id</u>

​				项目名称 Project_Name

​				项目成本 Project_Cost

​				项目预计完成时间 Project_Time

​				项目总金额 Project_Money

​				项目是否完成 Project_Finish

​				项目完成时间 Project_Finish_Time

​		2、支出表 Cost

​				支出编号 <u>Cost_id</u>

​				项目编号 <u>Project_Id</u>

​				支出金额 Cost_Number

​				支出时间 Cost_Time

​				支出附件 Cost_detail

​		3、人员表 People

​					人员编号 <u>People_Id</u>

​					人员名称 People_Name

​		4、项目人员表Project_People

​					项目编号 <u>Project_Id</u>

​					人员编号 <u>People_Id</u>

​					是否为项目经理 Manager_Decide

​					奖金占比  PercentC

​		5、管理人员表 Manager

​					账号 <u>Manager_Id</u>

​					密码 Manager_Password

​					用户名称 Manager_Name

​		6、客户信息表  information

​					项目编号 <u>Project_Id</u>

​					客户信息 Project_information



​		方法管理

- [x] ​			1、登入注册

- [x] ​			2、查看所有项目


- [x] ​			3、查看项目花销

- [x] ​			4、添加项目花销

- [x] ​			5、修改项目花销

- [x] ​			6、管理项目成员

- [x] ​			7、查看客户信息

- [ ] ​			8、生成奖金表


​				