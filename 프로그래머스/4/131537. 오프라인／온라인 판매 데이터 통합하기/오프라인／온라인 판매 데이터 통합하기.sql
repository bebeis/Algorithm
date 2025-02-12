-- 온라인 상품 판매 정보 테이블 | 오프라인 상품 판매 정보 테이블
-- 2022년 3월의 오프라인/온라인 상품 판매 데이터
-- 판매 날짜, 상품ID, 유저ID, 판매량을 출력
-- 오프라인의 테이블의 판매 데이터의 USER_ID 값은 NULL로 표시
-- 1. 판매일을 기준으로 오름차순 정렬
-- 2. 상품 ID를 기준으로 오름차순
-- 3. 유저 ID를 기준으로 오름차순

(SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE YEAR(SALES_DATE) = '2022' AND MONTH(SALES_DATE) = '3')
UNION
(SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE YEAR(SALES_DATE) = '2022' AND MONTH(SALES_DATE) = '3')
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC