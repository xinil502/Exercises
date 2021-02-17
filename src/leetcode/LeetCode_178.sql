# 178. 分数排名

SELECT Score,
       DENSE_RANK() OVER (ORDER BY Score DESC) AS 'Rank'
FROM Scores
ORDER BY Score DESC;