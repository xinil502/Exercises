# 177. 第N高的薪水
# 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
#
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
#


#三重查询
# 最内层： 对Salary进行去重
# 中间层： 使用排名函数排名，构建新的视图
# 最外层： 查找排名第 N 的工资。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        SELECT t.Salary
        FROM (
                 SELECT ROW_NUMBER() OVER (ORDER BY tt.Salary DESC) AS number,
                        tt.Salary                                   AS Salary
                 FROM (
                          SELECT DISTINCT Salary
                          FROM Employee
                      ) tt
             ) AS t
        WHERE t.number = N
    );
END