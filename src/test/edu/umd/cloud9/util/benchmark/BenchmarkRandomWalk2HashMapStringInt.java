package edu.umd.cloud9.util.benchmark;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BenchmarkRandomWalk2HashMapStringInt {

	private static int removals = 0;

	public static void main(String[] args) {
		int size = 10000000;
		long startTime;
		long duration;
		Random r = new Random();

		System.out.println("Benchmarking HashMap<String, Integer>...");
		Map<String, Integer> map = new HashMap<String, Integer>();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			String k = "" + r.nextInt(1000);
			boolean increment = r.nextBoolean();
			if (increment) {
				increment(map, k);
			} else {
				decrement(map, k);

			}
		}
		duration = System.currentTimeMillis() - startTime;

		System.out.println("removals: " + removals);
		System.out.println("Time taken: " + duration + " ms");
	}

	private static void increment(Map<String, Integer> map, String key) {
		if (map.containsKey(key)) {
			map.put(key, map.get(key) + 1);
		} else {
			map.put(key, 1);
		}
	}

	private static void decrement(Map<String, Integer> map, String key) {
		if (map.containsKey(key)) {
			int val = map.get(key);
			if (val == 1) {
				removals++;
				map.remove(key);
			} else {
				map.put(key, val - 1);
			}
		}
	}
}
