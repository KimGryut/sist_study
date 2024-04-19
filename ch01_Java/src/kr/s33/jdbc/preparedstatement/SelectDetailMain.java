package kr.s33.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SelectDetailMain {
	public static void main(String[] args) {
		BufferedReader br = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("번호: ");
			int num = Integer.parseInt(br.readLine());

			System.out.println("------------------");

			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM test3 WHERE num=?";

			// JDBC 수행 3단계 : PreparedStatment 객체 생성 
			pstmt = conn.prepareStatement(sql);

			// 바인딩 데이터 할당
			pstmt.setInt(1, num); 

			// JDBC 4단계 : SQL문을 실행해서 결과집합을 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();	
			
			if(rs.next()) { // 행이 있다
				System.out.println("번호 : " + rs.getInt("num"));
				System.out.println("제목 : " + rs.getString("title"));
				System.out.println("작성자 : " + rs.getString("name"));
				System.out.println("메모 : " + rs.getString("memo"));
				
				String email = rs.getString("email");
				if(email==null) { // 이메일이 있다면 출력, 없으면 null이 아닌 빈값 나오게 만들기
					email = "";
				}
				System.out.println("이메일 : " + email);
				System.out.println("등록일 : " + rs.getDate("reg_date"));
				
			} else { // 행이 없다 -> primary key 잘못 입력
				System.out.println("검색한 데이터가 없습니다.");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			DBUtil.executeClose(rs, pstmt, conn);
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}
