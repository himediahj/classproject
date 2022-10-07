package chapter15;

import java.net.MalformedURLException;
import java.net.URL;

public class URLtest {

	public static void main(String[] args) {

		String urlString = "http://news.naver.com/main/read.nhn?mode=LS2D&mid=sec&sid1=105&sid2=228&oid=584&aid=0000008620";
		
		try {
			URL url = new URL(urlString);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
			System.out.println(url.getFile());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
