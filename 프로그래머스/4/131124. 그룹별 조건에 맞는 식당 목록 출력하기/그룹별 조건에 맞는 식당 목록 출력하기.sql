-- 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성
-- 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력
-- 리뷰 작성일을 기준으로 오름차순, 리뷰 텍스트를 기준으로 오름차순 정렬

SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d')
FROM REST_REVIEW NATURAL JOIN MEMBER_PROFILE
WHERE MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM (
        SELECT MEMBER_ID, COUNT(*) AS CNT
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
    ) AS I
    WHERE CNT = (
        SELECT MAX(CNT)
        FROM (
            SELECT MEMBER_ID, COUNT(*) AS CNT
            FROM REST_REVIEW
            GROUP BY MEMBER_ID
        ) AS J
    )
)
ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC;