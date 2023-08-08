# 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    令牌
# https://github.com/HeHuiBinYa/crow-vue.git  前端
# https://github.com/HeHuiBinYa/crow-erp.git  后端

# 统一资源访问 IP:地址
# mysql 43.139.226.130 root He0087212.
# redis 43.139.226.130:6388

################################### 用户管理  ###################################

# 用户管理
drop database if exists CROW_ERP_USER;
create database CROW_ERP_USER;

use CROW_ERP_USER;

# 账户
drop table if exists SYS_ACCOUNT;
create table SYS_ACCOUNT(
    AID int auto_increment primary key comment '账户id，序号ID,主键,唯一,自增',
    USERNAME varchar(50) not null comment '账号',
    PASSWORD varchar(255) not null comment '密码',
    TOK varchar(255) not null comment '令牌',
    FREEZE bigint default 0 check ( freeze in (0,1) ) comment '0为启用,1为冻结'
);

insert into SYS_ACCOUNT(USERNAME,PASSWORD,TOK) values ('admin','670b14728ad9902aecba32e22fa4f6bd','c144f1d6-a7a8-481b-8574-9af970066e3c');

# 角色
drop table if exists ROLE;
create table SYS_ROLE(
    RID int auto_increment primary key comment '角色id，序号ID,主键,唯一,自增',
    ROLE varchar(255) not null comment '角色名',
    RDES varchar(255) comment '角色描述'
);

insert into SYS_ROLE(ROLE) values
('系统管理员'),
('生产管理员'),
('库存管理员'),
('产品设计管理员'),
('物流管理员'),
('采购管理员');

# 账户角色关联
drop table if exists ACCOUNT_ROLE;
create table ACCOUNT_ROLE(
    ARID int auto_increment primary key comment '序号ID,主键,唯一,自增',
    AID int not null comment '外键，账户id',
    RID int not null comment '外键，角色id',
    foreign key fk_aid_account(AID) references SYS_ACCOUNT(AID),
    foreign key fk_rid_account(RID) references SYS_ROLE(RID)
);

insert into ACCOUNT_ROLE(AID, RID) values (1,1);

################################### 人力管理  ###################################
# 人力管理
drop database if exists CROW_ERP_STAFF;
create database CROW_ERP_STAFF;

use CROW_ERP_STAFF;

# 员工资源关联表

# 部门表 (sys_department)
drop table if exists sys_department;
create table sys_department(
    did int auto_increment primary key comment '序号ID,主键,唯一,自增',
    dname varchar(50) not null comment '部门名称',
    position varchar(50) not null comment '部门职务',
    duty varchar(255) not null comment '部门职责',
    created datetime default now() comment '记录创建时间',
    updated datetime comment '记录更新时间'
);

# 职位表 （sys_position）
drop table if exists sys_position;
create table sys_position(
    pid int auto_increment primary key comment '序号ID,主键,唯一,自增',
    plevel varchar(50) not null comment '职位等级',
    psalary numeric(12,2) comment '职位薪资',
    position varchar(50) comment '职位',
    created datetime default now() comment '记录创建时间',
    updated datetime comment '记录更新时间'
);
-- 员工表（sys_employee）
drop table if exists sys_employee;
create table sys_employee(
    eid int auto_increment primary key comment '序号ID,主键,唯一,自增',
    staffid varchar(20) not null comment '员工编号',
    ename varchar(50) not null  comment '员工姓名',
    sex varchar(20) not null comment '员工性别',
    birth datetime not null comment '出生日期',
    place varchar(50) comment '出生地址',
    age int not null comment '员工年龄',
    tel varchar(50) comment '员工电话',
    card varchar(100) comment '身份证号码',
    entrytime datetime default now() comment '入职时间',
    leavetime datetime comment '离职时间',
    state varchar(10) default 'ZZ-01' check ( state in ('ZZ-01','ZZ-02') ) comment '在职状态,ZZ-01 在职 ZZ-02 离职',
    created datetime default now() comment '记录创建时间',
    updated datetime comment '记录更新时间'
);

drop table if exists sys_emp_association;
create table sys_emp_association(
    eaid int auto_increment primary key  comment '序号ID,主键,唯一,自增',
    eid int comment '外键 sys_employee(eid)',
    did int comment '外键 sys_department(did)',
    pid int comment '外键 sys_position(pid)',
    aid int comment '外键 sys_ACCOUNT(aid)',
    created datetime default now() comment '记录创建时间',
    updated datetime comment '记录更新时间',
    foreign key (eid) references sys_employee(eid),
    foreign key (did) references sys_department(did),
    foreign key (pid) references sys_position(pid),
    foreign key (aid) references CROW_ERP_USER.SYS_ACCOUNT(aid)
);

