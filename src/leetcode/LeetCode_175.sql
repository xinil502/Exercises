# 175. 组合两个表
# LEFT JOIN 左外连接，左表为主表
# RIGHT JOIN 右外连接，右表为主表
# INNER JOIN 内连接，求交集
SELECT p.FirstName AS FirstName,
       p.LastName  AS LastName,
       a.City      AS City,
       a.State     AS State
FROM Person AS p
         LEFT JOIN Address AS a ON p.PersonId = a.PersonId