package com.samsung.model;

import java.util.Arrays;

public class User {
    private String username;
    private String password;
    private String address;
    private String[] favoriteFrameworks;
    private String gender;
    private String country;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getFavoriteFrameworks() {
		return favoriteFrameworks;
	}

	public void setFavoriteFrameworks(String[] favoriteFrameworks) {
		this.favoriteFrameworks = favoriteFrameworks;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", address=" + address
				+ ", favoriteFrameworks=" + Arrays.toString(favoriteFrameworks) + ", gender=" + gender + ", country="
				+ country + "]";
	}
    
}
