package chapter11.exam;

import java.util.Objects;

public class FootballPlayer0 implements Comparable<FootballPlayer0> {

	private String name;
	private int number;
	private String team;
	private int age;

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getTeam() {
		return team;
	}

	public int getAge() {
		return age;
	}

	public FootballPlayer0(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return age;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && obj instanceof FootballPlayer0) {
			FootballPlayer0 p = (FootballPlayer0) obj;
			result = team.equals(p.getTeam()) && name.equals(p.getName()) && age == p.getAge(); // age도 무지성으로 equals 쓰다가 에러 뜸...
																								

		}
		return result;
	}

	@Override
	public int compareTo(FootballPlayer0 o) {
		int result = team.compareTo(o.getTeam());	// return처럼 = 안붙여서 에러... 
		if(result==0) {	
			result = name.compareTo(o.getName());
			if(result==0) {
				result = number - o.getNumber();
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "FootballPlayer0 [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

}
