-- 평균 대여 기간이 7일 이상인 자동차
-- 자동차 ID와 평균 대여 기간 출력
-- 평균 대여 기간은 소수점 두번째 자리에서 반올림
-- 결과는 평균 대여 기간을 기준으로 내림차순 정렬, -> 자동차 ID를 기준으로 내림차순 정렬

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVG(DATEDIFF(END_DATE, START_DATE) + 1) >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC