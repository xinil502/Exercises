#   1179.重新格式化部门表

# CASE
# WHEN s.sex = '1' THEN '男'
# WHEN s.sex = '2' THEN '女'
# else '空白'
# END AS sex

SELECT id,
       SUM(CASE WHEN month = 'Jan' THEN revenue ELSE null END) AS 'Jan_Revenue',
       SUM(CASE WHEN month = 'Feb' THEN revenue ELSE null END) AS 'Feb_Revenue',
       SUM(CASE WHEN month = 'Mar' THEN revenue ELSE null END) AS 'Mar_Revenue',
       SUM(CASE WHEN month = 'Apr' THEN revenue ELSE null END) AS 'Apr_Revenue',
       SUM(CASE WHEN month = 'May' THEN revenue ELSE null END) AS 'May_Revenue',
       SUM(CASE WHEN month = 'Jun' THEN revenue ELSE null END) AS 'Jun_Revenue',
       SUM(CASE WHEN month = 'Jul' THEN revenue ELSE null END) AS 'Jul_Revenue',
       SUM(CASE WHEN month = 'Aug' THEN revenue ELSE null END) AS 'Aug_Revenue',
       SUM(CASE WHEN month = 'Sep' THEN revenue ELSE null END) AS 'Sep_Revenue',
       SUM(CASE WHEN month = 'Oct' THEN revenue ELSE null END) AS 'Oct_Revenue',
       SUM(CASE WHEN month = 'Nov' THEN revenue ELSE null END) AS 'Nov_Revenue',
       SUM(CASE WHEN month = 'Dec' THEN revenue ELSE null END) AS 'Dec_Revenue'
FROM Department
GROUP BY id