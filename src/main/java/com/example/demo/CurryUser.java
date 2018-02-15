package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurryUser {
    @JsonProperty("ID")
    private Long id;
    @JsonProperty("名前")
    private String name;
    @JsonProperty("住所")
    private String address;
    @JsonProperty("性別")
    private String gender;
    @JsonProperty("年齢")
    private String age;
    @JsonProperty("誕生日")
    private String birthday;
    @JsonProperty("婚姻")
    private String married;
    @JsonProperty("都道府県")
    private String prefecture;
    @JsonProperty("携帯")
    private String mobile;
    @JsonProperty("キャリア")
    private String carrier;
    @JsonProperty("カレーの好み")
    private String curry;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the married
	 */
	public String getMarried() {
		return married;
	}
	/**
	 * @param married the married to set
	 */
	public void setMarried(String married) {
		this.married = married;
	}
	/**
	 * @return the prefecture
	 */
	public String getPrefecture() {
		return prefecture;
	}
	/**
	 * @param prefecture the prefecture to set
	 */
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the carrier
	 */
	public String getCarrier() {
		return carrier;
	}
	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	/**
	 * @return the curry
	 */
	public String getCurry() {
		return curry;
	}
	/**
	 * @param curry the curry to set
	 */
	public void setCurry(String curry) {
		this.curry = curry;
	}
}
