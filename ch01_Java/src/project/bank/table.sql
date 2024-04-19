-- 계좌 테이블
CREATE TABLE baccount (
    account_num VARCHAR2(15) PRIMARY KEY, -- 계좌 번호 0000-000-000000
    user_id VARCHAR2(10) NOT NULL REFERENCES buser(user_id), -- 계좌주
    account_balance NUMBER NOT NULL, -- 계좌 잔액
    account_password NUMBER(4) NOT NULL, -- 계좌 비밀번호 (입금, 출금, 계좌이체 시 이용)
    account_regdate DATE DEFAULT SYSDATE NOT NULL
);

-- 사용자
CREATE TABLE buser (
	user_id VARCHAR2(30) PRIMARY KEY, -- 사용자 ID (로그인 시 이용)
	user_name VARCHAR2(10) NOT NULL, -- 사용자 이름
	user_passwd VARCHAR2(10) NOT NULL, -- 사용자 비밀번호 (로그인 시 이용)
	user_address VARCHAR2(90) NOT NULL, -- 사용자 주소
	user_phone VARCHAR2(13) NOT NULL -- 사용자 휴대폰 번호	
);

-- 출금하기
CREATE TABLE withdraw (
	wd_num NUMBER PRIMARY KEY, -- 출금 번호
	account_num VARCHAR2(15) NOT NULL REFERENCES baccount(account_num), -- 출금 계좌
	wd_amount NUMBER NOT NULL, -- 출금 금액
	wd_date DATE DEFAULT SYSDATE NOT NULL -- 출금 날짜
);

CREATE SEQUENCE withdraw_seq;

-- 입금하기
CREATE TABLE deposit (
	dp_num NUMBER PRIMARY KEY, -- 입금 번호
	account_num VARCHAR2(15) NOT NULL REFERENCES baccount(account_num), -- 입금 계좌
	dp_amount NUMBER NOT NULL, -- 입금 금액
	dp_date DATE DEFAULT SYSDATE NOT NULL -- 입금 날짜
);

CREATE SEQUENCE deposit_seq;

-- 송금하기
CREATE TABLE send (
	sd_num NUMBER PRIMARY KEY, -- 송금 번호
	account_num VARCHAR2(15) NOT NULL REFERENCES baccount(account_num), -- 송금하는 계좌
	sd_account_num VARCHAR2(15) NOT NULL REFERENCES baccount(account_num), -- 송금받는 계좌
	sd_amount NUMBER NOT NULL, -- 송금 금액
	sd_date DATE DEFAULT SYSDATE NOT NULL -- 송금 날짜
);

CREATE SEQUENCE send_seq;

-- 내역
CREATE TABLE history (
	his_num NUMBER PRIMARY KEY, -- 송금 번호
	b_type NUMBER(3) NOT NULL, -- 0:입금 1:출금 2:송금
	account_num VARCHAR2(15) NOT NULL REFERENCES baccount(account_num), -- 송금하는 계좌
	sd_account_num VARCHAR2(15) REFERENCES baccount(account_num), -- 송금받는 계좌
	amount NUMBER NOT NULL, -- 송금 금액
	regdate DATE DEFAULT SYSDATE NOT NULL -- 송금 날짜
	
);

CREATE SEQUENCE history_seq;

