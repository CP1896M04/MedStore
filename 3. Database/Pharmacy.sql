/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     23/10/2019 10:37:16 PM                       */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('InventoryDetails') and o.name = 'FK_INVENTOR_PRODUCTIN_PRODUCT')
alter table InventoryDetails
   drop constraint FK_INVENTOR_PRODUCTIN_PRODUCT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('InventoryLedger') and o.name = 'FK_INVENTOR_RELATIONS_PRODUCT')
alter table InventoryLedger
   drop constraint FK_INVENTOR_RELATIONS_PRODUCT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ODetail') and o.name = 'FK_ODETAIL_PRODUCTOD_PRODUCT')
alter table ODetail
   drop constraint FK_ODETAIL_PRODUCTOD_PRODUCT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ODetail') and o.name = 'FK_ODETAIL_RELATIONS_ORDER')
alter table ODetail
   drop constraint FK_ODETAIL_RELATIONS_ORDER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"Order"') and o.name = 'FK_ORDER_DATEKEYOR_DATETAG')
alter table "Order"
   drop constraint FK_ORDER_DATEKEYOR_DATETAG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"Order"') and o.name = 'FK_ORDER_STAFFORDE_STAFF')
alter table "Order"
   drop constraint FK_ORDER_STAFFORDE_STAFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCT') and o.name = 'FK_PRODUCT_PRODUCTCA_CATEGORY')
alter table PRODUCT
   drop constraint FK_PRODUCT_PRODUCTCA_CATEGORY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCT') and o.name = 'FK_PRODUCT_SUPPLIERP_SUPPLIER')
alter table PRODUCT
   drop constraint FK_PRODUCT_SUPPLIERP_SUPPLIER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCT') and o.name = 'FK_PRODUCT_UNITPRODU_UNIT')
alter table PRODUCT
   drop constraint FK_PRODUCT_UNITPRODU_UNIT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Staff') and o.name = 'FK_STAFF_ROLESTAFF_ROLE')
alter table Staff
   drop constraint FK_STAFF_ROLESTAFF_ROLE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CATEGORY')
            and   type = 'U')
   drop table CATEGORY
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DateTag')
            and   type = 'U')
   drop table DateTag
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('InventoryDetails')
            and   name  = 'ProductinventorydetailsfkFk'
            and   indid > 0
            and   indid < 255)
   drop index InventoryDetails.ProductinventorydetailsfkFk
go

if exists (select 1
            from  sysobjects
           where  id = object_id('InventoryDetails')
            and   type = 'U')
   drop table InventoryDetails
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('InventoryLedger')
            and   name  = 'Relationship10Fk'
            and   indid > 0
            and   indid < 255)
   drop index InventoryLedger.Relationship10Fk
go

if exists (select 1
            from  sysobjects
           where  id = object_id('InventoryLedger')
            and   type = 'U')
   drop table InventoryLedger
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ODetail')
            and   name  = 'OderodetailfkFk'
            and   indid > 0
            and   indid < 255)
   drop index ODetail.OderodetailfkFk
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ODetail')
            and   name  = 'ProductodetailfkFk'
            and   indid > 0
            and   indid < 255)
   drop index ODetail.ProductodetailfkFk
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ODetail')
            and   type = 'U')
   drop table ODetail
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"Order"')
            and   name  = 'DatekeyorderfkFk'
            and   indid > 0
            and   indid < 255)
   drop index "Order".DatekeyorderfkFk
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"Order"')
            and   name  = 'StafforderfkFk'
            and   indid > 0
            and   indid < 255)
   drop index "Order".StafforderfkFk
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"Order"')
            and   type = 'U')
   drop table "Order"
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCT')
            and   name  = 'UnitproductfkFk'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCT.UnitproductfkFk
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCT')
            and   name  = 'SupplierProductFk'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCT.SupplierProductFk
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCT')
            and   name  = 'Relationship1Fk'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCT.Relationship1Fk
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PRODUCT')
            and   type = 'U')
   drop table PRODUCT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Role')
            and   type = 'U')
   drop table Role
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SUPPLIER')
            and   type = 'U')
   drop table SUPPLIER
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Staff')
            and   name  = 'RolestafffkFk'
            and   indid > 0
            and   indid < 255)
   drop index Staff.RolestafffkFk
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Staff')
            and   type = 'U')
   drop table Staff
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Unit')
            and   type = 'U')
   drop table Unit
