package kr.s33.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.DBUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DeleteMain {
	public static void main(String[] args) {
		BufferedReader br = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("번호: ");
			int num = Integer.parseInt(br.readLine());
			
			System.out.println("------------------");

			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "DELETE FROM test3 WHERE num=?";

			// JDBC 수행 3단계 : PreparedStatment 객체 생성 
			pstmt = conn.prepareStatement(sql);

			// 데이터 바인딩
			pstmt.setInt(1, num);
						

			// JDBC 4단계 : 테이블의 행을 삭제
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 삭제했습니다.");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			DBUtil.executeClose(null, pstmt, conn);
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}
