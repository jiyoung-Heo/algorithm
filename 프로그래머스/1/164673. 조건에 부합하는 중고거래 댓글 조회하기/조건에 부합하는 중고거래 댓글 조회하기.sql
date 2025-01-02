-- 코드를 입력하세요
SELECT 
b.title TITLE, 
b.board_id BOARD_ID, 
r.reply_id REPLY_ID, 
r.writer_id WRITER_ID, 
r.contents CONTENTS, 
date_format(r.created_date,'%Y-%m-%d') CREATED_DATE 

from USED_GOODS_BOARD b, USED_GOODS_REPLY r 
where b.board_id = r.board_id 

and b.CREATED_DATE 
like '2022-10%' 

order by r.created_date asc, b.title asc;