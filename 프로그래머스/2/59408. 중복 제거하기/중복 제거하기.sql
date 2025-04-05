-- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회
-- 이름이 NULL인 경우는 집계하지 않고, 중복되는 이름은 하나로

WITH CTE AS (
    SELECT DISTINCT NAME
    FROM ANIMAL_INS
    WHERE NAME IS NOT NULL
)

SELECT COUNT(*)
FROM CTE