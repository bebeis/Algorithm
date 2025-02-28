-- HR_DEPARTMENT: 부서 정보
-- HR_EMPLOYEES: 사원 정보
-- 부서별 평균 연봉을 조회
-- 부서별로 부서 ID, 영문 부서명, 평균 연봉을 조회
-- 평균연봉은 소수점 첫째 자리에서 반올림하고 컬럼명은 AVG_SAL
-- 부서별 평균 연봉을 기준으로 내림차순 정렬

SELECT DEPT_ID, DEPT_NAME_EN, AVG_SAL
FROM HR_DEPARTMENT NATURAL JOIN 
(SELECT DEPT_ID, ROUND(AVG(SAL), 0) AS AVG_SAL
FROM HR_EMPLOYEES
GROUP BY DEPT_ID) E
ORDER BY AVG_SAL DESC