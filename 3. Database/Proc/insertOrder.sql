ALTER PROCEDURE insertODetail
	@datetag int,
	@staff int,
	@id int OUT
AS
	insert into [Order] ([DateKey],[StaffID]) VALUES (@datetag,@staff)
SET
	@id=SCOPE_IDENTITY();
go
