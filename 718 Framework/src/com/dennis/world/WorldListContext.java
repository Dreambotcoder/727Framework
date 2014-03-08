package com.dennis.world;

public class WorldListContext {

	public String activity;
	public String ip;

	public int countryId;
	public String countryName;

	public boolean members;

	public WorldListContext(String activity, String ip, int countryId, String countryName, boolean members) {
		this.activity = activity;
		this.ip = ip;
		this.countryId = countryId;
		this.countryName = countryName;
		this.members = members;
	}

	public String getActivity() {
		return activity;
	}

	public String getIP() {
		return ip;
	}

	public int getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public boolean isMembers() {
		return members;
	}
}