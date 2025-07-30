-- 동일한 날짜, 회원 ID, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재
-- 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수와 상품을 구매한 회원의 비율을 년, 월 별로 출력
-- =2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수
-- YEAR, MONTH, PURCHASED_USERS, PUCHASED_RATIO
-- 상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림
-- 년을 기준으로 오름차순 정렬해주시고 년이 같다면 월을 기준으로 오름차순 정렬

WITH CTE AS (
    SELECT COUNT(*) AS CNT FROM USER_INFO WHERE YEAR(JOINED) = '2021'
)

SELECT YEAR, MONTH, COUNT(*) AS PURCHASED_USERS, 
    ROUND(COUNT(*) / (SELECT * FROM CTE), 1) AS PUCHASED_RATIO

FROM 
(SELECT DISTINCT U.USER_ID, YEAR(S.SALES_DATE) AS YEAR, MONTH(S.SALES_DATE) AS MONTH
FROM USER_INFO U JOIN ONLINE_SALE S
ON U.USER_ID = S.USER_ID AND YEAR(U.JOINED) = '2021') P
GROUP BY YEAR, MONTH
ORDER BY YEAR ASC, MONTH ASC