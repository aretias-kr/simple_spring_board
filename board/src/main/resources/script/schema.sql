CREATE TABLE board_user (
	id varchar(10) primary key,
	name varchar(100),
	email varchar(100)
);

CREATE TABLE article(
	article_seq INT PRIMARY KEY,
	title varchar(100),
	content varchar(100),
	board_user_id varchar(10)
);