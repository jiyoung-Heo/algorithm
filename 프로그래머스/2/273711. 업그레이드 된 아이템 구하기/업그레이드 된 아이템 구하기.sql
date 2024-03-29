-- 코드를 작성해주세요
SELECT AA.ITEM_ID, AA.ITEM_NAME, AA.RARITY FROM ITEM_INFO AA,
(SELECT A.ITEM_ID FROM ITEM_TREE A,
(SELECT ITEM_ID, ITEM_NAME, RARITY FROM ITEM_INFO WHERE RARITY = 'RARE') B WHERE A.PARENT_ITEM_ID = B.ITEM_ID) BB WHERE AA.ITEM_ID = BB.ITEM_ID ORDER BY AA.ITEM_ID DESC;