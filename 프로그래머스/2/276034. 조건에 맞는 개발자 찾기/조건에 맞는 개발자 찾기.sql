select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d
join SKILLCODES s on d.SKILL_CODE & s.CODE
where s.NAME = 'Python' or s.NAME = 'C#'
order by ID