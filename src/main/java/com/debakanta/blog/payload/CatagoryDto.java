package com.debakanta.blog.payload;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


public class CatagoryDto {
	
	private Integer catagoryId;
	
	@NotBlank(message = "Please Enter a title For the Catagory")
	private String catagoryTitle;
	
	@NotBlank(message = "Descrive the catagory in 100 words")
	private String catagoryDescription;

	public CatagoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatagoryDto(Integer catagoryId,
			@NotBlank(message = "Please Enter a title For the Catagory") String catagoryTitle,
			@NotBlank(message = "Descrive the catagory in 100 words") String catagoryDescription) {
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
