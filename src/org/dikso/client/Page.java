package org.dikso.client;

public enum Page {
	DICTIONARY,	ADMIN;
	public static Page toPage(int value) {
		switch(value) {
		case 0:
			return DICTIONARY;
		case 1: 
			return ADMIN;
		default:
			return DICTIONARY;
		}
	}
	public static Page toPage(String value) {
		if (value.equals("dictionary"))
			return DICTIONARY;
		if (value.equals("admin"))
			return ADMIN;
		return DICTIONARY;
	}
	public String toString() {
		switch(this) {
		case DICTIONARY:
			return "dictionary";
		case ADMIN: 
			return "admin";
		default: 
			return "dictionary";
		}
	}
}
