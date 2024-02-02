package com.debakanta.blog.services;

import java.util.List;

import com.debakanta.blog.payload.CatagoryDto;

public interface CatagoryService {
	
	//create
	public CatagoryDto createCatagory(CatagoryDto catagoryDto);
	
	//update
	public CatagoryDto updateCatagory(Integer catagoryId, CatagoryDto catagoryDto);
	
	//delete
	public void deleteCatagory(Integer catagoryId);
	
	//get cagatory
	public CatagoryDto getCatagory(Integer catagoryId);
	
	//get all
	public List<CatagoryDto> getAllCatagorys();
}
