package com.disney.poc.profile.jedispoc.util;

public enum CacheName implements ValueEnum {
	EPC("EPC"), PREF("PREF");

	private final String value;

	CacheName(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public String getName() {
		return name();
	}

	@Override
	public Object getValue() {
		return value;
	}
}

interface ValueEnum {
	Object getValue();
}