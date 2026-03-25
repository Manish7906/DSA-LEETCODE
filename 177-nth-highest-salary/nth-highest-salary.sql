CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE offset_val INT;
  SET offset_val = N - 1;

  RETURN (
      SELECT Salary
      FROM (
          SELECT DISTINCT Salary
          FROM Employee
          ORDER BY Salary DESC
      ) AS distinct_salaries
      LIMIT offset_val, 1
  );
END;