SELECT d.Name    AS Department,
       e1.name   AS Employee,
       e1.Salary AS Salary
FROM Employee AS e1
         inner join Department AS d ON e1.DepartmentId = d.Id
WHERE 3 > (
    SELECT COUNT(DISTINCT e2.Salary)
    FROM Employee e2
    WHERE e2.Salary > e1.Salary
      AND e1.DepartmentId = e2.DepartmentId
)



# 同一部门内 ，第一高工资 比他高的工资 个数为0 ,
# 第二高工资 ,比他的高的 工资个数为1，
# 同理 第三高为2。
# 因此 只要查出 在同一部门内
# 其他的工资>该员工的薪资 的个数小于3
# 那么他就为同一部门的前三高工资 ，即为子查询里面的条件
# WHERE 判断使用子查询：
#         以e1表为基础，查出e2表中有多少人的工资比e1的这个人大。
#         使用count计数，distinct 按照工资数去重
# 这样的e1就是我们要的e1，再使用join on连接部门表。