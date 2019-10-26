USE [SQL Pharmacy]
GO
/****** Object:  Table [dbo].[CATEGORY]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CATEGORY](
	[CatID] [int] IDENTITY(1,1) NOT NULL,
	[CatName] [nvarchar](20) NULL,
	[Desc] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DateTag]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DateTag](
	[DateKey] [int] NOT NULL,
	[FullDateAlternateKey] [datetime] NULL,
	[DayNumberOfWeek] [tinyint] NULL,
	[EnglishDayNameOfWeek] [nvarchar](10) NULL,
	[DayNumberOfMonth] [tinyint] NULL,
	[DayNumberOfYear] [tinyint] NULL,
	[WeekNumberOfYear] [tinyint] NULL,
	[EnglishMonthName] [nvarchar](10) NULL,
	[MonthNumberOfYear] [tinyint] NULL,
	[CalendarQuarter] [tinyint] NULL,
	[CalendarYear] [tinyint] NULL,
	[CalendarSemester] [tinyint] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[InventoryDetails]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InventoryDetails](
	[DetailsID] [int] IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NOT NULL,
	[PurchasePrice] [float] NULL,
	[TentativeSalesPrice] [float] NULL,
	[QuantityBought] [int] NULL,
	[QuantityAvailable] [int] NULL,
	[Batchid] [nvarchar](20) NULL,
	[ManufacturedDate] [datetime] NULL,
	[ExpiryDate] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[InventoryLedger]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InventoryLedger](
	[LegerID] [int] IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NOT NULL,
	[TransactionType] [char](1) NULL,
	[QuantityTransacted] [int] NULL,
	[InventoryPurchaseCost] [float] NULL,
	[DateTime] [timestamp] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ODetail]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ODetail](
	[ODetailID] [int] IDENTITY(1,1) NOT NULL,
	[OrderID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[USP] [float] NULL,
	[Qty] [int] NULL,
	[Discount] [real] NULL,
	[Total] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[DateKey] [int] NULL,
	[StaffID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PRODUCT]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRODUCT](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
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
	[HTU] [nvarchar](500) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[RoleID] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](15) NULL,
	[Descr] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Staff]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Staff](
	[StaffID] [int] IDENTITY(1,1) NOT NULL,
	[RoleID] [int] NOT NULL,
	[FName] [nvarchar](50) NULL,
	[LName] [nvarchar](50) NULL,
	[DOB] [datetime] NULL,
	[Address] [nvarchar](30) NULL,
	[SEX] [char](1) NULL,
	[PhoneNo] [char](11) NULL,
	[Username] [nvarchar](15) NULL,
	[Password] [nvarchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SUPPLIER]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SUPPLIER](
	[SupplierID] [int] IDENTITY(1,1) NOT NULL,
	[ComName] [nvarchar](15) NULL,
	[Address] [nvarchar](30) NULL,
	[Phone] [nvarchar](11) NULL,
	[Email] [nvarchar](30) NULL,
	[Tax] [nvarchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Unit]    Script Date: 10/26/2019 11:38:40 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Unit](
	[UnitID] [int] IDENTITY(1,1) NOT NULL,
	[Uname] [nvarchar](20) NULL,
	[UInStock] [int] NULL,
	[UInStockName] [nvarchar](20) NULL,
	[UInOrder] [int] NULL,
	[UInOrderName] [nvarchar](20) NULL,
	[Desc] [varchar](50) NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CATEGORY] ON 

INSERT [dbo].[CATEGORY] ([CatID], [CatName], [Desc]) VALUES (1, N'GIẢM ĐAU HẠ SỐT', NULL)
INSERT [dbo].[CATEGORY] ([CatID], [CatName], [Desc]) VALUES (2, N'KHÁNG DỊ ỨNG', NULL)
INSERT [dbo].[CATEGORY] ([CatID], [CatName], [Desc]) VALUES (3, N'DẠ DÀY TÁ TRÀNG', NULL)
INSERT [dbo].[CATEGORY] ([CatID], [CatName], [Desc]) VALUES (4, N'KHÁNG SINH', NULL)
INSERT [dbo].[CATEGORY] ([CatID], [CatName], [Desc]) VALUES (5, N'THỰC PHẨM CHỨC NĂNG', NULL)
SET IDENTITY_INSERT [dbo].[CATEGORY] OFF
SET IDENTITY_INSERT [dbo].[PRODUCT] ON 

INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (8, 2, 1, 1, N'Acezin DHG', NULL, N'Alimemazin', N'DHG Pharma', 300, 305, NULL, N'SÁNG : 1 Viên , CHIỀU : 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (9, 2, 2, 2, N'Alimazin 5mg', NULL, N'Trimeprazine', N'IMEXPHARM', 250, 255, NULL, N'SÁNG : 1 Viên , CHIỀU : 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (10, 2, 3, 1, N'Clorpheniramin 4mg', NULL, N'Clorpheniramin', N'DHG Pharma', 400, 405, NULL, N'CHIỀU : 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (12, 2, 1, 1, N'CLORPHENIRAMIN 4MG', NULL, N'Clorpheniramin', N'Dược Phẩm 3/2
', 255, 257, NULL, N'CHIỀU : 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (13, 1, 1, 1, N'Hapacol 650
', NULL, N'Paracetamol
', N'DHG Pharma
', 250, 255, NULL, N'SÁNG : 1 Viên , CHIỀU : 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (14, 1, 1, 1, N'Panadol Extra
', NULL, N'Paracetamol
', N'GSK PHARMAR
', 500, 555, NULL, N'SÁNG : 1 Viên , CHIỀU : 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (23, 1, 1, 1, N'Meloxicam STADA
', NULL, N'Meloxicam 
', N'STADA
', 450, 455, NULL, N'SÁNG : 1 Viên, Chiều 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (24, 1, 2, 1, N'MELOXICAM 7.5mg
', NULL, N'Meloxicam 
', N'DƯỢC PHẨM 2/9
', 230, 235, NULL, N'SÁNG : 1 Viên, Chiều 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (25, 4, 3, 2, N'CEFDINIR 300
', NULL, N'Cefdinir
', N'DHG Pharma
', 600, 650, NULL, N'SÁNG : 1 Viên, Chiều 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (26, 4, 3, 2, N'Amoxicillin 250mg
', NULL, N'Amoxicilline
', N'DOMESCO
', 200, 255, NULL, N'SÁNG : 1 Viên, Chiều 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (27, 4, 3, 2, N'Cephalexin 500 mg
', NULL, N'Cephalexin
', N'Dược phẩm Cửu Long
', 320, 325, NULL, N'SÁNG : 1 Viên, Chiều 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (28, 4, 1, 2, N'HAPENXIN
', NULL, N'Cephalexin monohydrat 
', N'DHG Pharma
', 400, 425, NULL, N'SÁNG : 1 Viên, Chiều 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (29, 3, 2, 3, N'Omeprazol DHG
', NULL, N'Omeprazol
', N'DHG Pharma
', 380, 400, NULL, N'SÁNG : 1 Viên, Chiều 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (30, 3, 4, 3, N'Phosphalugel®
', NULL, N'Phosphalugel®
', N'Pharmatis - PHÁP
', 550, 560, NULL, N'SÁNG : 1 Gói , Chiều : 1 Gói')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (31, 3, 3, 3, N'Cimetidine 300mg
', NULL, N'Cimetidine
', N'MekoPhar 
', 350, 360, NULL, N'SÁNG : 1 Viên, Chiều 1 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (34, 5, 1, 4, N'Bảo Khí Khang 
', NULL, N'Cao Lá Hen
', N'IMC 
', 180000, 185000, NULL, N'SÁNG : 2 Viên , Chiều : 2 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (35, 5, 1, 4, N'Ích Mẫu Lợi Nhi
', NULL, N'Thiên môn chùm
', N'IMC 
', 240000, 245000, NULL, N'SÁNG : 2 Viên , Chiều : 2 Viên')
INSERT [dbo].[PRODUCT] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU]) VALUES (36, 5, 1, 4, N'Ích Niệu Khang
', NULL, N'Cao Đỗ Trọng
', N'IMC 
', 150000, 155000, NULL, N'SÁNG : 2 Viên , Chiều : 2 Viên')
SET IDENTITY_INSERT [dbo].[PRODUCT] OFF
SET IDENTITY_INSERT [dbo].[SUPPLIER] ON 

INSERT [dbo].[SUPPLIER] ([SupplierID], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (1, N'DƯỢC PHANAM', N'CẦN THƠ', N')909123123', N'phanam@gamil.com', NULL)
INSERT [dbo].[SUPPLIER] ([SupplierID], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (2, N'DƯỢC HẬU GIANG', N'CẦN THƠ', NULL, NULL, NULL)
INSERT [dbo].[SUPPLIER] ([SupplierID], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (3, N'DƯỢC HỒNG MAI', N'CẦN THƠ', NULL, NULL, NULL)
INSERT [dbo].[SUPPLIER] ([SupplierID], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (4, N'DƯỢC PHAVI', N'HCM', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[SUPPLIER] OFF
SET IDENTITY_INSERT [dbo].[Unit] ON 

INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (1, N'CAPS', 10, N'BLISTER', 2, N'BOX', N'BOX 2 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (2, N'CAPS', 10, N'BLISTER', 10, N'BOX', N'BOX 10 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (3, N'CAPS', 10, N'BLISTER', 5, N'BOX', N'BOX 3 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (4, N'CAPS', 20, N'BLISTER', 10, N'BOX', N'BOX 10 BLISTER x 20 CAPS')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (5, N'PACK', 30, N'BOX', 1, N'BOX', N'BOX 30 PACK')
SET IDENTITY_INSERT [dbo].[Unit] OFF
/****** Object:  Index [PK_CATEGORY]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[CATEGORY] ADD  CONSTRAINT [PK_CATEGORY] PRIMARY KEY NONCLUSTERED 
(
	[CatID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_DATETAG]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[DateTag] ADD  CONSTRAINT [PK_DATETAG] PRIMARY KEY NONCLUSTERED 
(
	[DateKey] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_INVENTORYDETAILS]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[InventoryDetails] ADD  CONSTRAINT [PK_INVENTORYDETAILS] PRIMARY KEY NONCLUSTERED 
(
	[DetailsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_INVENTORYLEDGER]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[InventoryLedger] ADD  CONSTRAINT [PK_INVENTORYLEDGER] PRIMARY KEY NONCLUSTERED 
(
	[LegerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_ODETAIL]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[ODetail] ADD  CONSTRAINT [PK_ODETAIL] PRIMARY KEY NONCLUSTERED 
(
	[ODetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_ORDER]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[Order] ADD  CONSTRAINT [PK_ORDER] PRIMARY KEY NONCLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_PRODUCT]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[PRODUCT] ADD  CONSTRAINT [PK_PRODUCT] PRIMARY KEY NONCLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_ROLE]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[Role] ADD  CONSTRAINT [PK_ROLE] PRIMARY KEY NONCLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_STAFF]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[Staff] ADD  CONSTRAINT [PK_STAFF] PRIMARY KEY NONCLUSTERED 
(
	[StaffID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_SUPPLIER]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[SUPPLIER] ADD  CONSTRAINT [PK_SUPPLIER] PRIMARY KEY NONCLUSTERED 
(
	[SupplierID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PK_UNIT]    Script Date: 10/26/2019 11:38:41 AM ******/
