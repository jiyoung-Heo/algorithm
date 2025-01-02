-- 코드를 작성해주세요

select round(sum(ifNull(length,10))/count(*),2) as AVERAGE_LENGTH from fish_info;