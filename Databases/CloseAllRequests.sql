UPDATE requests
SET state = 'Close'
WHERE AptId IN (SELECT AptId FROM Apartments WHERE BuildingID = 11)