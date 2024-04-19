package kr.s34.jdbc.callablestatement;

import java.sql.Connection;
import java.sql.CallableStatement;

import kr.util.DBUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CallableStatementMain { // SQL의 PROCEDURE을 사용하기 위해 사용
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		CallableStatement cstmt = null;
		String sql = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("이름(SMITH,PETER, JOHN): ");
			String name = br.readLine();
			System.out.println("급여 인상률 : ");
			float rate = Float.parseFloat(br.readLine());
			
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();
			
			// 프로시저 호출 문장 작성
			sql = "{call adjust(?, ?)}";
			
			
			// JDBC 수행 3단계
			cstmt = conn.prepareCall(sql);
			
			// 데이터 할당
			cstmt.setString(1, name);
			cstmt.setFloat(2, rate);
			
			// JDBC 4단계 : 프로시저 호출
			cstmt.executeUpdate();
			System.out.println("급여 정보를 수정했습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			DBUtil.executeClose(cstmt, conn);
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}
