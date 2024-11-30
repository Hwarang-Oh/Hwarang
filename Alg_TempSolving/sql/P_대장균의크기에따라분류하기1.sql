# ECOLI_DATA : 실험실에서 배양한 대장균의 정보
# CASE문 : CASE WHEN condition THEN result ELSE result END

SELECT
    ID,
    CASE
        WHEN SIZE_OF_COLONY <= 100 THEN "LOW" -- SIZE_OF_COLONY가 100 이하일 경우 "LOW"
        WHEN SIZE_OF_COLONY <= 1000 THEN "MEDIUM" -- SIZE_OF_COLONY가 1000 이하일 경우 "MEDIUM"
        ELSE "HIGH" -- 그 외의 경우 "HIGH"
    END AS SIZE -- CASE 결과를 SIZE 열로 출력
FROM ECOLI_DATA
ORDER BY ID;
-- ID 기준 오름차순 정렬