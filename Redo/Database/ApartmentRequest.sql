SELECT BuildingName, ISNULL(Count, 0) as 'Count'
FROM Buildings LEFT JOIN
  (SELECT Apartments.BuildingID, count(*) as 'Count'
   FROM Requests INNER JOIN Apartments
   ON Request.Id = Apartments.AptId
   WHERE Request.status = 'Open'
   GROUP BY Apartments.BuildingId
  ) ReqCounts
ON ReqCounts.BuildingID = Buildings.BuildingID