package kr.s40.jdbc.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.util.DBUtil;

public class BookDAO {

	// 도서 등록 (관리자)
	public void InsertBook(String bk_name, String bk_category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO sbook(bk_num, bk_name, bk_category) VALUES (sbook_seq.nextval, ?, ?)";


			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);

			// 물음표에 바운딩
			pstmt.setString(1, bk_name);
			pstmt.setString(2, bk_category);

			// JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 도서를 등록했습니다.");
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}


	// 도서 목록 (관리자)
	public void SelectBooks() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT s.*, r.* FROM sbook s LEFT JOIN "
					+ "(SELECT re.* FROM reservation re JOIN "
					+ "(SELECT bk_num, MAX(re_regdate) AS max_regdate "
					+ "FROM reservation GROUP BY bk_num) max_dates "
					+ "ON re.bk_num = max_dates.bk_num AND re.re_regdate = max_dates.max_regdate) r "
					+ "ON s.bk_num = r.bk_num";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// JDBC 수행 4단계 : SQL문을 실행
			rs = pstmt.executeQuery();

			System.out.println("-------------------------------------");

			if(rs.next()) { // 반환할 도서가 있다면
				System.out.println("도서번호\t도서이름\t도서분류\t등록일\t\t대출가능여부");
				do { 
					System.out.print(rs.getInt("bk_num"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_category"));
					System.out.print("\t");
					System.out.print(rs.getDate("bk_regdate"));
					System.out.print("\t");
					int status = rs.getInt("re_status");
					if(status==1) {
						System.out.println("대출 중");
					} else {
						System.out.println("대출 가능");
					}
				} while (rs.next());
			} else {
				System.out.println("도서가 없습니다.");
			}

			System.out.println("-------------------------------------");
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 회원 목록 (관리자)
	public void selectMembers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM member";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 resultset에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-------------------------------------");

			if(rs.next()) {
				System.out.println("회원ID\t\t회원이름\t\t회원전화번호\t\t회원가입일");
				do { 
					System.out.print(rs.getString("me_id"));
					System.out.print("\t\t");
					System.out.print(rs.getString("me_name"));
					System.out.print("\t\t");
					System.out.print(rs.getString("me_phone"));
					System.out.print("\t");
					System.out.println(rs.getString("me_regdate"));
				} while (rs.next());
			} else {
				System.out.println("가입한 회원이 없습니다.");
			}
			System.out.println("-------------------------------------");
			System.out.println("");

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 대출 목록 (관리자)
	public void selectListReservations() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM reservation r JOIN sbook b ON r.bk_num=b.bk_num "
					+ "JOIN member m ON r.me_id = m.me_id ORDER BY re_num DESC";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 resultset에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-----------------------------------");
			if(rs.next()) {
				System.out.println("대출번호\t고객ID\t고객이름\t도서이름\t대출상태\t대출일자\t\t반납일자");
				do { 
					System.out.print(rs.getInt("re_num"));
					System.out.print("\t");
					System.out.print(rs.getString("me_id"));
					System.out.print("\t");
					System.out.print(rs.getString("me_name"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t");
					int status = rs.getInt("re_status");
					if(status==1) { // 대출 중이라면 1
						System.out.print("대출");
					} else { // 0이라면 대출 후 반납한 상태
						System.out.print("반납");
					}
					System.out.print("\t");
					System.out.print(rs.getDate("re_regdate"));
					System.out.print("\t");

					if(status==1) { // 대출 중이라면 반납 전이니까 -
						System.out.println("-");
					} else { // 반납했다면 반납일 표시
						System.out.println(rs.getDate("re_modifydate"));
					}
				} while (rs.next());
			} else {
				System.out.println("대출 내역이 없습니다.");
			}
			System.out.println("-----------------------------------");
			System.out.println("");

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}



	// 아이디 중복 체크 (사용자)
	public int checkId(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int count = 0; 

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM member WHERE me_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_id);

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


	// 회원가입 (사용자)
	public void insertMember(String me_id, String me_passwd, String me_name, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO member (me_id, me_passwd, me_name, me_phone) VALUES(?, ? , ?, ?)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			pstmt.setString(3, me_name);
			pstmt.setString(4, me_phone);

			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();
			System.out.println(count + "명의 회원가입이 완료되었습니다.");
			System.out.println("");

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}


	// 로그인 체크 (사용자)
	public boolean checkLogin(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		boolean flag = false; 

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM member WHERE me_id=? AND me_passwd=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				flag = true;
			} 

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return flag; 
	}


	// 도서 대출 여부 체크 (사용자)
	public int getStatusReservation(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int result = -1; 

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT re_status FROM sbook LEFT OUTER JOIN (SELECT * FROM reservation WHERE re_status=1) USING(bk_num) WHERE bk_num=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setInt(1, bk_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				int status = rs.getInt("re_status");
				if (status==0) {
					result = 0;
				} else if(status==1) {
					result = 1;
				}
			} 

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return result; 
	}

	// 도서 대출 등록 (사용자)
	public void insertReservation(int bk_num, String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "INSERT INTO reservation (re_num, re_status, bk_num, me_id)"
					+ "VALUES (reservation_seq.nextval, 1, ?, ?)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, bk_num);
			pstmt.setString(2, me_id);

			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 도서를 대출했습니다.");
			System.out.println("");
		}catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}


	// MY 대출 목록 (사용자) 
	public void selectDetailReservation(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM reservation r "
					+ "JOIN member m ON r.me_id=m.me_id "
					+ "JOIN sbook s ON r.bk_num=s.bk_num "
					+ "WHERE m.me_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-----------------------------------");
			System.out.println(me_id + "님의 대출내역");
			System.out.println("-----------------------------------");
			if(rs.next()) {
				System.out.println("대출번호\t도서이름\t대출상태\t대출일자\t\t반납일자");
				do { 
					System.out.print(rs.getInt("re_num"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t");
					int status = rs.getInt("re_status");
					if(status==1) {
						System.out.print("대출");
					} else {
						System.out.print("반납");
					}
					System.out.print("\t");
					System.out.print(rs.getDate("re_regdate"));
					System.out.print("\t");

					if(status==1) {
						System.out.println("-");
					} else {
						System.out.println(rs.getDate("re_modifydate"));
					}

				} while (rs.next());
			} else {
				System.out.println("대출 내역이 없습니다.");
			}

			System.out.println("-----------------------------------");
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}


	// 대출 도서 반납 가능 여부(사용자) 
	public int getStatusBack(String me_id, int re_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int result = 0;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM reservation WHERE re_num=? AND me_id=? AND re_status=1";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setInt(1, re_num);
			pstmt.setString(2, me_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				result = 1;
			} 

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return result; 
	}

	// 대출 반납 (사용자)
	public void updateReservation(int re_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "UPDATE reservation SET re_status=0, re_modifydate=SYSDATE WHERE re_num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, re_num);

			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 도서를 반납했습니다.");
			System.out.println("");

		}catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 대출 중인 목록만 보이게
	public void selectOnlyReservation(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM reservation r "
					+ "JOIN member m ON r.me_id=m.me_id "
					+ "JOIN sbook s ON r.bk_num=s.bk_num "
					+ "WHERE m.me_id=? AND r.re_status=1";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-----------------------------------");
			System.out.println(me_id + "님의 대출내역");
			System.out.println("-----------------------------------");
			if(rs.next()) {
				System.out.println("대출번호\t도서이름\t대출상태\t대출일자\t\t반납일자");
				do { 
					System.out.print(rs.getInt("re_num"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t");
					System.out.print("대출");
					System.out.print("\t");
					System.out.print(rs.getDate("re_regdate"));
					System.out.print("\t");
					System.out.println("-");				

				} while (rs.next());
			} else {
				System.out.println("반납 가능한 도서가 없습니다.");
			}

			System.out.println("-----------------------------------");
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}




	// ---------------------------------------------------------------------------------------------

	/*
	// 개인 정보 확인하기 (아이디 버전) (사용자)
	public int checkIdInfo(String me_name, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int result = 0;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM member WHERE me_name=? AND me_phone=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_name);
			pstmt.setString(2, me_phone);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				result = 1;
			} 
		} catch(Exception e) {
			result=2;
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return result; 
	} 
	 */  //=> 굳이 확인할 필요가 없었음
	
	// 아이디 찾기 (사용자)
	public void findId(String me_name, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT me_id FROM member WHERE me_name=? AND me_phone=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_name);
			pstmt.setString(2, me_phone);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			if (rs.next()) { // 결과가 있다면
				System.out.println("회원님의 아이디는 " + rs.getString("me_id") + "입니다.");
			} else {
				System.out.println("정보가 일치하는 회원이 등록되어 있지 않습니다.");
			}

			System.out.println("-----------------------------------");
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		} 
	}
	
	
	/*
	// 개인 정보 확인하기 (비번 버전) (사용자)
	public int checkPasswdInfo(String me_id, String me_name, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int result = 0;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM member WHERE me_name=? AND me_phone=? AND me_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_name);
			pstmt.setString(2, me_phone);
			pstmt.setString(3, me_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				result = 1;
			} 
		} catch(Exception e) {
			result=2;
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return result; 
	} */

	// 비밀번호 찾기 (사용자)
	public void findPasswd(String me_id, String me_name, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT me_passwd FROM member WHERE me_name=? AND me_phone=? AND me_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, me_name);
			pstmt.setString(2, me_phone);
			pstmt.setString(3, me_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			if (rs.next()) { // 결과가 있다면
				System.out.println("회원님의 비밀번호는 " + rs.getString("me_passwd") + "입니다.");
			} else {
				System.out.println("정보가 일치하는 회원이 등록되어 있지 않습니다.");
			}

			System.out.println("-----------------------------------");
			System.out.println("");
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		} 
	}

	// 회원정보 수정 (사용자)
	public void updateMemberInfo(String me_id, String me_name, String me_passwd, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();


			// 기존 데이터를 가져오기 위한 작업
			// SQL문 작성
			sql = "SELECT * FROM member WHERE me_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1,me_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 입력값이 비어 있는지 확인하고, 비어 있다면 기존 데이터를 사용
				if (me_name.isEmpty()) {
					me_name = rs.getString("me_name");
				}
				if (me_passwd.isEmpty()) {
					me_passwd = rs.getString("me_passwd");
				}
				if (me_phone.isEmpty()) {
					me_phone = rs.getString("me_phone");
				}


				// -> 결과 : 입력한 값이 있다면 입력한 값, 없다면 원래 있던 값이 할당됨

				// 수정 쿼리 실행
				sql = "UPDATE member SET me_name=?, me_passwd=?, me_phone=? WHERE me_id=?";
				pstmt2 = conn.prepareStatement(sql);
				pstmt2.setString(1, me_name);
				pstmt2.setString(2, me_passwd);
				pstmt2.setString(3, me_phone);
				pstmt2.setString(4, me_id);
				int count = pstmt2.executeUpdate();
				System.out.println(count + "번의 개인 정보를 수정했습니다.");
			} 
		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			// 자원정리
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}


	// 도서 검색하기 (관리자, 사용자)
	public void findBook(String bk_name) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();


			// 기존 데이터를 가져오기 위한 작업
			// SQL문 작성
			sql = "SELECT s.*, r.* FROM sbook s LEFT JOIN "
					+ "(SELECT re.* FROM reservation re JOIN "
					+ "(SELECT bk_num, MAX(re_regdate) AS max_regdate "
					+ "FROM reservation GROUP BY bk_num) max_dates "
					+ "ON re.bk_num = max_dates.bk_num AND re.re_regdate = max_dates.max_regdate) r "
					+ "ON s.bk_num = r.bk_num "
					+ "WHERE bk_name=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, bk_name);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-----------------------------------");
			System.out.println(bk_name + " 도서 검색");
			System.out.println("-----------------------------------");
			System.out.println("");
			if(rs.next()) {
				System.out.println("도서번호\t도서이름\t도서분류\t대출가능여부");
				do { 
					System.out.print(rs.getInt("bk_num"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_category"));
					System.out.print("\t");
					int status = rs.getInt("re_status");
					if(status==1) {
						System.out.println("대출 중");
					} else {
						System.out.println("대출 가능");
					}
				} while (rs.next());
			} else {
				System.out.println("해당 도서는 없습니다.");
			}
			System.out.println("");

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			// 자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}


	// 도서 신청 (사용자)
	public void applyNewBook(String ap_bk_name, String ap_bk_category, String ap_memo, String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO applybook(ap_bk_num, ap_bk_name, ap_bk_category, ap_memo, me_id, ap_status) "
					+ "VALUES(applybook_seq.nextval, ?, ?, ?, ?, 0)";



			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);

			// 물음표에 바운딩
			pstmt.setString(1, ap_bk_name);
			pstmt.setString(2, ap_bk_category);
			pstmt.setString(3, ap_memo);
			pstmt.setString(4, me_id);

			// JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 도서를 신청했습니다.");
			System.out.println("");
		} catch(Exception e) {
			System.out.println("항목을 제대로 입력해주세요.");
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}


	// 신청한 도서 확인하기 (관리자)
	public void showApplyNewBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM applybook";



			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println("신청번호\t신청ID\t\t도서이름\t\t신청일\t\t등록여부\t메모");
				do { 
					System.out.print(rs.getInt("ap_bk_num"));
					System.out.print("\t");
					System.out.print(rs.getString("me_id"));
					System.out.print("\t\t");
					System.out.print(rs.getString("ap_bk_name"));
					System.out.print("\t\t");
					System.out.print(rs.getDate("ap_regdate"));
					System.out.print("\t");
					int status = rs.getInt("ap_status");
					if(status==1) {
						System.out.print("등록 완료");
					} else {
						System.out.print("미등록");
					}
					System.out.print("\t");
					System.out.println(rs.getString("ap_memo"));
				} while (rs.next());
			} else {
				System.out.println("신청된 도서 목록이 없습니다.");
			}
			System.out.println("-------------------------------------");
			System.out.println("");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 도서 신청 가능 여부(관리자) 
	public int getStatusApply(int ap_bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int result = 0;

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM applybook WHERE ap_bk_num=? AND ap_status=0";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setInt(1, ap_bk_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				result = 1;
			} 

		} catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return result; 
	}

	// 신청 도서 구입하기 - 이름 (관리자)
	public String getApplyBookName(int ap_bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String bk_name = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM applybook WHERE ap_bk_num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, ap_bk_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				bk_name = rs.getString("ap_bk_name");
			} 

		}catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return bk_name;
	}

	// 신청 도서 구입하기 - 분류 (관리자)
	public String getApplyBookCategory(int ap_bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String bk_category = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM applybook WHERE ap_bk_num=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, ap_bk_num);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if(rs.next()) { 
				bk_category = rs.getString("ap_bk_category");
			} 

		}catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		}finally {
			//자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return bk_category;
	}

	// 신청 완료 (관리자)
	public void updateApply(int ap_bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "UPDATE applybook SET ap_status=1 WHERE ap_bk_num=?";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			
			//?에 데이터 바인딩
			pstmt.setInt(1, ap_bk_num);

			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(count + "건이 신청되었습니다.");
		}catch(Exception e) {
			System.out.println("잘못된 데이터입니다.");
			System.out.println("");
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