################################### 产品设计  ###################################

# 产品设计
drop database if exists CROW_ERP_DESIGN;
create database CROW_ERP_DESIGN;

use CROW_ERP_DESIGN;

# 产品档案管理设置数据库
# 表: 一级分类（sys_heroA）
drop table if exists sys_heroA;
create table sys_heroA(
    aid int primary key auto_increment comment '序号ID,主键,唯一,自增',
    aname varchar(255) not null comment '一级分类名称',
    created datetime default now() comment '记录创建时间',
    updated datetime comment '记录更新时间'
);

# 表: 二级分类（sys_heroB）
drop table if exists sys_heroB;
create table sys_heroB(
    bid int primary key auto_increment comment '序号ID,主键,唯一,自增',
    bname varchar(255) not null comment '二级分类名称',
    created datetime comment '记录创建时间',
    updated datetime comment '记录更新时间',
    aid int not null comment '外键, 关联到sys_heroA表的aid字段',
    foreign key (bid) references sys_heroA(aid)
);

# 表: 三级分类（sys_heroC）
drop table if exists sys_heroC;
create table sys_heroC(
    cid int primary key auto_increment comment '序号ID,主键,唯一,自增',
    cname varchar(255) not null comment '三级分类名称',
    created datetime  comment '记录创建时间',
    updated datetime comment '记录更新时间',
    bid int not null comment '外键, 关联到sys_heroB表的bid字段',
    foreign key (cid) references sys_heroB(bid)
);

# 产品档案管理数据库（sys_file）
drop table if exists sys_file;
create table sys_file(
  fid int primary key auto_increment comment '序号ID,主键,唯一,自增',
  pid varchar(50) not null comment '产品编号',
  name varchar(255) not null comment '产品名称',
  descr text comment '产品描述',
  aid int not null comment '外键, 关联到sys_heroA表的aid字段',
  bid int not null comment '外键, 关联到sys_heroB表的bid字段',
  cid int not null comment '外键, 关联到sys_heroC表的cid字段',
  type varchar(20) comment '用途类型',
  unit varchar(255) comment '计量单位',
  grou varchar(200) comment '供应商集合',
  costprice numeric(12,2) comment '成本单价',
  listprice numeric(12,2) comment '市场单价',
  register varchar(50) not null comment '登记人',
  checker varchar(50) not null comment '复核人',
  checktime datetime comment '复核时间',
  checktag varchar(20) check ( checktag in ('S001-0','S001-1','S001-2') ) comment '审核标志 :审核标志 S001-0: 等待审核 S001-1: 审核通过 S001-2: 审核不通过',
  created datetime comment '记录创建时间',
  updated datetime comment '记录更新时间',
  foreign key (aid) references sys_heroA(aid),
  foreign key (bid) references sys_heroB(bid),
  foreign key (cid) references sys_heroC(cid)
);

# 产品物料组成设计数据库(sys_materials)
drop table if exists sys_materials;
create table sys_materials(
    mid int primary key auto_increment comment '序号ID,主键,唯一,自增',
    design varchar(50) not null comment '物料组成设计单号',
    designer varchar(20) comment '设计人',
    registertime datetime comment '登记时间',
    register varchar(50) comment '登记人',
    checker varchar(50) comment '复核人',
    status varchar(50) check ( status in ('S001-0','S001-1','S001-2') ) comment '审核状态 ：S001-0: 等待审核 S001-1: 审核通过 S001-2: 审核不通过',
    designname varchar(50) comment '物料名称',
    type varchar(20) comment '用途类型',
    describer varchar(400) comment '描述',
    munit varchar(20) comment '单位',
    amount numeric(12,2) comment '数量',
    residual numeric(12,2) comment '可用数量',
    price numeric(12,2) comment '单价',
    pricesum numeric(12,2) comment '物流总成本',
    created datetime comment '记录创建时间',
    updated datetime comment '记录更新时间',
    fid int not null comment '产品编号 外键sys_file表的 product_id',
    foreign key (fid) references sys_file(fid)
);

################################### 库存管理  ###################################

drop database if exists CROW_ERP_INVENTORY;
create database CROW_ERP_INVENTORY;
use CROW_ERP_INVENTORY;

# 库存管理
# 安全库存配置管理数据库（sys_safetystock）：
drop table if exists sys_safetystock;
create table sys_safetystock(
    said int primary key auto_increment comment '序号ID,主键,唯一,自增',
    saconf varchar(50) not null comment '安全库存配置单号',
    fid int not null comment '产品编号 外键sys_file表的 fid',
    saname numeric(12,2) comment '产品名称',
    amount numeric(12,2) comment '当前存储',
    maxamount numeric(12,2) comment '库存最大储存',
    register varchar(50) comment '登记人',
    registertime datetime comment '登记时间',
    checker varchar(50) comment '复核人',
    checktime datetime comment '复核时间',
    checktag varchar(50) check ( checktag in ('A001-1','A001-2','A001-3') ) comment '审核状态 A001-1: 未审核 A001-2: 已通过 A001-3: 未通过',
    created datetime comment '记录创建时间',
    updated datetime comment '记录更新时间',
    foreign key (fid) references CROW_ERP_DESIGN.sys_file(fid)
);

