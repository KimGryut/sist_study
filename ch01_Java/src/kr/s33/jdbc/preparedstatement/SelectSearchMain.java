package kr.s33.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SelectSearchMain {
	public static void main(String[] args) {
		BufferedReader br = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("검색할 제목 문자: ");
			String keyword = br.readLine();
			System.out.println("------------------");

			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM test3 WHERE title LIKE '%' || ? || '%'";

			// JDBC 수행 3단계 : PreparedStatment 객체 생성 
			pstmt = conn.prepareStatement(sql);
			
			// 데이터 바인딩
			pstmt.setString(1,keyword);

			// JDBC 4단계 : SQL문을 실행해서 결과집합을 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				System.out.println("번호\t작성자\t등록일\t\t제목");
				do { // 여기에 바로 while(rs.next())를 사용하면 조건 체크 후 또 다음 행으로 넘어가서 첫 번째 행을 건너뛰게 됨
					// 따라서 do-while문을 사용해줘야 함
					System.out.print(rs.getInt("num"));
					System.out.print("\t");
					System.out.print(rs.getString("name"));
					System.out.print("\t");
					System.out.print(rs.getDate("reg_date"));
					System.out.print("\t");
					System.out.println(rs.getString("title"));				
				} while(rs.next());		
			} else {
				System.out.println("검색된 데이터가 없습니다.");
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
