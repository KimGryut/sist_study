CREATE TABLE test3 (
	num NUMBER PRIMARY KEY,
	title VARCHAR2(60) NOT NULL, -- 1자에 3바이트 --> 20자 사용 가능하단 뜻
	name VARCHAR2(30) NOT NULL,
	memo VARCHAR2(4000) NOT NULL,
	email VARCHAR2(30),
	reg_date DATE NOT NULL
);

CREATE SEQUENCE test3_seq;