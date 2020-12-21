#  596. 超过5名学生的课

#使用having过滤
SELECT class
FROM courses
GROUP BY class
having COUNT(DISTINCT student) > 4