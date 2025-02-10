-- 자동차 정보 테이블
-- 자동차 대여 기록 정보 테이블
-- 자동차 종류 별 대여 기간 종류 별 할인 정책 정보 테이블

-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능
-- 30일간의 대여 금액이 50만원 이상 200만원 미만
-- 자동차 ID, 자동차 종류, 대여 금액(FEE) 출력 (FEE의 경우 예시처럼 정수부분만 출력)
-- 대여 금액을 기준으로 내림차순 정렬하고, 
-- 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 
-- 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬

SELECT CAR_ID, CAR_TYPE, TRUNCATE(DAILY_FEE * 30 * ((100 - DISCOUNT_RATE) / 100), 0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
NATURAL JOIN (
    SELECT CAR_TYPE, DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE DURATION_TYPE = '30일 이상'
    ) P
WHERE CAR_TYPE IN('세단', 'SUV') 
AND DAILY_FEE * 30 * ((100 - DISCOUNT_RATE) / 100) BETWEEN 500000 AND 1999999
AND NOT EXISTS (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    WHERE C.CAR_ID = H.CAR_ID AND START_DATE <= '2022-11-30'
        AND END_DATE >= '2022-11-01'
    )
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC