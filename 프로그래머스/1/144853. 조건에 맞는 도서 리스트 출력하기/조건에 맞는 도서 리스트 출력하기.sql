-- 코드를 입력하세요
SELECT book_id, date_format(PUBLISHED_DATE,'%Y-%m-%d')
from book 
where category = '인문'
and year(published_date) = 2021
order by published_date asc;