go

/*==============================================================*/
/* Table: CATEGORY                                              */
/*==============================================================*/
create table CATEGORY (
   CatID                varchar(5)           not null,
   CatName              varchar(20)          null,
   "Desc"               varchar(50)          null,
   constraint PK_CATEGORY primary key nonclustered (CatID)
)
go

/*==============================================================*/
/* Table: DateTag                                               */
/*==============================================================*/
create table DateTag (
   DateKey              int                  not null,
   FullDateAlternateKey datetime             null,
   DayNumberOfWeek      tinyint              null,
   EnglishDayNameOfWeek nvarchar(10)         null,
   DayNumberOfMonth     tinyint              null,
   DayNumberOfYear      tinyint              null,
   WeekNumberOfYear     tinyint              null,
   EnglishMonthName     nvarchar(10)         null,
   MonthNumberOfYear    tinyint              null,
   CalendarQuarter      tinyint              null,
   CalendarYear         tinyint              null,
   CalendarSemester     tinyint              null,
   constraint PK_DATETAG primary key nonclustered (DateKey)
)
go

/*==============================================================*/
/* Table: InventoryDetails                                      */
/*==============================================================*/
create table InventoryDetails (
   DetailsID            bigint               not null,
   ProductID            int                  null,
   PurchasePrice        float                null,
   TentativeSalesPrice  float                null,
   QuantityBought       int                  null,
   QuantityAvailable    int                  null,
   Batchid              nvarchar(20)         null,
   ManufacturedDate     datetime             null,
   ExpiryDate           datetime             null,
   constraint PK_INVENTORYDETAILS primary key nonclustered (DetailsID)
)
go

/*==============================================================*/
/* Index: ProductinventorydetailsfkFk                           */
/*==============================================================*/
create index ProductinventorydetailsfkFk on InventoryDetails (
ProductID ASC
)
go

/*==============================================================*/
/* Table: InventoryLedger                                       */
/*==============================================================*/
create table InventoryLedger (
   LegerID              bigint               not null,
   ProductID            int                  null,
   TransactionType      char(1)              null,
   QuantityTransacted   int                  null,
   InventoryPurchaseCost float                null,
   DateTime             timestamp            null,
   constraint PK_INVENTORYLEDGER primary key nonclustered (LegerID)
)
go

/*==============================================================*/
/* Index: Relationship10Fk                                      */
/*==============================================================*/
create index Relationship10Fk on InventoryLedger (
ProductID ASC
)
go

/*==============================================================*/
/* Table: ODetail                                               */
/*==============================================================*/
create table ODetail (
   ODetailID            bigint               not null,
   OrderID              bigint               null,
   ProductID            int                  null,
   USP                  float                null,
   Qty                  int                  null,
   Discount             float(2)             null,
   Total                float                null,
   constraint PK_ODETAIL primary key nonclustered (ODetailID)
)
go

/*==============================================================*/
/* Index: ProductodetailfkFk                                    */
/*==============================================================*/
create index ProductodetailfkFk on ODetail (
ProductID ASC
)
go

/*==============================================================*/
/* Index: OderodetailfkFk                                       */
/*==============================================================*/
create index OderodetailfkFk on ODetail (
OrderID ASC
)
go

/*==============================================================*/
/* Table: "Order"                                               */
/*==============================================================*/
create table "Order" (
   OrderID              bigint               not null,
   DateKey              int                  null,
   StaffID              int                  null,
   constraint PK_ORDER primary key nonclustered (OrderID)
)
go

/*==============================================================*/
/* Index: StafforderfkFk                                        */
/*==============================================================*/
create index StafforderfkFk on "Order" (
StaffID ASC
)
go

/*==============================================================*/
/* Index: DatekeyorderfkFk                                      */
/*==============================================================*/
create index DatekeyorderfkFk on "Order" (
DateKey ASC
)
go

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT (
   ProductID            int                  not null,
   CatID                varchar(5)           null,
   UnitID               nvarchar(10)         null,
   SupplierID           nvarchar(5)          null,
   PName                nvarchar(20)         null,
   PDescr               nvarchar(50)         null,
   PComposition         nvarchar(50)         null,
   PManufacturer        nvarchar(50)         null,
   Uprice               float                null,
   USP                  float                null,
   ReOrLevel            int                  null,
   HTU                  nvarchar(500)        null,
   constraint PK_PRODUCT primary key nonclustered (ProductID)
)
go

