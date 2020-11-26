#626. 换座位

# 一开始思路是根据id换名字，最后是题解使用换id的方法。判断方法都是case大致相同。
# 使用case判断
# mod = 1有两种情况：不增id和增id
# mod = 0时id后退
SELECT (CASE
            WHEN MOD(id, 2) = 1 AND id = (SELECT MAX(id) FROM seat) THEN id
            WHEN MOD(id, 2) = 1 THEN id + 1
            ELSE id - 1 END
           ) AS id,
       student
FROM seat
ORDER BY id ASC;

# 评论区方法，根据(id-1)^1排序
select rank() over (order by (id - 1) ^ 1) as id, student
from seat