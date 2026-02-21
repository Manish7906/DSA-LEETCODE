SELECT *
FROM Cinema c
WHERE id%2!=0  AND  c.description!="boring"
ORDER BY c.rating DESC;
