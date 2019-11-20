USE PHARMA
ALTER VIEW InventoryAvailable
AS
SELECT ProductID, SUM(QuantityAvailable) AS "QuantityAvailable"
FROM InventoryDetails
WHERE Status='Working'
GROUP BY ProductID

SELECT * FROM InventoryAvailable WHERE ProductID=2

SELECT ProductID, SUM(QuantityAvailable) AS "QuantityAvailable"
FROM InventoryDetails
WHERE Status='Working'
GROUP BY ProductID


SELECT  ProductID,QuantityAvailable,ExpiryDate 
FROM InventoryDetails 
WHERE ProductID=5
ORDER BY ExpiryDate ASC

ALTER PROCEDURE subtractInventory
	@ProductID varchar(20) ,
	@Bachid  nvarchar(20),
	@Qty int
AS
DECLARE @QuantityAvailable INT;
SET @QuantityAvailable = (SELECT [QuantityAvailable] FROM [dbo].[InventoryDetails] WHERE [ProductID]=@ProductID AND [Batchid]=@Bachid);
UPDATE [dbo].[InventoryDetails] SET [QuantityAvailable]=[QuantityAvailable]-@Qty WHERE [ProductID]=@ProductID AND [Batchid]=@Bachid

GO

EXEC subtractInventory 5,11,10


DECLARE @QuantityAvailable INT;
SET @QuantityAvailable = (SELECT [QuantityAvailable] FROM [dbo].[InventoryDetails] WHERE [ProductID]=5 AND [Batchid]=111);
UPDATE [dbo].[InventoryDetails] SET [QuantityAvailable]=[QuantityAvailable]-11 WHERE [ProductID]=5 AND [Batchid]=111
