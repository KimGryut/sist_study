package kr.s39.jdbc.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class ShopDAO {
	// 상품 등록 (관리자)
	public void insertItem(String item_name, int item_price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO sitem(item_num, item_name, item_price) VALUES (sitem_seq.nextval, ?, ?)";
			// date에다가 디폴트 값으로 SYSDATE 설정해뒀기 때문에 특별히 명시하지 않아도 자동으로 넘어감

			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);

			// 물음표에 바운딩
			pstmt.setString(1, item_name);
			pstmt.setInt(2, item_price);

			// JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 상품을 등록했습니다.");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 상품 목록 (관리자/사용자)
	public void selectItems() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM sitem ORDER BY item_num DESC";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 resultset에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-------------------------------------");

			if(rs.next()) {
				System.out.println("상품번호\t상품이름\t상품가격\t등록일");
				do { 
					System.out.print(rs.getInt("item_num"));
					System.out.print("\t");
					System.out.print(rs.getString("item_name"));
					System.out.print("\t");
					System.out.printf("%,d\t", rs.getInt("item_price"));

					System.out.println(rs.getDate("item_date"));
				} while (rs.next());
			} else {
				System.out.println("표시할 데이터가 업습니다.");
			}

			System.out.println("-------------------------------------");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

	}

	// 회원 목록 (관리자)
	public void selectCustomers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM customer";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 resultset에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-------------------------------------");

			if(rs.next()) {
				System.out.println("고객ID\t\t고객이름\t회원주소\t\t회원전화번호");
				do { 
					System.out.print(rs.getString("cust_id"));
					System.out.print("\t");
					System.out.print(rs.getString("cust_name"));
					System.out.print("\t");
					System.out.print(rs.getString("cust_address"));
					System.out.print("\t");
					System.out.println(rs.getString("cust_tel"));
				} while (rs.next());
			} else {
				System.out.println("표시할 데이터가 업습니다.");
			}


			System.out.println("-------------------------------------");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 구매 목록 (관리자)
	public void selectOrders() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM sorder o JOIN sitem i ON o.item_num=i.item_num ORDER BY order_num DESC";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 resultset에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-----------------------------------");
			if(rs.next()) {
				System.out.println("주문번호\t상품이름\t주문일자\t\t고객ID");
				do { 
					System.out.print(rs.getInt("order_num"));
					System.out.print("\t");
					System.out.print(rs.getString("item_name"));
					System.out.print("\t");
					System.out.print(rs.getDate("order_date"));
					System.out.print("\t");
					System.out.println(rs.getString("cust_id"));
				} while (rs.next());
			} else {
				System.out.println("표시할 데이터가 업습니다.");
			}

			System.out.println("-----------------------------------");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 회원 가입 (사용자)
	public void insertCustomer(String cust_id, String cust_name, String cust_address, String cust_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO customer (cust_id, cust_name, cust_address, cust_tel) VALUES(?, ? , ?, ?)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, cust_id);
			pstmt.setString(2, cust_name);
			pstmt.setString(3, cust_address);
			pstmt.setString(4, cust_tel);


			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();
			System.out.println("회원가입이 완료되었습니다.");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 회원 상세 (사용자) 
	public void selectDetailCustomer(String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM customer WHERE cust_id=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, cust_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-----------------------------------");
			if(rs.next()) {
				
				do { 
					System.out.println("회원 아이디: " + rs.getString("cust_id"));
					System.out.println("회원 이름: " + rs.getString("cust_name"));
					System.out.println("회원 주소: " + rs.getString("cust_address"));
					System.out.println("회원 전화번호: " + rs.getString("cust_tel"));
					System.out.println("회원 가입일: " + rs.getString("cust_date"));
				} while (rs.next());
			} else {
				System.out.println("표시할 데이터가 업습니다.");
			}

			System.out.println("-----------------------------------");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 상품 구매 (사용자)
	public void insertOrder(int item_num, String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs2 = null;
		ResultSet rs = null;
		
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			sql = "SELECT 1 FROM sitem WHERE item_num = ?"; // 아이템 번호 검사
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, item_num);
			rs = pstmt2.executeQuery();
			if (!rs.next()) {
				System.out.println("해당 상품 번호가 존재하지 않습니다.");
				return;
			}

			sql = "SELECT 1 FROM customer WHERE cust_id = ?"; // 고객 아이디 검사
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.setString(1, cust_id);
			rs2 = pstmt3.executeQuery();
			if (!rs2.next()) {
				System.out.println("해당 고객 아이디가 존재하지 않습니다.");
				return;
			}


			// SQL문 작성
			sql = "INSERT INTO sorder(order_num, item_num, cust_id) VALUES (sorder_seq.nextval, ?, ?)";
			// date에다가 디폴트 값으로 SYSDATE 설정해뒀기 때문에 특별히 명시하지 않아도 자동으로 넘어감

			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);

			// 물음표에 바운딩
			pstmt.setInt(1, item_num);
			pstmt.setString(2, cust_id);

			// JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 상품을 구매했습니다.");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt3, conn);
			DBUtil.executeClose(rs2, pstmt2, conn);
			DBUtil.executeClose(rs, pstmt, conn);
		}

	}

	// 구매 내역 (사용자)
	public void selectOrdersByid(String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM sorder o JOIN sitem i ON o.item_num=i.item_num WHERE cust_id=? ORDER BY order_num DESC";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, cust_id);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-----------------------------------");
			System.out.println(cust_id + "님의 구매내역");
			System.out.println("-----------------------------------");
			if(rs.next()) {
				System.out.println("주문번호\t상품이름\t상품가격\t주문일자");
				
				do { 
					System.out.print(rs.getInt("order_num"));
					System.out.print("\t");
					System.out.print(rs.getString("item_name"));
					System.out.print("\t");
					System.out.print(rs.getInt("item_price"));
					System.out.print("\t");
					System.out.println(rs.getDate("order_date"));
				} while (rs.next());
				
			} else {
				System.out.println("표시할 데이터가 업습니다.");
			}

			System.out.println("-----------------------------------");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}







}
