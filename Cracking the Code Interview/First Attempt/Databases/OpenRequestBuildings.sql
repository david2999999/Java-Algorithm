SELECT BuildingName, ISNULL(Count, 0) as 'Count'
FROM Buildings
LEFT JOIN
  (SELECT Apartments.BuildingID, count(*) as 'Count'
   FROM Requests INNER JOIN Apartments
   ON Requests.AptID = Apartments.AptID
   WHERE Requests.Status = 'Open'
   GROUP BY Apartments.BuildingId
  ) ReqCounts
On ReqCounts.BuildingID = Buildings.BuildingID