package com.njkol.java14;

record User(int id, String password) {};

record Author(int id, String name, String topic) {

	static int followers;

	public static String followerCount() {
		return "Followers are " + followers;
	}

	public String description() {
		return "Author " + name + " writes on " + topic;
	}

	public Author {
		if (id < 0) {
			throw new IllegalArgumentException("id must be greater than 0.");
		}
	}
}


public class DemoRecords {

	private User user1 = new User(0, "UserOne");
}
