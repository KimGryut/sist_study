package project.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.util.DBUtil;

public class BankDAO {

	// 로그인 체크
	public boolean checkLogin(String user_id, String user_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		boolean result = false; 

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM buser WHERE user_id=? AND user_passwd=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_passwd);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				result = true;
			} 

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return result; 
	}

	// 아이디 중복 체크 
	public int checkId(String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int count = 0; 

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM buser WHERE user_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, user_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { // 반환할 값이 있다면 (입력한 id로 이미 생성된 게 있단 뜻)
				count = 1;
			} 

		} catch(Exception e) {
			count=2;
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return count; 
	}


	// 회원 가입 
	public void insertUser(String user_id, String user_name, String user_passwd, String user_address, String user_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO buser(user_id, user_name, user_passwd, user_address, user_phone) VALUES(?, ?, ? , ?, ?)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_name);
			pstmt.setString(3, user_passwd);
			pstmt.setString(4, user_address);
			pstmt.setString(5, user_phone);

			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();
			System.out.println("회원가입이 완료되었습니다.");
			System.out.println("");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 계좌 번호 생성하기
	public String getAccountNum() {
		// 계좌번호 1113-101-****** 형식 고정
		String account = "1113-101-";

		// ******에 해당하는 숫자 6개 지정 필요
		for (int i=0; i<6; i++) {
			// 1-9까지 랜덤 생성
			int num = (int)(Math.random()*9)+1;
			// 랜덤으로 생성한 숫자를 문자열에 추가
			account += Integer.toString(num); 
		}

		return account;
	}

	// 계좌번호 중복 체크
	public int checkAccount(String account_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int count = 0; 

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM baccount WHERE account_num=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, account_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { // 반환할 값이 있다면 (입력한 계좌로 이미 생성된 게 있단 뜻)
				count = 1;
				System.out.println("계좌번호가 중복되었습니다. 다시 생성합니다.");
			} 

		} catch(Exception e) {
			count=2;
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return count; 
	}

	// 계좌 개설하기
	public void insertAccount(String account_num, String user_id, int account_password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO baccount(account_num, user_id, account_balance, account_password) "
					+ "VALUES (?, ?, 0, ?)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, account_num);
			pstmt.setString(2, user_id);
			pstmt.setInt(3, account_password);

			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();
			System.out.println(account_num + " 계좌가 개설되었습니다.");
			System.out.println("");

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 비밀번호 체크하기
	public boolean checkPasswd(String account_num, int account_password, String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		boolean result = false; 

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM baccount WHERE account_num=? AND account_password=? AND user_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, account_num);
			pstmt.setInt(2, account_password);
			pstmt.setString(3, user_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				result = true;
			} 

		} catch(SQLException e) {
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return result; 
	}



	// 내 명의 계좌 확인하기
	public void SelectAccount(String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT account_num, account_regdate FROM baccount WHERE user_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, user_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { // 반환할 계좌가 있다면
				System.out.println("계좌번호\t\t\t계좌개설일");
				do { 
					System.out.print(rs.getString("account_num"));
					System.out.print("\t\t");
					System.out.println(rs.getDate("account_regdate"));
				} while (rs.next());
			} else {
				System.out.println("개설된 계좌가 없습니다.");
			}

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 입금하기
	public void deposit(String account_num, int amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String sql = null;
		int bal = 0;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();

			//SQL문 작성
			sql = "SELECT account_balance FROM baccount WHERE account_num=?";

			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);

			// 데이터 바운딩
			pstmt.setString(1, account_num);

			// resultSet 반환
			rs = pstmt.executeQuery();

			if(rs.next()) {
				bal = rs.getInt("account_balance") + amount;
			}

			// SQL문 작성
			sql = "UPDATE baccount SET account_balance=? WHERE account_num=?";

			// JDBC 수행 3단계
			pstmt2 = conn.prepareStatement(sql);

			// 데이터 바운딩
			pstmt2.setInt(1, bal);
			pstmt2.setString(2, account_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt2.executeUpdate();

			// System.out.printf("해당 계좌 잔액: %,d원", bal);
			System.out.println(" ");

		}catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, null);
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}


	// 출금하기 
	public void withdraw(String account_num, int amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String sql = null;
		int bal = 0;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();

			//SQL문 작성
			sql = "SELECT account_balance FROM baccount WHERE account_num=?";

			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);

			// 데이터 바운딩
			pstmt.setString(1, account_num);

			// resultSet 반환
			rs = pstmt.executeQuery();

			if(rs.next()) {
				bal = rs.getInt("account_balance") - amount;
			}

			if(bal>=0) {
				// SQL문 작성
				sql = "UPDATE baccount SET account_balance=? WHERE account_num=?";

				// JDBC 수행 3단계
				pstmt2 = conn.prepareStatement(sql);

				// 데이터 바운딩
				pstmt2.setInt(1, bal);
				pstmt2.setString(2, account_num);

				// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
				int count = pstmt2.executeUpdate();
				//System.out.printf("해당 계좌 잔액: %,d원", bal);

			} else {
				System.out.println("잔고가 부족합니다.");
			}
			System.out.println(" ");
		}catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, null);
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 입금 기록
	public void insertDpHistory(String account_num, int amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO history (his_num, b_type, account_num, amount) "
					+ "VALUES(history_seq.nextval, 0, ?, ?)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, account_num);
			pstmt.setInt(2, amount);


			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}


	// 출금 기록
	public void insertWdHistory(String account_num, int amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO history (his_num, b_type, account_num, amount) "
					+ "VALUES(history_seq.nextval, 1, ?, ?)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, account_num);
			pstmt.setInt(2, amount);


			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 송금 기록
	public void insertSdHistory(String account_num, String sd_account_num, int amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO history (his_num, b_type, account_num, sd_account_num, amount) "
					+ "VALUES(history_seq.nextval, 2, ?, ?, ?)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, account_num);
			pstmt.setString(2, sd_account_num);
			pstmt.setInt(3, amount);


			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 상대 계좌 존재하는지 체크
	public boolean checkSdAccount(String sd_account_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		boolean result = false; 

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM baccount WHERE account_num=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, sd_account_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				result = true;
			} 

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return result; 
	}


	// 잔액조회
	public void SelectDetailAccount(String account_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM baccount WHERE account_num=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, account_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { // 반환할 계좌가 있다면
				System.out.println("계좌번호\t\t\t잔액\t\t계좌개설일");
				do { 
					System.out.print(rs.getString("account_num"));
					System.out.print("\t\t");
					System.out.print(rs.getInt("account_balance"));
					System.out.print("\t\t");
					System.out.println(rs.getDate("account_regdate"));
				} while (rs.next());
			}
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}



	// 내역조회
	public void SelectDetailHistory(String account_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM history WHERE account_num=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, account_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			System.out.println("");
			System.out.println("-------------------------------------");
			System.out.println(account_num + "의 거래내역");
			System.out.println("-------------------------------------");
			System.out.println("");
			if(rs.next()) { // 반환할 계좌가 있다면
				System.out.println("거래날짜\t\t거래유형\t거래금액\t\t거래계좌");
				do { 
					System.out.print(rs.getDate("regdate"));
					System.out.print("\t");
					int type = rs.getInt("b_type");
					if (type==0) {
						System.out.print("입금");
					} else if(type==1) {
						System.out.print("출금");
					} else if(type==2) {
						System.out.print("송금");
					}
					System.out.print("\t");
					System.out.print(rs.getInt("amount"));
					System.out.print("\t\t");
					if (type==2) {
						System.out.println(rs.getString("sd_account_num"));
					} else {
						System.out.println("-");
					}
					
				} while (rs.next());
			} else {
				System.out.println("거래 내역이 없습니다.");
			}
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

}

