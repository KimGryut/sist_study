package kr.s35.jdbc.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.DBUtil;

public class WrongTransaction {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;
		try {
			// 복수의 SQL문을 실행할 경우 오토 커밋을 해제하고 수작업으로 트랜잭션 처리함
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			
			sql = "INSERT INTO test1 VALUES('SMITH', 10)";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.executeUpdate();
			
			
			sql = "INSERT INTO test1 VALUES('PETER', 20)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.executeUpdate();
			
			// 일부러 오류내기 -> 이 경우 pstmt1, pstmt2는 실행이 됨
			// -> 트랜잭션하면 세 개 중 하나라도 오류 나면 아예 실행이 안 되어야 하는데 이건 트랜잭션 실패임
			sql = "INSERT INTO test1 VALUES('JOHN', 30";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.executeUpdate();
			
			
			System.out.println("작업 완료");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt1, conn);
		}

	}

}
