package com.disney.poc.profile.jedispoc.model;

import java.io.Serializable;
import java.util.List;

public class Preference implements Serializable{
	private static final long serialVersionUID = -5757301643753136647L;

	private List<String> favorites;

	public List<String> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<String> favorites) {
		this.favorites = favorites;
	}

}
