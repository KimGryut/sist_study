package kr.s37.jdbc.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class CarDAO2 {
	// 자동차 정보 등록
	public void insertCar (String name, String cnumber, String color, String maker, int price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO car VALUES(car_seq.nextval, ?, ?, ?, ?, ?, SYSDATE)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, name);
			pstmt.setString(2, cnumber);
			pstmt.setString(3, color);
			pstmt.setString(4, maker);
			pstmt.setInt(5, price);

			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 삽입했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 목록 보기
	public void selectCar() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM car ORDER BY num DESC";
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
						
			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 resultset에 담아서 반환
			rs = pstmt.executeQuery();
			
			System.out.println("-------------------------------------");

			if(rs.next()) {
				System.out.println("번호\t이름\t등록일\t\t차량번호");
				do { // if 안에 있을 때는 무조건 do-while -> 안 그러면 1개 뛰어넘게 됨
					System.out.print(rs.getInt("num"));
					System.out.print("\t");
					System.out.print(rs.getString("name"));
					System.out.print("\t");
					System.out.print(rs.getDate("reg_date"));
					System.out.print("\t");
					System.out.println(rs.getString("cnumber"));
				} while (rs.next());
			} else {
				System.out.println("표시할 데이터가 업습니다.");
			}
			
			System.out.println("-------------------------------------");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 자동차 상세 보기
	public void selectDetailCar(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM car WHERE num=?";
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 물음표에 데이터 바운딩
			pstmt.setInt(1, num);
			
			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			System.out.println("-----------------------------------");
			if (rs.next()) {
				System.out.println("번호: " + rs.getInt("num"));
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("차량번호: " + rs.getString("cnumber"));
				System.out.println("색상: " + rs.getString("color"));
				System.out.println("제조사: " + rs.getString("maker"));
				System.out.println("가격: " + rs.getInt("price"));
				System.out.println("등록일: " + rs.getDate("reg_date"));
			} else {
				System.out.println("표시할 데이터가 없습니다.");
			}
			
			System.out.println("-----------------------------------");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
	}
	
	// 입력한 num을 가진 데이터가 있는지 확인하는 메서드
	public boolean checkCar(int num) { // true, false 반환
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		boolean result = false; // 기본 false
		
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM car WHERE num=?";
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 물음표에 데이터 바운딩
			pstmt.setInt(1, num);
			
			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 반환할 값이 있다면 (올바른 num입력)
				result = true;
			} 
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return result; // return은 자원 정리 이후에
	}
	

	// 자동차 정보 수정하기
	public void updateCar(int num, String name, String cnumber, String color, String maker, int price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM car WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			
			
			// SQL문 작성
			sql = "UPDATE car SET name=?, cnumber=?, color=?, maker=?, price=? WHERE num=?";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 물음표에 데이터 바운딩
			pstmt.setString(1, name);
			pstmt.setString(2, cnumber);
			pstmt.setString(3, color);
			pstmt.setString(4, maker);
			pstmt.setInt(5, price);
			pstmt.setInt(6, num);
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 데이터 수정
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 수정했습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 자동차 정보 삭제하기
	public void deleteCar(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "DELETE FROM car WHERE num=?";
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 물음표에 데이터 바운딩
			pstmt.setInt(1, num);
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 데이터 수정
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 삭제했습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}


}
