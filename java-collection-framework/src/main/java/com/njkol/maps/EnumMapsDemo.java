package com.njkol.maps;

import java.util.EnumMap;

enum DayOfWeek {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumMapsDemo {

	private EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);
	// private EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(); // Compile time error
	public void demoEnum() {
		activityMap.put(DayOfWeek.MONDAY, "Soccer");	
	}
}
