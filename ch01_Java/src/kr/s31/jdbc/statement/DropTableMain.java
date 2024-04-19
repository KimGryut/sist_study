package kr.s31.jdbc.statement;

import java.sql.Connection; // 오라클 연동
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; // SQL 문장 실어나르는 역할

public class DropTableMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "user01";
		String db_password = "1234";

		Connection conn = null;
		Statement stmt = null;
		String sql = null;

		try {
			// JDBC 수행 1단계 : 드라이버 로드
			Class.forName(db_driver);
			// JDBC 수행 2단계 : Connection 객체 생성(오라클 접속을 위한 인증)
			conn = DriverManager.getConnection(db_url, db_id, db_password);

			System.out.println("test1 테이블을 삭제합니다.");
			// 테이블을 삭제하는 SQL문 작성
			sql = "DROP TABLE test1";
			

			// JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();

			// JDBC 수행 4단계 : SQL문을 실행해서 DB에 테이블을 삭제
			stmt.execute(sql);

			System.out.println("테이블이 정상적으로 삭제되었습니다.");		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 정리
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