ALTER TABLE [dbo].[Unit] ADD  CONSTRAINT [PK_UNIT] PRIMARY KEY NONCLUSTERED 
(
	[UnitID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[InventoryDetails]  WITH CHECK ADD  CONSTRAINT [FK_INVENTOR_PRODUCTIN_PRODUCT] FOREIGN KEY([ProductID])
REFERENCES [dbo].[PRODUCT] ([ProductID])
GO
ALTER TABLE [dbo].[InventoryDetails] CHECK CONSTRAINT [FK_INVENTOR_PRODUCTIN_PRODUCT]
GO
ALTER TABLE [dbo].[InventoryLedger]  WITH CHECK ADD  CONSTRAINT [FK_INVENTOR_RELATIONS_PRODUCT] FOREIGN KEY([ProductID])
REFERENCES [dbo].[PRODUCT] ([ProductID])
GO
ALTER TABLE [dbo].[InventoryLedger] CHECK CONSTRAINT [FK_INVENTOR_RELATIONS_PRODUCT]
GO
ALTER TABLE [dbo].[ODetail]  WITH CHECK ADD  CONSTRAINT [FK_ODETAIL_PRODUCTOD_PRODUCT] FOREIGN KEY([ProductID])
REFERENCES [dbo].[PRODUCT] ([ProductID])
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
ALTER TABLE [dbo].[PRODUCT]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCT_PRODUCTCA_CATEGORY] FOREIGN KEY([CatID])
REFERENCES [dbo].[CATEGORY] ([CatID])
GO
ALTER TABLE [dbo].[PRODUCT] CHECK CONSTRAINT [FK_PRODUCT_PRODUCTCA_CATEGORY]
GO
ALTER TABLE [dbo].[PRODUCT]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCT_SUPPLIERP_SUPPLIER] FOREIGN KEY([SupplierID])
REFERENCES [dbo].[SUPPLIER] ([SupplierID])
GO
ALTER TABLE [dbo].[PRODUCT] CHECK CONSTRAINT [FK_PRODUCT_SUPPLIERP_SUPPLIER]
GO
ALTER TABLE [dbo].[PRODUCT]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCT_UNITPRODU_UNIT] FOREIGN KEY([UnitID])
REFERENCES [dbo].[Unit] ([UnitID])
GO
ALTER TABLE [dbo].[PRODUCT] CHECK CONSTRAINT [FK_PRODUCT_UNITPRODU_UNIT]
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD  CONSTRAINT [FK_STAFF_ROLESTAFF_ROLE] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([RoleID])
GO
ALTER TABLE [dbo].[Staff] CHECK CONSTRAINT [FK_STAFF_ROLESTAFF_ROLE]
GO
