-- 코드를 입력하세요
with recursive TIMES as (
    select 0 as HOUR
    
    UNION ALL
    
    select (HOUR + 1) as HOUR from TIMES where HOUR < 23
)

select t.HOUR as HOUR, IFNULL(c.cnt, 0) as COUNT
from TIMES t
left join (SELECT HOUR(DATETIME) as HOUR, count(*) as cnt
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)) c
ON t.HOUR = c.HOUR
order by HOUR