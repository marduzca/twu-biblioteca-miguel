SELECT member.name
FROM member, checkout_item, book
WHERE member.id = checkout_item.member_id
AND checkout_item.book_id = book.id
AND book.title = "The Hobbit";
