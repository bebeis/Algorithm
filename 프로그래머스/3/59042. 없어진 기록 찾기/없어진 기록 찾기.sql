-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물
-- 동물 ID, 이름
-- ID 순으로 조회

SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS
WHERE ANIMAL_ID NOT IN (SELECT ANIMAL_ID FROM ANIMAL_INS)
ORDER BY ANIMAL_ID ASC