package com.njkol.comparable;

public class Player implements Comparable<Player> {

	private int ranking;
	private String name;
	private int age;

	public Player(int ranking, String name, int age) {
		this.ranking = ranking;
		this.name = name;
		this.age = age;
	}

	public int getRanking() {
		return ranking;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int compareTo(Player otherPlayer) {
		return Integer.compare(getRanking(), otherPlayer.getRanking());
	}

	@Override
	public String toString() {
		return "Player [ranking=" + ranking + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ranking;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ranking != other.ranking)
			return false;
		return true;
	}
	
}