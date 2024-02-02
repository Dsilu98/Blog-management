package com.debakanta.blog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catagories")
public class Catagory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catagoryId;
	
	@Column(name = "title",length = 100,nullable = false)
	private String catagoryTitle;
	
	@Column(name = "description")
	private String catagoryDescription;

	public Catagory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catagory(Integer catagoryId, String catagoryTitle, String catagoryDescription) {
		super();
		this.catagoryId = catagoryId;
		this.catagoryTitle = catagoryTitle;
		this.catagoryDescription = catagoryDescription;
	}

	public Integer getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}

	public String getCatagoryTitle() {
		return catagoryTitle;
	}

	public void setCatagoryTitle(String catagoryTitle) {
		this.catagoryTitle = catagoryTitle;
	}

	public String getCatagoryDescription() {
		return catagoryDescription;
	}

	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}

	@Override
	public String toString() {
		return "Catagory [catagoryId=" + catagoryId + ", catagoryTitle=" + catagoryTitle + ", catagoryDescription="
				+ catagoryDescription + "]";
	}
	
	
}
