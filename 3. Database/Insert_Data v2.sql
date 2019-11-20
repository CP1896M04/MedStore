USE [PHARMA]
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (1, N'Dược Hồng Mai', N'')
INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (2, N'Dược Thanh Hóa', N'')
INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (3, N'Dược Phano', N'')
INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (4, N'Dược Tây Nam Bộ', N'')
INSERT [dbo].[Category] ([CatID], [CatName], [Desc]) VALUES (5, N'Dược OPC', N'')
SET IDENTITY_INSERT [dbo].[Category] OFF

GO

SET IDENTITY_INSERT [dbo].[DateTag] ON 
INSERT [dbo].[DateTag] ([DateKey], [Date], [Month], [MonthNumber], [Year], [Quater]) VALUES (1, CAST(N'2019-11-19' AS Date), N'December', 11, 2019, 4)
INSERT [dbo].[DateTag] ([DateKey], [Date], [Month], [MonthNumber], [Year], [Quater]) VALUES (2, CAST(N'2019-11-20' AS Date), N'December', 11, 2019, 4)
SET IDENTITY_INSERT [dbo].[DateTag] OFF

GO

SET IDENTITY_INSERT [dbo].[Role] ON 
INSERT [dbo].[Role] ([RoleID], [RoleName], [Descr]) VALUES (1, N'admin', N'123')
SET IDENTITY_INSERT [dbo].[Role] OFF

GO

SET IDENTITY_INSERT [dbo].[Staff] ON 
INSERT [dbo].[Staff] ([StaffID], [StaffCode], [RoleID], [FName], [LName], [DOB], [Address], [SEX], [PhoneNo], [Username], [Password]) VALUES (1, N'duy', 1, N'Nguyen Phuc ', N'Duy', CAST(N'2019-11-07T00:00:00.000' AS DateTime), N'Long an', N'F', N'01656107877', N'duy', N'123')
SET IDENTITY_INSERT [dbo].[Staff] OFF

GO

