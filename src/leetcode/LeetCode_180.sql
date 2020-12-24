# 180.连续出现的数字


SELECT DISTINCT l1.Num AS ConsecutiveNums
FROM Logs l1
         LEFT JOIN Logs l2
                   ON l1.Id = l2.Id - 1
         LEFT JOIN Logs l3
                   ON l1.Id = l3.Id - 2
WHERE l1.Num = l2.Num
  AND l1.Num = l3.Num