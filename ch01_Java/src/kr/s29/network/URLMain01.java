package kr.s29.network;

import java.net.MalformedURLException;
import java.net.URL;


public class URLMain01 {
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://java.sun.com:8080/index.jsp?name=kim#content");
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getDefaultPort());
			System.out.println("기본 포트 : " + url.getDefaultPort());
			System.out.println("포트 : " + url.getPort()); // 명시한 포트가 없다면 -1 반환
			// 주소에서 com 다음 :nnn이 포트 지정 방법
			System.out.println("패스 : " + url.getPath()); // 호스트 다음에 있는 것 com 다음 /부터
			System.out.println("쿼리 : " + url.getQuery()); // 패스 후 ? 다음부터
			System.out.println("래퍼런스 : " + url.getRef()); // 마지막 # 다음
		} catch(MalformedURLException e){ // 형식에 맞지 않는 주소를 썼다면 예외 발생
			e.printStackTrace();
		} 
	}
}
