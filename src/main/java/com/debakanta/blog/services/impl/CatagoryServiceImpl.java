package com.debakanta.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debakanta.blog.entities.Catagory;
import com.debakanta.blog.exceptions.ResourceNotFoundException;
import com.debakanta.blog.payload.CatagoryDto;
import com.debakanta.blog.respositories.CatagoryRepo;
import com.debakanta.blog.services.CatagoryService;

@Service
public class CatagoryServiceImpl implements CatagoryService {
	@Autowired
	private CatagoryRepo catagoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CatagoryDto createCatagory(CatagoryDto catagoryDto) {
		Catagory catagory = this.dtoToCatagory(catagoryDto);
		Catagory savedCatagory= this.catagoryRepo.save(catagory);
		
		return catagoryToDto(savedCatagory);
	}

	@Override
	public CatagoryDto updateCatagory(Integer catagoryId, CatagoryDto catagoryDto) {
		Catagory savedCatagory = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()->new ResourceNotFoundException("Cagtagory", "catagoryId", catagoryId));
		
		savedCatagory.setCatagoryTitle(catagoryDto.getCatagoryTitle());
		savedCatagory.setCatagoryDescription(catagoryDto.getCatagoryDescription());
		this.catagoryRepo.save(savedCatagory);
		
		return catagoryToDto(savedCatagory);
	}

	@Override
	public void deleteCatagory(Integer catagoryId) {
		this.catagoryRepo.deleteById(catagoryId);
	}

	@Override
	public CatagoryDto getCatagory(Integer catagoryId) {
		Catagory catagory = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()->new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));
		CatagoryDto catagoryDto = catagoryToDto(catagory);
		
		return catagoryDto;
	}

	@Override
	public List<CatagoryDto> getAllCatagorys() {
		List<Catagory>  catagoryList= this.catagoryRepo.findAll();
		List<CatagoryDto> dtoList = catagoryList.stream()
				.map(x->catagoryToDto(x))
				.collect(Collectors.toList());
		
		return dtoList;
	}


	public Catagory dtoToCatagory(CatagoryDto catagoryDto) {
		Catagory catagory = this.modelMapper.map(catagoryDto, Catagory.class);
		return catagory;
	}
	public CatagoryDto catagoryToDto(Catagory catagory) {
		CatagoryDto catagoryDto= this.modelMapper.map(catagory, CatagoryDto.class);
		return catagoryDto;
	}
}
