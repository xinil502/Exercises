# 181. 超过经理收入的员工


SELECT e1.name AS Employee
FROM Employee e1
         LEFT JOIN Employee e2
                   ON e1.ManagerId = e2.Id
WHERE e1.Salary > e2.Salary