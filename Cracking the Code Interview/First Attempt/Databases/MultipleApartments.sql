SELECT TenantName
FROM Tenants
INNER JOIN
  (SELECT TenantID FROM AptTenants GROUP BY TenantID HAVING COUNT(*) > 1) C
ON Tenants.TenantId = C.TenantID