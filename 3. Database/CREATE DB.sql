USE PHARMA
DROP TABLE IF EXISTS [dbo].[Role]
CREATE TABLE [dbo].[Role](
	[RoleID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY ,
	[RoleName] [nvarchar](15) NULL UNIQUE,
	[Descr] [nvarchar](50) NULL)
GO
DROP TABLE IF EXISTS [dbo].[Category]
CREATE TABLE [dbo].[Category](
	[CatID] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL ,
	[CatName] [nvarchar](20) NULL UNIQUE,
	[Desc] [nvarchar](50) NULL
)
DROP TABLE IF EXISTS [dbo].[Unit]
CREATE TABLE [dbo].[Unit](
	[UnitID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Uname] [nvarchar](20) NULL UNIQUE,
	[UInStock] [int] NULL DEFAULT 0,
	[UInStockName] [nvarchar](20) NULL,
	[UInOrder] [int] NULL DEFAULT 0,
	[UInOrderName] [nvarchar](20) NULL,
	[Desc] [varchar](50) NULL)
GO
DROP TABLE IF EXISTS [dbo].[Supplier]
CREATE TABLE [dbo].[Supplier](
	[SupplierID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[ComCode] [nvarchar](15) NULL UNIQUE,
	[ComName] [nvarchar](200) NULL,
	[Address] [nvarchar](200) NULL,
	[Phone] [nvarchar](50) NULL,
	[Email] [nvarchar](30) NULL,
	[Tax] [nvarchar](50) NULL)
DROP TABLE IF EXISTS [dbo].[InventoryDetails]
CREATE TABLE [dbo].[InventoryDetails](
	[DetailsID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[DetailsCode][varchar](10) UNIQUE,
	[ProductID] [int] NOT NULL,
	[PName] [nvarchar](20) NULL,
	[PurchasePrice] [float] NULL,
	[TentativeSalesPrice] [float] NULL,
	[QuantityBought] [int] NULL DEFAULT 0,
	[QuantityAvailable] [int] NULL DEFAULT 0,
	[Batchid] [nvarchar](20) NULL,
	[ManufacturedDate] [datetime] NULL,
	[ExpiryDate] [datetime] NULL )
DROP TABLE IF EXISTS [dbo].[InventoryLedger]
CREATE TABLE [dbo].[InventoryLedger](
	[LegerID] [int] IDENTITY(1,1) NOT NULL,
	[LegerCode] [varchar](10) NOT NULL UNIQUE,
	[ProductID] [int] NOT NULL,
	[TransactionType] [char](1) NULL,
	[QuantityTransacted] [int] NULL DEFAULT 0,
	[InventoryPurchaseCost] [real] NULL,
	[DateTime] [timestamp] NULL,
	[DateKey] [int] NOT NULL,
	 CONSTRAINT Pk_InventoryLedger PRIMARY KEY([LegerID]))
DROP TABLE IF EXISTS [dbo].[ODetail]
CREATE TABLE [dbo].[ODetail](
	[ODetailID] [int] IDENTITY(1,1) NOT NULL,
	[OrderID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[PName] [nvarchar](20) NULL,
	[USP] [float] NULL,
	[HTU] [nvarchar](200) NULL,
	[Qty] [int] NULL DEFAULT 0,
	[Discount] [real] NULL,
	[Total] [real] NULL,
	CONSTRAINT Pk_Odetail PRIMARY KEY([ODetailID]))
GO
DROP TABLE IF EXISTS [dbo].[DateTag]
CREATE TABLE [dbo].[DateTag](
	[DateKey] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Date] Date NULL,
	[Month] varchar(20) NULL,
	[MonthNumber] int  NULL,
	[Year] int,
	[Quater] int)
DROP TABLE IF EXISTS [dbo].[Order]
CREATE TABLE [dbo].[Order](
	[OrderID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[DateKey] [int] NULL,
	[StaffID] [int] NOT NULL)
DROP TABLE IF EXISTS [dbo].[Product]
CREATE TABLE [dbo].[Product](
	[ProductID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[CatID] [int] NOT NULL,
	[UnitID] [int] NOT NULL,
	[SupplierID] [int] NOT NULL,
	[PName] [nvarchar](20) NULL,
	[PDescr] [nvarchar](50) NULL,
	[PComposition] [nvarchar](50) NULL,
	[PManufacturer] [nvarchar](50) NULL,
	[Uprice] [float] NULL,
	[USP] [float] NULL,
	[ReOrLevel] [int] NULL,
	[HTU] [nvarchar](500) NULL,
	[DefaultInDose][int] DEFAULT 2)
GO
DROP TABLE IF EXISTS [dbo].[Staff]
CREATE TABLE [dbo].[Staff](
	[StaffID] [int] IDENTITY(1,1) NOT NULL,
	[StaffCode] [varchar](10) NOT NULL UNIQUE,
	[RoleID] [int] NOT NULL,
	[FName] [nvarchar](100) NULL,
	[LName] [nvarchar](100) NULL,
	[DOB] [datetime] NULL,
	[Address] [nvarchar](30) NULL,
	[SEX] [char](1) NULL,
	[PhoneNo] [char](11) NULL,
	[Username] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](20) NOT NULL,
	CONSTRAINT Pk_Staff PRIMARY KEY([StaffID]))
GO

/****** Object:  Table [dbo].[Staff]    Script Date: 27/10/2019 11:55:11 AM ******/
ALTER TABLE [dbo].[InventoryDetails]  WITH CHECK ADD  CONSTRAINT [FK_INVENTOR_PRODUCTIN_PRODUCT] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
ALTER TABLE [dbo].[InventoryDetails] CHECK CONSTRAINT [FK_INVENTOR_PRODUCTIN_PRODUCT]
GO
ALTER TABLE [dbo].[InventoryLedger]  WITH CHECK ADD  CONSTRAINT [FK_INVENTOR_RELATIONS_PRODUCT] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[InventoryLedger] CHECK CONSTRAINT [FK_INVENTOR_RELATIONS_PRODUCT]
GO
ALTER TABLE [dbo].[ODetail]  WITH CHECK ADD  CONSTRAINT [FK_ODETAIL_PRODUCTOD_PRODUCT] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[ODetail] CHECK CONSTRAINT [FK_ODETAIL_PRODUCTOD_PRODUCT]
GO
ALTER TABLE [dbo].[ODetail]  WITH CHECK ADD  CONSTRAINT [FK_ODETAIL_RELATIONS_ORDER] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Order] ([OrderID])
GO
ALTER TABLE [dbo].[ODetail] CHECK CONSTRAINT [FK_ODETAIL_RELATIONS_ORDER]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_ORDER_DATEKEYOR_DATETAG] FOREIGN KEY([DateKey])
REFERENCES [dbo].[DateTag] ([DateKey])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_ORDER_DATEKEYOR_DATETAG]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_ORDER_STAFFORDE_STAFF] FOREIGN KEY([StaffID])
REFERENCES [dbo].[Staff] ([StaffID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_ORDER_STAFFORDE_STAFF]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCT_PRODUCTCA_CATEGORY] FOREIGN KEY([CatID])
REFERENCES [dbo].[Category] ([CatID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_PRODUCT_PRODUCTCA_CATEGORY]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCT_SUPPLIERP_SUPPLIER] FOREIGN KEY([SupplierID])
REFERENCES [dbo].[Supplier] ([SupplierID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_PRODUCT_SUPPLIERP_SUPPLIER]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCT_UNITPRODU_UNIT] FOREIGN KEY([UnitID])
REFERENCES [dbo].[Unit] ([UnitID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_PRODUCT_UNITPRODU_UNIT]
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD  CONSTRAINT [FK_STAFF_ROLESTAFF_ROLE] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([RoleID])
GO
ALTER TABLE [dbo].[Staff] CHECK CONSTRAINT [FK_STAFF_ROLESTAFF_ROLE]
GO
ALTER TABLE [dbo].[InventoryLedger]  WITH CHECK ADD  CONSTRAINT [FK_INVENTOR_RELATIONS_DATETAG] FOREIGN KEY([DateKey])
REFERENCES [dbo].[DateTag] ([DateKey])
GO
--PROC
CREATE PROCEDURE insertODetail
	@datetag int,
	@staff int,
	@id int OUT
AS
	insert into [Order] ([DateKey],[StaffID]) VALUES (@datetag,@staff)
SET
	@id=SCOPE_IDENTITY();
GO
--Insert DateTag
CREATE PROCEDURE insertDateTag
	@Date varchar(20),
	@Month varchar(20),
	@MonthNumber int,
	@Year int,
	@Quater int,
	@id int output
AS
INSERT INTO [dbo].[DateTag]([Date],[Month],[MonthNumber],[Year],[Quater])VALUES(@date,@Month,@MonthNumber,@Year,@Quater)
SET @id=@@IDENTITY
GO
