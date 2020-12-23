#  601. 体育馆的人流量


# 三表联查，条件过滤后去重。
SELECT DISTINCT s1.id,
                s1.visit_date,
                s1.people
FROM Stadium s1,
     Stadium s2,
     Stadium s3
WHERE s1.people >= 100
  AND s2.people >= 100
  AND s3.people >= 100
  AND ((s1.id - s2.id = 1 AND s2.id - s3.id = 1)
    OR (s1.id - s2.id = 1 AND s1.id - s3.id = -1)
    OR (s1.id - s2.id = -1 AND s2.id - s3.id = -1))
ORDER BY s1.id;

# 使用子查询，查出前后五天的人数合并为一条记录，之后过滤
SELECT id,
       visit_date,
       people
FROM (SELECT id,
             visit_date,
             people,
             LAG(people, 2) OVER (ORDER BY id)  AS pprvpeople,
             LAG(people, 1) OVER (ORDER BY id)  AS prvpeople,
             LEAD(people, 1) OVER (ORDER BY id) AS nextpeople,
             LEAD(people, 2) OVER (ORDER BY id) AS nnextpeople
      FROM stadium) AS people
WHERE (people >= 100 AND pprvpeople >= 100 AND prvpeople >= 100)
   OR (people >= 100 AND prvpeople >= 100 AND nextpeople >= 100)
   OR (people >= 100 AND nextpeople >= 100 AND nnextpeople >= 100);
