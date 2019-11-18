USE [PHARMA]
GO
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([RoleID], [RoleName], [Descr]) VALUES (1, N'admin', N'123')
SET IDENTITY_INSERT [dbo].[Role] OFF
SET IDENTITY_INSERT [dbo].[Staff] ON 

INSERT [dbo].[Staff] ([StaffID], [StaffCode], [RoleID], [FName], [LName], [DOB], [Address], [SEX], [PhoneNo], [Username], [Password]) VALUES (1, N'duy', 1, N'Nguyen Phuc ', N'Duy', CAST(N'2019-11-07T00:00:00.000' AS DateTime), N'Long an', N'F', N'01656107877', N'duy', N'123')
SET IDENTITY_INSERT [dbo].[Staff] OFF
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (1, N'Pain', N'Pain')
INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (2, N'AHis', N'Antihistamines')
INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (3, N'Gis', N'GastricStomach and colon')
INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (4, N'AntiBio', N'Antibiotics ')
INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (5, N'FFood', N'functional foods')
SET IDENTITY_INSERT [dbo].[Category] OFF
SET IDENTITY_INSERT [dbo].[Unit] ON 

INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (1, N'CAPS', 10, N'BLISTER', 2, N'BOX', N'BOX 2 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (5, N'PACK', 30, N'BOX', 1, N'BOX', N'BOX 30 PACK')
SET IDENTITY_INSERT [dbo].[Unit] OFF
SET IDENTITY_INSERT [dbo].[Supplier] ON 

INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (1, N'MG', N'MerapGroup', N'CẦN THƠ', N'8499123123', N'phanam@gamil.com', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (2, N'DHG', N'DHG PHARMA Corp', N'288 Bis Nguyen', N'0292891433', N'dhgpharma@dhgpharma.com.vn', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (3, N'HM', N'DƯỢC HỒNG MAI', N'CẦN THƠ', NULL, N'hongmaipharma@yahoo.com.vn', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (4, N'PHAVI', N'DƯỢC PHAVI', N'HCM', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Supplier] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (1, 2, 5, 2, N'Product1', N'Mo ta', N'Paracetamol', N'DHG', 1000, 1, 1, N'??', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (2, 2, 5, 2, N'nguyenphucduy', N'ssssss', N'ddddddd', N'ưsssssssss', 1, 1, 1, N'sssss', 1)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (3, 2, 5, 2, N'sua', N'uong', N'sua', N'uong', 1, 1, 1, N'uong', 2)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[InventoryDetails] ON 

INSERT [dbo].[InventoryDetails] ([DetailsID], [DetailsCode], [ProductID], [PurchasePrice], [TentativeSalesPrice], [QuantityBought], [QuantityAvailable], [Batchid], [ManufacturedDate], [ExpiryDate]) VALUES (1, N'', 2, 1, 3.5, 4, 3, N'DHGPR', CAST(N'2019-11-06T00:00:00.000' AS DateTime), CAST(N'2019-11-28T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[InventoryDetails] OFF
