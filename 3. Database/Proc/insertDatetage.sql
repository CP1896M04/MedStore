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


