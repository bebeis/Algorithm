-- 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물
-- 중성화된 동물의 아이디와 생물 종, 이름을 조회
-- 아아디 순 조회
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE like '%Intact%' AND 
(O.SEX_UPON_OUTCOME like '%Spayed%' OR O.SEX_UPON_OUTCOME like '%Neutered%')
ORDER BY ANIMAL_ID ASC