# 入库申请管理数据库（sys_warehousing）：
drop table if exists sys_warehousing;
create table sys_warehousing(
  waid int auto_increment primary key comment '序号ID,主键,唯一,自增',
  wagatherid varchar(50) comment '入库申请单号',
  wastorer varchar(50) comment '入库人',
  wareason varchar(50) check ( wareason in ('R001-1','R001-2','R001-3','R001-4','R001-5') ) comment 'R001-1: 生产入库 R001-2: 库存初始 R001-3: 赠送 R001-4: 内部归还 R001-5: 其他归还',
  waamountsum numeric(12,2) comment '总件数',
  wacostpricesum numeric(12,2) comment '总金额',
  wagatheredamountsum numeric(12,2) comment '确认入库总件数',
  waremark varchar(50) comment '备注',
  waregister varchar(50) comment '登记人',
  waregistertime datetime comment '登记时间',
  wachecker varchar(50) comment '复核人',
  wacheckertime datetime comment '复核时间',
  wachecktag varchar(50) check ( wachecktag in ('S001-0','S001-1','S001-2') ) comment '审核状态 S001-0: 等待审核  S001-1: 审核通过  S001-2: 审核不通过',
  wastoretag varchar(20) check ( wastoretag in ('K002-1','K002-2') ) comment '库存标志  K002-1: 已登记  K002-2: 已调度',
  created datetime comment '记录创建时间',
  updated datetime comment '记录更新时间'
);

# 出入库调度管理数据库（sys_scheduling）：
drop table if exists sys_scheduling;
create table sys_scheduling(
    scid int auto_increment primary key comment '序号ID,主键,唯一,自增',
    scproductid varchar(50) comment '产品编号',
    scproductname varchar(50) comment '产品名称',
    scproductdescribe varchar(400) comment '描述',
    scamount numeric(12,2) comment '数量',
    scamountunit varchar(20) comment '单位',
    sccostprice numeric(12,2) comment '单价',
    scubtotal numeric(12,2) comment '小计',
    scgatheredamount numeric(12,2) comment '确认入库件数',
    scgathertag varchar(20) check ( scgathertag in ('K002-1','K002-2') ) comment '入库标志  K002-1: 已登记 K002-2: 已调度',
    waid int comment '入库申请单号 外键  入库表(sys_warehousing)',
    foreign key (waid) references sys_warehousing(waid)
);

# 表  出库(sys_pay)
drop table if exists sys_pay;
create table sys_pay(
    pid int auto_increment primary key comment '序号ID,主键,唯一,自增',
    payid varchar(50) comment '出库申请单号',
    pstorer varchar(50) comment '出库人',
    pseason varchar(20) check ( pseason in ('C002-1','C002-2','C002-3','C002-4') ) comment '出库理由 C002-1: 生产领料  C002-2: 赠送 C002-3: 内部借领 C002-4: 其他借领 ',
    pamountsum numeric(12,2) comment '总件数',
    pcostpricesum numeric(12,2) comment '总金额',
    pgatheredamountsum numeric(12,2) comment '确认出库总件数',
    premark varchar(200) comment '备注',
    pregister varchar(50) comment '登记人',
    pregistertime datetime comment '登记时间',
    pchecker varchar(50) comment '复核人',
    pchecktime datetime comment '复核时间',
    pchecktag varchar(50) check (pchecktag in ('S001-0','S001-1','S001-2') ) comment '审核状态 S001-0: 等待审核  S001-1: 审核通过  S001-2: 审核不通过',
    created datetime comment '记录创建时间',
    updated datetime comment '记录更新时间'
);

# 表 出库明细(sys_paydetails)
drop table if exists sys_paydetails;
create table sys_paydetails(
    pdid int auto_increment primary key comment '序号ID,主键,唯一,自增',
    pdproduceid varchar(50) comment '产品编号',
    pdpriducename varchar(50) comment '产品名称',
    pdproductdesribe varchar(400) comment '描述',
    pdamount numeric(12,2) comment '数量',
    pdamountunit varchar(20) comment '单位',
    pdcostprice numeric(12,2) comment '单价',
    pdsuntotal numeric(12,2) comment '小计',
    pdpaidamount numeric(12,2) comment '确认出库件数',
    pdpaytag varchar(20) check ( pdpaytag in ('K002-1','K002-2') ) comment '出库标志  K002-1: 已登记 K002-2: 已调度',
    pid int comment '出库申请单号 外键  出库表(sys_pay) pid',
    foreign key (pid) references sys_pay(pid)
);