SET IDENTITY_INSERT [dbo].[Supplier] ON 
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (1, N'MG', N'MerapGroup', N'CẦN THƠ', N'8499123123', N'phanam@gamil.com', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (2, N'DHG', N'DHG PHARMA Corp', N'288 Bis Nguyen', N'0292891433', N'dhgpharma@dhgpharma.com.vn', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (3, N'IMX', N'IMEXPHARM', N'Số 4 Đường 30/4 - Phường 1 - TP. Cao Lãnh - Tỉnh Đồng Tháp', N'02773879941', N'vanphong@imexpharm.com', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (4, N'GSK', N'GSK PHARMAR', N'Tòa nhà The Metropolitan, Phòng 701, 235 Đồng Khởi, Quận 1, Thành phố Hồ Chí Minh, Việt Nam', N'0838248744', N'vn.customer-relations@gsk.com', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (5, N'IMC', N'Fobic Pharmar', N'Lô TT09, Nam Đô Complex, số 609 Trương Định, Phường Thịnh Liệt, Quận Hoàng Mai, Hà Nội', N'024.6262.7647', NULL, NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (6, N'MK', N'MekoPharmar', N'297/5 Lý Thường Kiệt, Quận 11, Tp Hồ Chí Minh, Việt Nam', N'0283865025838650363', N'info.mekopharmar@gmail.com', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (7, N'ST', N'STANDA', N'K63/1 Nguyễn Thị Sóc, Xuân Thới Đông, Hóc Môn, TP. Hồ Chí Minh', N' 02743767470', N'stada@stada.com.vn', NULL)
INSERT [dbo].[Supplier] ([SupplierID], [ComCode], [ComName], [Address], [Phone], [Email], [Tax]) VALUES (8, N'PH', N'Pharmatis - PHÁP', N'PHÁP', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Supplier] OFF

GO

SET IDENTITY_INSERT [dbo].[Unit] ON 
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (1, N'CAPS 10x2', 10, N'BLISTER', 2, N'BOX', N'BOX 2 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (2, N'PACK', 30, N'BOX', 1, N'BOX', N'BOX 30 PACK')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (3, N'CAPS 10x10', 10, N'BLISTER', 10, N'BOX', N'BOX 10 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (4, N'CAPS 10x5', 10, N'BILSTER', 5, N'BOX', N'BOX 5 BLISTER x 10 CAPS')
INSERT [dbo].[Unit] ([UnitID], [Uname], [UInStock], [UInStockName], [UInOrder], [UInOrderName], [Desc]) VALUES (5, N'CAPS 20x10', 20, N'BLISTER', 10, N'BOX', N'BOX 10 BLISTER x 20 CAPS')
SET IDENTITY_INSERT [dbo].[Unit] OFF

GO

SET IDENTITY_INSERT [dbo].[Product] ON 
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (1, 1, 1, 2, N'Acezin DHG', N'NHÓM THUỐC KHÁNG DỊ ỨNG ', N'Alimemazin', N'Ho do dị ứng, do kích thích, nhất là về ban đêm', 320, 320, 0, N'Sáng 1 Viên , Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (2, 4, 1, 3, N'Alimazin 5mg', N'NHÓM THUỐC KHÁNG DỊ ỨNG ', N'Trimeprazine', N'Ho do dị ứng, do kích thích, nhất là về ban đêm', 500, 500, 1, N'Sáng 1 Viên , Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (3, 3, 1, 2, N'Clorpheniramin 4mg', N'NHÓM THUỐC KHÁNG DỊ ỨNG ', N'Clorpheniramin', N'Trị sổ mũi, hắt hơi, ngứa mũi, ngứa cổ họng...', 450, 450, 1, N'Sáng 1 Viên , Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (4, 2, 1, 1, N'CLORPHENIRAMIN 4MG', N'NHÓM THUỐC KHÁNG DỊ ỨNG ', N'Clorpheniramin', N'Trị sổ mũi, hắt hơi, ngứa mũi, ngứa cổ họng', 320, 320, 1, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (5, 1, 3, 2, N'Hapacol 650', N'GIẢM ĐAU HẠ SỐT', N'Paracetamol', N'Giảm đau hạ sốt...', 450, 450, 2, N'Sáng 1 Viên , Chiều 1 Viên ', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (6, 3, 3, 4, N'Panadol Extra', N'GIẢM ĐAU HẠ SỐT', N'Paracetamol', N'Giảm đau hạ sốt', 520, 520, 2, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (7, 3, 4, 1, N'Meloxicam STADA', N'GIẢM ĐAU HẠ SỐT', N'Meloxicam ', N'Giảm đau, Hạ sốt, Kháng viêm', 610, 610, 1, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (8, 1, 4, 7, N'MELOXICAM 7.5mg', N'GiẢM ĐAU HẠ SỐT', N'Meloxicam ', N'Giảm đau, Hạ sốt, Kháng viêm', 1025, 1025, 1, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (9, 1, 4, 2, N'CEFDINIR 300', N'NHÓM KHÁNG SINH', N'Cefdinir', N'Nhiễm khuẩn đường hô hấp trên', 1000, 1000, 3, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (10, 1, 3, 2, N'Cephalexin 500 mg', N'NHÓM KHÁNG SINH', N'Cephalexin', N'Tác dụng trên các vi khuẩn gram dương như tụ cầu..', 460, 460, 2, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (11, 1, 3, 2, N'HAPENXIN', N'NHÓM KHÁNG SINH', N'Cephalexin monohydrat ', N'Tác dụng trên các vi khuẩn gram dương như tụ cầu..', 350, 350, 3, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (12, 1, 3, 1, N'Amoxicillin 250mg', N'NHÓM KHÁNG SINH', N'Amoxicilline', N'Nhiễm khuẩn đường hô hấp trên', 230, 230, 3, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (13, 1, 5, 2, N'Omeprazol DHG', N'DẠ DÀY TÁ TRÀNG', N'Omeprazol', N'Loét dạ dày tá tràng…', 480, 480, 3, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (14, 5, 2, 8, N'Phosphalugel®', N'DẠ DÀY TÁ TRÀNG', N'Phosphalugel®', N'Thuốc kháng axit, chống trào ngược và chống loét', 7000, 7000, 1, N'Sáng 1 Gói, Chiều 1 Gói', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (15, 2, 1, 6, N'Cimetidine 300mg', N'DẠ DÀY TÁ TRÀNG', N'Cimetidine', N'Điều trị ngắn hạn loét dạ dày, tá tràng', 1300, 1300, 1, N'Sáng 1 Viên, Chiều 1 Viên', 2)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (16, 1, 5, 5, N'BẢO KHÍ KHANG', N'THỰC PHẨM CHỨC NĂNG', N'Cao Lá Hen', N'Điều trị hen, ho có đờm, COPD', 5000, 5000, 1, N'Sáng 2 Viên, Chiều 2 Viên', 4)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (17, 1, 5, 5, N'ICH MẪU LỢI NHI', N'THỰC PHẨM CHỨC NĂNG', N'Thiên môn chùm', N'Bồi bổ khí huyết. Hỗ trợ bài tiết sữa', 7000, 7000, 1, N'Sáng 2 Viên, Chiều 2 Viên', 4)
INSERT [dbo].[Product] ([ProductID], [CatID], [UnitID], [SupplierID], [PName], [PDescr], [PComposition], [PManufacturer], [Uprice], [USP], [ReOrLevel], [HTU], [DefaultInDose]) VALUES (18, 1, 5, 5, N'ÍCH NIỆU KHANG', N'THỰC PHẨM CHỨC NĂNG', N'Cao Đỗ Trọng', N'Tiểu đêm, tiểu nhiều lần, bàng quang tăng hoạt', 6500, 6500, 1, N'Sáng 2 Viên, Chiều 2 Viên', 4)
SET IDENTITY_INSERT [dbo].[Product] OFF

GO