package chapter11.exam;

import java.util.TreeSet;

public class Exam3Main {

	public static void main(String[] args) {
		// TreeSet<E> 이용해서 팀 이름순 정렬, 같은 팀이면 이름 순 정렬, 같은 이름이면 번호 순 저장

		TreeSet<FootballPlayer> players = new TreeSet<>();

		players.add(new FootballPlayer("손흥민", 7, "토트넘", 20));
		players.add(new FootballPlayer("케인", 10, "토트넘", 25));
		players.add(new FootballPlayer("이강인", 25, "토트넘", 19));
		players.add(new FootballPlayer("박지성", 7, "맨유", 35));
		players.add(new FootballPlayer("루니", 10, "맨유", 35));
		players.add(new FootballPlayer("손흥민", 17, "토트넘", 20));

		System.out.println("보유 선수의 수 : " + players.size());

		System.out.println("보유 선수 리스트 ========================");
		for (FootballPlayer p : players) {
			System.out.println(p);
		}

	}

}
