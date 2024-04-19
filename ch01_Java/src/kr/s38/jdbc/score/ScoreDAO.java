package kr.s38.jdbc.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class ScoreDAO {

	// 총점 계산 메서드
	public int getSum(int korean, int english, int math) {

		return korean+english+math;
	}

	// 평균 계산 메서드
	public int getAvg(int sum) {
		return sum/3;
	}

	// 등급 계산 메서드
	public String getGrade(int avg) {
		String grade;
		switch (avg/ 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		return grade;
	}


	// 성적 범위 확인 메서드
	public boolean setScore(int score) {
		boolean result = false;
		if (score<=100 && score>=0) {
			result = true;
		}
		return result;
	}


	// 입력한 num을 가진 데이터가 있는지 확인하는 메서드
	public boolean checkNum(int num) { // true, false 반환
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		boolean result = false; // 기본 false

		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM score WHERE num=?";

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

	// 성적 입력
	public void insertScore(String name, int korean, int english, int math, 
			int sum, int avg, String grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "INSERT INTO score VALUES(score_seq.nextval, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 물음표에 데이터 바운딩
			pstmt.setString(1, name);
			pstmt.setInt(2, korean);
			pstmt.setInt(3, english);
			pstmt.setInt(4, math);
			pstmt.setInt(5, sum);
			pstmt.setInt(6, avg);
			pstmt.setString(7, grade);

			// JDBC 수행 4단계 : SQL문을 실행해서 1건의 레코드 생성
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 삽입했습니다.");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 목록 보기
	public void selectScore() {
		// 번호, 이름, 총점, 평균, 등급 명시
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM score ORDER BY num DESC";

			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// JDBC 수행 4단계 : SQL문을 실행해서 결과 집합을 받고 resultset에 담아서 반환
			rs = pstmt.executeQuery();

			System.out.println("-------------------------------------");

			if(rs.next()) {
				System.out.println("번호\t이름\t총점\t평균\t등급");
				do { // if 안에 있을 때는 무조건 do-while -> 안 그러면 1개 뛰어넘게 됨
					System.out.print(rs.getInt("num"));
					System.out.print("\t");
					System.out.print(rs.getString("name"));
					System.out.print("\t");
					System.out.print(rs.getInt("sum"));
					System.out.print("\t");
					System.out.print(rs.getInt("avg"));
					System.out.print("\t");
					System.out.println(rs.getString("grade"));
				} while (rs.next());
			} else {
				System.out.println("표시할 데이터가 업습니다.");
			}

			System.out.println("-------------------------------------");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

	}

	// 상세 페이지
	public void selectDetailScore(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "SELECT * FROM score WHERE num=?";

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
				System.out.println("국어: " + rs.getInt("korean"));
				System.out.println("영어: " + rs.getInt("english"));
				System.out.println("수학: " + rs.getInt("math"));
				System.out.println("총점: " + rs.getInt("sum"));
				System.out.println("평균: " + rs.getInt("avg"));
				System.out.println("등급: " + rs.getString("grade"));
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

	// 성적 수정
	public void updateScore(int num, String name, int korean, int english, int math, 
	        int sum, int avg, String grade) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    String sql = null;
	    try {
	        // JDBC 수행 1, 2단계
	        conn = DBUtil.getConnection();

	        // 수정 쿼리 실행
	        sql = "UPDATE score SET name=?, korean=?, english=?, math=?, sum=?, avg=?, grade=? WHERE num=?";
	        
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, name);
	        pstmt.setInt(2, korean);
	        pstmt.setInt(3, english);
	        pstmt.setInt(4, math);
	        pstmt.setInt(5, sum);
	        pstmt.setInt(6, avg);
	        pstmt.setString(7, grade);
	        pstmt.setInt(8, num);
	        int count = pstmt.executeUpdate();
	        System.out.println(count + "개의 행을 수정했습니다.");
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.executeClose(null, pstmt, conn);
	    }
	}

	// 성적 삭제
	public void deleteScore(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			// JDBC 수행 1, 2단계
			conn = DBUtil.getConnection();

			// SQL문 작성
			sql = "DELETE FROM score WHERE num=?";

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
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

}
