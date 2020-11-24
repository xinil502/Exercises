# 184. 部门工资最高的员工

# 查出最高工资和部门，使用in进行判断是否包含在内。

SELECT d.Name    AS Department,
       e1.Name   AS Employee,
       e1.Salary AS Salary
FROM Employee e1
         INNER JOIN Department AS d
                    ON e1.DepartmentId = d.Id
WHERE (e1.Salary, e1.DepartmentId) in (
    SELECT MAX(e2.Salary), e2.DepartmentId
    FROM Employee e2
    GROUP BY e2.DepartmentId
)