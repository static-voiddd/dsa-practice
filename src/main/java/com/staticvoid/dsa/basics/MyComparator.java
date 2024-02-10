package com.staticvoid.dsa.basics;

import java.util.Comparator;

public class MyComparator {

	public static class PlayerA implements Comparator<PlayerA> {

		int score;
		String name;

		@Override
		public int compare(PlayerA o1, PlayerA o2) {
			if (o1.score == o2.score) {
				return o1.name.compareTo(o2.name);
			}
			return o2.score - o1.score;
		}

	}

}