################################### 生产管理  ###################################

drop database CROW_ERP_PRODUCT;
create database CROW_ERP_PRODUCT;

use CROW_ERP_PRODUCT;

# 生产管理

# 表: 生产总表(sys_manufacture)
drop table if exists sys_manufacture;
create table sys_manufacture(
    maid int auto_increment primary key comment '序号ID,主键,唯一,自增',
    manufactureid varchar(50) not null comment '派工单编号',
    maproductid varchar(50) not null comment '产品编号',
    maproductname varchar(50) not null comment '产品名称',
    maamount numeric(12,2) not null  comment '投产数量',
    matesteramount numeric(12,2) comment '合格数量',
    maapplyidgroup varchar(400) comment '生产计划序号组',
    maproductdescribe varchar(400) comment '产品描述',
    mamodulecostpricesum numeric(12,2) comment '设计物料总成本',
    marealmodulecostpricesum numeric(12,2) comment '实际物料总成本',
    malabourcostpricesum numeric(12,2) comment '设计工时总成本',
    mareallabourcostpricesum numeric(12,2) comment '实际工时总成本',
    madesigner varchar(50) comment '工单制定人',
    maregister varchar(50) comment '登记人',
    maregistertime date comment '登记时间',
    machecker varchar(50) comment '审核人',
    machecktime date comment '审核时间',
    maremapk varchar(400) comment '备注',
    machecktag varchar(20) check ( machecktag in  ('S001-0','S001-1','S001-2')) comment '审核标志 S001-0: 等待审核 S001-1: 审核通过 S001-2: 审核不通过',
    manufacturepriceduretag varchar(20) check ( manufacturepriceduretag in ('S002-0','S002-1','S002-2') ) comment '生产过程标志 S002-0: 待登记 S002-1: 未完工 S002-2: 已完工',
    mafid  int comment '外键 产品档案管理数据库 id',
    foreign key (mafid) references CROW_ERP_DESIGN.sys_file(fid)
);

# 表: 生产工序表(sys_procedure)
drop table if exists sys_procedure;
create table sys_procedure(
    prid int auto_increment primary key comment '序号ID,主键,唯一,自增',
    prdetailsnumber numeric(6) comment '工序序号',
    prprocedureid varchar(50) comment '工序编号',
    procedurename varchar(50) comment '工序名称',
    prlabourhouramount numeric(12,2) comment '设计工时数',
    prreallabourhouramount numeric(12,2) comment '实际工时数',
    prsubtotal numeric(12,2) comment '设计工时成本',
    prrealsubtotal numeric(12,2) comment '实际工时成本',
    prmodulesubtotal numeric(12,2) comment '设计物料成本',
    prrealmodulesubtotal numeric(12,2) comment '实际物料成本',
    prcostprice numeric(12,2) comment '单位工时成本',
    prdemandamount numeric(12,2) comment '工序投产数量',
    prrealamount numeric(12,2) comment '工序合格数量',
    procedurefinishtag varchar(20) check ( procedurefinishtag in ('G004-0','G004-1','G004-2','G004-3') ) comment '工序完成标志 G004-0: 未开始 G004-1: 已完成 G004-2: 未完成 G004-3: 已审核',
    proceduretransfertag varchar(20) check ( proceduretransfertag in ('G005-0','G005-1','G005-2') ) comment '工序交接标志 G005-0: 未交接 G005-1: 已交接 G005-2: 已审核',
    maid int comment '父级序号  sys_manufacture的maid 外键',
    foreign key (maid) references sys_manufacture(maid)
);

select * from sys_procedure;

insert into sys_procedure(procedurefinishtag,proceduretransfertag,maid) values ('G004-0','G005-0',3);
update sys_procedure set procedurefinishtag = 'G004-0',proceduretransfertag= 'G005-0' where prid = 1;

# 表: 工序物料关联表(sys_pma)
drop table if exists sys_pma;
create table sys_pma(
  pmid int auto_increment primary key  comment '序号ID,主键,唯一,自增',
  pmrid int not null comment '外键关联生产工序表(sys_manufacture) prid',
  mid int not null  comment '外键关联产品物料组成设计数据库(sys_materials) mid',
  foreign key (pmid) references sys_procedure(prid),
  foreign key (mid) references CROW_ERP_DESIGN.sys_materials(mid)
);

################################### 系统管理  ###################################
select * from sys_department WHERE dname like concat('%','R','%') or position like concat('%','','%') or duty like concat('%','','%') LIMIT 15
