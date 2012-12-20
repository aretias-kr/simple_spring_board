insert into board_user(id, name, email) values(
	'aretias',
	'이정인',
	'aretias.kr@gmail.com'
);

insert into article(article_seq, title, content, board_user_id)
values(
	1,
	'제목입력',
	'내용입력',
	'aretias'
);

insert into article(article_seq, title, content, board_user_id)
values(
	2,
	'입력제목',
	'내용입력',
	'jeonginn'
);