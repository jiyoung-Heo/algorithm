-- 코드를 작성해주세요
select a.id, count(b.id) CHILD_COUNT from ecoli_data a left outer join ecoli_data b on a.id = b.parent_id group by id;