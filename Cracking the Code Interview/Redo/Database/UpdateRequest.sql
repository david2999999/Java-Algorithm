UPDATE Requests
SET Status = 'Closed'
WHERE AptId IN (SELECT AptId FROM Apartments WHERE BuildingID = 11)