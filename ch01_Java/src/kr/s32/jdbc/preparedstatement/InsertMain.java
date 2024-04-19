package kr.s32.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import kr.util.DBUtil;

public class InsertMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성												preparedStatement (statement(직접명시)와 다름)
			// 													데이터 값은 넣지 않고 자리만 잡아줌 -> 보안 강화
			sql = "INSERT INTO test2 (id, name, age, reg_date) VALUES(?, ?, ?, SYSDATE)";

			// JDBC 수행 3단계 : PreparedStatment 객체 생성 -> 동시에 sql 문장 넣어줌 (statement와 다름)
			pstmt = conn.prepareStatement(sql);
			
			// 물음표에 데이터를 바인딩(묶어줌) -> 데이터 할당
			pstmt.setString(1, "she'g"); // 1번 물음표에 데이터 전달
			// Statement와 달리 PreparedStatement에선 ?에 할당하는 거라, '를 그냥 써도 괜찮음
			pstmt.setString(2, "윤이찬");  // 2번 물음표에 데이터 전달
			pstmt.setInt(3, 25); // 3번 물음표에 데이터 전달
			
			// JDBC 4단계 : SQL문을 실행해서 테이블에 행을 추가
			// 3단계에서 sql을 전달했기 때문에 4단계에선 하지 않음 (statement와 다름)
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 추가했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
