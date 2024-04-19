package kr.s31.jdbc.statement;

import java.sql.Connection; // 오라클 연동
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement; // SQL 문장 실어나르는 역할

public class SelectMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "user01";
		String db_password = "1234";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// JDBC 수행 1단계 : 드라이버 로드
			Class.forName(db_driver);
			// JDBC 수행 2단계 : Connection 객체 생성(오라클 접속을 위한 인증)
			conn = DriverManager.getConnection(db_url, db_id, db_password);

			// SELECT문 SQL 작성
			sql = "SELECT * FROM test1";
			
			// JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();

			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 레코드 행을 전달받아서 결과 집합을 만들고, ResultSet 객에체 담아서 반환
			rs = stmt.executeQuery(sql);	
			// 이 경우에는 프라이머리 키를 지정해둔 테이블이 아니기 때문에 동일한 데이터를 중복해서 삽입할 수 있음
			
			System.out.println("ID\t나이");
			// ResultSet에 보관된 결과 집합에 접근해서 행간으로 데이터를 추출
			while(rs.next()) {
				// 컬럼명을 통해 데이터를 반환
				
				System.out.print(rs.getString("id"));
				System.out.print("\t");
				System.out.println(rs.getInt("age"));
				
				
				// 컬럼 인덱스를 통해서 데이터를 반환
				//System.out.print(rs.getString(1)); // 처음 명시한 컬럼이 id
				//System.out.print("\t");
				//System.out.println(rs.getInt(2)); // 두 번째로 명시한 컬럼이 age
			}		
			
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 정리
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
