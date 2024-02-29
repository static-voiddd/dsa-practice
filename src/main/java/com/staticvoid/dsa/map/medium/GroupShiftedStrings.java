package com.staticvoid.dsa.map.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

	public String getKey(String s) {
		// for xyz this would be 1#1#, we use # to separate
		// but can use anything
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < s.length(); i++) {
			int curr = s.charAt(i);
			int prev = s.charAt(i - 1);

			// since both are int from char no need to do - 'a' things
			int diff = prev - curr;

			// Edge Case - if diff <0 , we add 26 ie, subtract 'a' -
			// yab => a and y diff is negative so -> a-y -> 97-121 = -24 so add -24+26 = 2
			if (diff < 0) {
				diff += 26;
			}

			sb.append(diff);

			// This extra will be needed for edge case like ["cba","la"]
			// where without this our result will be
			// 11 of (b-c)(a-b) vs 11 of (la) so to avoid confusion
			// we append a separator
			sb.append("#");
		}

		return sb.toString();
	}

	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();

		for (String s : strings) {
			String key = getKey(s);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(s);
		}

		return new ArrayList<>(map.values());

	}

}
