-- 12세 이하인 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회
-- 전화번호 없으면 NONE
-- 나이 내림차준 - 환자이름 오름차순

SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE')
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC