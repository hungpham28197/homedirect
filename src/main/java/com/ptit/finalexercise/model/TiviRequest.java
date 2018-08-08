package com.ptit.finalexercise.model;

public class TiviRequest {
	private String name;
	private String category;
	private double priceMin;
	private double priceMax;
	private int bought;
	
	public TiviRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}

	public double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}

	public int getBought() {
		return bought;
	}

	public void setBought(int bought) {
		this.bought = bought;
	}

	@Override
	public String toString() {
		return "TiviRequest [name=" + name + ", category=" + category + ", priceMin=" + priceMin + ", priceMax="
				+ priceMax + ", bought=" + bought + "]";
	}

}
