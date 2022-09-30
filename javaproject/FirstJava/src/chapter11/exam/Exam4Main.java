package chapter11.exam;

import java.util.HashMap;
import java.util.Map;

public class Exam4Main {

	public static void main(String[] args) {
		// 4. 축구선수의 번호를 key로 하고 축구선수 인스턴스 저장하는 Map<K,V> 인스턴스 이용
		Map<Integer, FootballPlayer> players = new HashMap<>();
		
		// 저장 : put
		players.put(7, new FootballPlayer("손흥민", 7, "토트넘", 20));
		players.put(7, new FootballPlayer("손흥민", 7, "토트넘", 30));	// key값 같으니까 덮어쓴다
		
		System.out.println(players.get(7));
		
		

	}

}
