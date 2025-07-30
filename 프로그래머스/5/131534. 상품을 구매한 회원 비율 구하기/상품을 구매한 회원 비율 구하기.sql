WITH CTE AS (
    SELECT COUNT(DISTINCT user_id)
    FROM user_info
    WHERE YEAR(joined) = 2021
)

SELECT 
    YEAR(sales_date) year, 
    MONTH(sales_date) month, 
    COUNT(DISTINCT user_id) purchased_users,
    ROUND(COUNT(DISTINCT user_id) / (SELECT * FROM CTE), 1) puchased_ratio
FROM user_info
JOIN online_sale USING (user_id)
WHERE YEAR(joined) = 2021
GROUP BY YEAR(sales_date), MONTH(sales_date)