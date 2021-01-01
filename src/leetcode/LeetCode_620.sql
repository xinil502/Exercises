#  620.有趣的电影

SELECT c.id,
       c.movie,
       c.description,
       c.rating
FROM cinema c
WHERE c.description != 'boring'
  AND c.id % 2 = 1
ORDER BY c.rating DESC