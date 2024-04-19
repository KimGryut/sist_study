-- 회원 정보
CREATE TABLE member (
	me_id VARCHAR2(10) PRIMARY KEY, -- 회원 아이디 
	me_passwd VARCHAR2(10) NOT NULL, -- 회원 비밀번호
	me_name VARCHAR2(30) NOT NULL, -- 회원 이름
	me_phone VARCHAR2(13) NOT NULL, -- 회원 전화번호
	me_regdate DATE DEFAULT SYSDATE NOT NULL -- 회원 가입일
);

-- 도서 정보
CREATE TABLE sbook (
	bk_num NUMBER PRIMARY KEY, -- 책 번호
	bk_name VARCHAR2(90) NOT NULL, -- 책 이름
	bk_category VARCHAR2(30) NOT NULL, -- 책 분류
	bk_regdate DATE DEFAULT SYSDATE NOT NULL -- 책 등록일
);

CREATE SEQUENCE sbook_seq;  

-- 도서 대출 정보
CREATE TABLE reservation (
	re_num NUMBER PRIMARY KEY, -- 대출 번호
	re_status NUMBER(1) NOT NULL, -- 0:반납 / 1:미반납(대출중)
	bk_num NUMBER NOT NULL REFERENCES sbook(bk_num), -- 도서 번호 
	me_id VARCHAR2(10) NOT NULL REFERENCES member(me_id), -- 회원 아이디
	re_regdate DATE DEFAULT SYSDATE NOT NULL, -- 대출 날짜
	re_modifydate DATE -- 반납 날짜
);

CREATE SEQUENCE reservation_seq;

-- 도서 신청
CREATE TABLE applybook(
	ap_bk_num NUMBER PRIMARY KEY, -- 도서 신청 번호
	ap_bk_name VARCHAR2(90) NOT NULL, -- 도서 이름
	ap_bk_category VARCHAR2(30) NOT NULL, -- 도서 분류
	ap_memo VARCHAR2(4000) NOT NULL, -- 신청 메모
	me_id VARCHAR2(10) NOT NULL REFERENCES member(me_id), --신청자
	ap_status NUMBER(1) NOT NULL, -- 0: 미등록  1: 등록
	ap_regdate DATE DEFAULT SYSDATE NOT NULL -- 신청일
);

CREATE SEQUENCE applybook_seq;


