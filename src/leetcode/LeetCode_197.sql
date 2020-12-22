# 197. 上升的温度

SELECT w1.id
FROM Weather w1
         JOIN Weather w2
              ON dateDiff(w1.RecordDate, w2.RecordDate) = 1
                  AND w1.Temperature > w2.Temperature


# 日期时间不能单纯的加1
# 错误示例：
SELECT w1.id
FROM Weather w1
         JOIN Weather w2
              ON w1.RecordDate = w2.RecordDate + 1
                  AND w1.Temperature > w2.Temperature

#  要用关键字 interval 并且用day表示加的是一天，如果这里写month或者year就表示加1个月或1年
#  datediff(日期1, 日期2)： 得到的结果是日期1与日期2相差的天数。 如果日期1比日期2大，结果为正；如果日期1比日期2小，结果为负。

