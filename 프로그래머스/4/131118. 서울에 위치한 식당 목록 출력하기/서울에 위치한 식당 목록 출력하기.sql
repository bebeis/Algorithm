-- 서울에 위치한 식당
-- 칼럼: 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수
-- 리뷰 평균점수는 소수점 세 번째 자리에서 반올림
--  평균점수를 기준으로 내림차순 정렬, 평균점수가 같다면 즐겨찾기수를 기준으로 내림차순 정렬

select r.REST_ID as REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(REVIEW_SCORE), 2) as SCORE
from REST_REVIEW r
join REST_INFO i on r.REST_ID = i.REST_ID
where i.ADDRESS like '서울%'
group by r.REST_ID
order by SCORE desc, FAVORITES desc