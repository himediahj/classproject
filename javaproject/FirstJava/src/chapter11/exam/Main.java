package chapter11.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args) {

		// 1. List<E> 컬렉션 인스턴스 생성
		List<FootballPlayer0> player = new ArrayList<>();
		
		player.add(new FootballPlayer0("손흥민", 7, "토트넘", 29));	// 생성자 만드는거 까먹어서 에러 떴음...
		player.add(new FootballPlayer0("황희찬", 12, "울버햄튼", 27));
		player.add(new FootballPlayer0("이강인", 19, "레알 마요르카", 20));
		
		for(FootballPlayer0 p : player) {
			System.out.println(p);
		}
		
		
		
		
		// 2. Set<E> 컬렉션 이용해서 팀과 이름, 나이가 같으면 입력 되지 않도록
		Set<FootballPlayer0> player2 = new HashSet<>();
		
		player2.add(new FootballPlayer0("손흥민", 7, "토트넘", 29));
		player2.add(new FootballPlayer0("황희찬", 12, "울버햄튼", 27));
		player2.add(new FootballPlayer0("이강인", 19, "레알 마요르카", 20));
		player2.add(new FootballPlayer0("손흥민", 7, "토트넘", 29));
		
		System.out.println("\n=================================================");
		for(FootballPlayer0 p : player2) {
			System.out.println(p);
		}
		
		
		
		//3. TreeSet<E> 이용해서 팀 이름순 정렬, 같은 팀이면 이름 순, 같은 이름이면 번호 순 저장
		TreeSet<FootballPlayer0> player3 = new TreeSet<>();	// TreeSet도 중복 허용 X
		
		player3.add(new FootballPlayer0("손흥민", 7, "토트넘", 29));
		player3.add(new FootballPlayer0("황희찬", 12, "울버햄튼", 27));
		player3.add(new FootballPlayer0("이강인", 19, "레알 마요르카", 20));
		player3.add(new FootballPlayer0("손흥민", 7, "토트넘", 29));
		player3.add(new FootballPlayer0("해리 케인", 10, "토트넘", 29));
		player3.add(new FootballPlayer0("이강인", 20, "레알 마요르카", 20));
		
		System.out.println("\n======================================================");
		for(FootballPlayer0 p : player3) {
			System.out.println(p);
		}
		
		
		
		//4. 번호를 KEY로 하고 축구선수 인스턴스 저장하는 Map<K,V>
		Map<Integer, FootballPlayer0> player4 = new HashMap<>();
		
		player4.put(7, new FootballPlayer0("손흥민", 7, "토트넘", 29));
		player4.put(7, new FootballPlayer0("손흥민", 7, "FC서울", 29));
		
		System.out.println("\n================================================");
		System.out.println(player4.get(7));	// 얘도 무지성으로 for 쓰다가 에러 뜸...
		
	}

}
