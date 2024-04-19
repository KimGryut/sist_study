package kr.s31.jdbc.statement;

import java.sql.Connection; // 오라클 연동
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; // SQL 문장 실어나르는 역할

public class InsertMain {
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

			// 테이블에 데이터를 삽입하는 SQL문 작성
			sql = "INSERT INTO test1 (id, age) VALUES('she''g',50)";
			// JAVA에서 SQL작성할 때 '를 일반 문자로 인식시키고 싶다면 ''로 사용하면 됨
			
			// JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();

			// JDBC 수행 4단계 : SQL문을 실행해서 하나의 행을 삽입.
			//				: 삽입 작업 후 삽입한 행의 개수를 반환.
			int count = stmt.executeUpdate(sql);
			// 이 경우에는 프라이머리 키를 지정해둔 테이블이 아니기 때문에 동일한 데이터를 중복해서 삽입할 수 있음
			
			System.out.println(count + "개 행이 정상적으로 삽입되었습니다.");		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 정리
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
