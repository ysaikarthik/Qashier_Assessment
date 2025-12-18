package com.qashier.hq.util;

import java.util.Random;

public final class Config {
	private static final Random RANDOM = new Random();
	
	private Config() {}

	public static String baseUrl() {
		return "https://hq.qashier.com/#/";
	}

	public static String email() {
		String v = System.getProperty("HQ_EMAIL", System.getenv("HQ_EMAIL"));
		if (v == null || v.isBlank()) {
			throw new IllegalStateException("HQ_EMAIL must be provided via env or -DHQ_EMAIL");
		}
		return v;
	}

	public static String password() {
		String v = System.getProperty("HQ_PASSWORD", System.getenv("HQ_PASSWORD"));
		if (v == null || v.isBlank()) {
			throw new IllegalStateException("HQ_PASSWORD must be provided via env or -DHQ_PASSWORD");
		}
		return v;
	}

	/**
	 * Generate a random 4-digit PIN (1000-9999)
	 */
	public static String generateRandomPin() {
		int pin = 1000 + RANDOM.nextInt(9000);
		return String.valueOf(pin);
	}

	/**
	 * Generate random hourly rate between 8 and 15 RM
	 */
	public static double generateHourlyRate() {
		return 8.0 + (RANDOM.nextDouble() * 7.0); // 8.0 to 15.0
	}
}

