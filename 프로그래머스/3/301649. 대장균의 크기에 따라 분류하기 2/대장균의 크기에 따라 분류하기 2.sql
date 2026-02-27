-- 코드를 작성해주세요

select 
    ID, 
    case quarter
        when 1 then 'CRITICAL'
        when 2 then 'HIGH'
        when 3 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from 
    (   
        select ID, NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) as quarter
        from ecoli_data
    ) s
order by ID