/*==============================================================*/
/* Index: Relationship1Fk                                       */
/*==============================================================*/
create index Relationship1Fk on PRODUCT (
CatID ASC
)
go

/*==============================================================*/
/* Index: SupplierProductFk                                     */
/*==============================================================*/
create index SupplierProductFk on PRODUCT (
SupplierID ASC
)
go

/*==============================================================*/
/* Index: UnitproductfkFk                                       */
/*==============================================================*/
create index UnitproductfkFk on PRODUCT (
UnitID ASC
)
go

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role (
   RoleID               nvarchar(5)          not null,
   RoleName             nvarchar(15)         null,
   Descr                nvarchar(50)         null,
   constraint PK_ROLE primary key nonclustered (RoleID)
)
go

/*==============================================================*/
/* Table: SUPPLIER                                              */
/*==============================================================*/
create table SUPPLIER (
   SupplierID           nvarchar(5)          not null,
   ComName              nvarchar(15)         null,
   Address              nvarchar(30)         null,
   Phone                nvarchar(11)         null,
   Email                nvarchar(30)         null,
   Tax                  nvarchar(20)         null,
   constraint PK_SUPPLIER primary key nonclustered (SupplierID)
)
go

/*==============================================================*/
/* Table: Staff                                                 */
/*==============================================================*/
create table Staff (
   StaffID              int                  not null,
   RoleID               nvarchar(5)          null,
   FName                nvarchar(50)         null,
   LName                nvarchar(50)         null,
   DOB                  datetime             null,
   Address              nvarchar(30)         null,
   SEX                  char(1)              null,
   PhoneNo              char(11)             null,
   Username             nvarchar(15)         null,
   Password             nvarchar(20)         null,
   constraint PK_STAFF primary key nonclustered (StaffID)
)
go

/*==============================================================*/
/* Index: RolestafffkFk                                         */
/*==============================================================*/
create index RolestafffkFk on Staff (
RoleID ASC
)
go

/*==============================================================*/
/* Table: Unit                                                  */
/*==============================================================*/
create table Unit (
   UnitID               nvarchar(10)         not null,
   Uname                nvarchar(20)         null,
   UInStock             int                  null,
   UInStockName         nvarchar(20)         null,
   UInOrder             int                  null,
   UInOrderName         nvarchar(20)         null,
   "Desc"               varchar(50)          null,
   constraint PK_UNIT primary key nonclustered (UnitID)
)
go

alter table InventoryDetails
   add constraint FK_INVENTOR_PRODUCTIN_PRODUCT foreign key (ProductID)
      references PRODUCT (ProductID)
go

alter table InventoryLedger
   add constraint FK_INVENTOR_RELATIONS_PRODUCT foreign key (ProductID)
      references PRODUCT (ProductID)
go

alter table ODetail
   add constraint FK_ODETAIL_PRODUCTOD_PRODUCT foreign key (ProductID)
      references PRODUCT (ProductID)
go

alter table ODetail
   add constraint FK_ODETAIL_RELATIONS_ORDER foreign key (OrderID)
      references "Order" (OrderID)
go

alter table "Order"
   add constraint FK_ORDER_DATEKEYOR_DATETAG foreign key (DateKey)
      references DateTag (DateKey)
go

alter table "Order"
   add constraint FK_ORDER_STAFFORDE_STAFF foreign key (StaffID)
      references Staff (StaffID)
go

alter table PRODUCT
   add constraint FK_PRODUCT_PRODUCTCA_CATEGORY foreign key (CatID)
      references CATEGORY (CatID)
go

alter table PRODUCT
   add constraint FK_PRODUCT_SUPPLIERP_SUPPLIER foreign key (SupplierID)
      references SUPPLIER (SupplierID)
go

alter table PRODUCT
   add constraint FK_PRODUCT_UNITPRODU_UNIT foreign key (UnitID)
      references Unit (UnitID)
go

alter table Staff
   add constraint FK_STAFF_ROLESTAFF_ROLE foreign key (RoleID)
      references Role (RoleID)
go

