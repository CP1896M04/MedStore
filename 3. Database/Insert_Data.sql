INSERT [dbo].[Category] ([CatName], [Desc]) VALUES (N'Pain', N'Pain')
INSERT [dbo].[Category] ([CatName], [Desc]) VALUES (N'AHis', N'Antihistamines')
INSERT [dbo].[Category] ([CatName], [Desc]) VALUES (N'Gis',N'GastricStomach and colon')
INSERT [dbo].[Category] ([CatName], [Desc]) VALUES (N'AntiBio', N'Antibiotics ')
INSERT [dbo].[Category] ([CatName], [Desc]) VALUES (N'FFood', N'functional foods')
GO
INSERT [dbo].[Supplier] ([ComName], [Address], [Phone], [Email], [Tax], [ComCode]) VALUES (N'MerapGroup', N'CẦN THƠ', N'8499123123', N'phanam@gamil.com', NULL, N'MG')
INSERT [dbo].[Supplier] ([ComName], [Address], [Phone], [Email], [Tax], [ComCode]) VALUES (N'DHG PHARMA Corp', N'288 Bis Nguyen', N'0292891433', N'dhgpharma@dhgpharma.com.vn', NULL, N'DHG')
INSERT [dbo].[Supplier] ([ComName], [Address], [Phone], [Email], [Tax], [ComCode]) VALUES (N'DƯỢC HỒNG MAI', N'CẦN THƠ', NULL, N'hongmaipharma@yahoo.com.vn', NULL, N'HM')
INSERT [dbo].[Supplier] ([ComName], [Address], [Phone], [Email], [Tax], [ComCode]) VALUES (N'DƯỢC PHAVI', N'HCM', NULL, NULL, NULL, N'PHAVI')
GO
INSERT [dbo].[Unit] ([Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (N'CAPS', 10, N'BLISTER', 2, N'BOX', N'BOX 2 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (N'CAPS', 10, N'BLISTER', 10, N'BOX', N'BOX 10 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (N'CAPS', 10, N'BLISTER', 5, N'BOX', N'BOX 3 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (N'CAPS', 20, N'BLISTER', 10, N'BOX', N'BOX 10 BLISTER x 20 CAPS')
INSERT [dbo].[Unit] ([Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (N'PACK', 30, N'BOX', 1, N'BOX', N'BOX 30 PACK')
GO

