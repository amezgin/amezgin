-- This query displays all the automobiles from the database "automobile".
SELECT * 
FROM automobile;

-- This query displays all the unused parts.
SELECT t.id, t.type, t.vendor
FROM transmission AS t
  LEFT OUTER JOIN automobile AS a ON t.id = a.transm_id
WHERE a.transm_id is null
UNION
SELECT e.id, e.type, e.vendor
FROM engine AS e
  LEFT OUTER JOIN automobile AS a ON e.id = a.engine_id
WHERE a.engine_id is null
UNION
SELECT g.id, g.type, g.vendor
FROM gearbox AS g
  LEFT OUTER JOIN automobile AS a ON g.id = a.gear_id
WHERE a.gear_id is null