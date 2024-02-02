package com.debakanta.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debakanta.blog.entities.Catagory;
import com.debakanta.blog.payload.ApiResponce;
import com.debakanta.blog.payload.CatagoryDto;
import com.debakanta.blog.services.CatagoryService;
import com.debakanta.blog.services.impl.CatagoryServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/catagories")
public class CatagoryController {
	@Autowired
	private CatagoryService catagoryService;
	
	//POST-create catagory
	@PostMapping("/")
	public ResponseEntity<CatagoryDto> createcatagory (@Valid @RequestBody CatagoryDto catagoryDto){
		CatagoryDto savedcatagoryDto= this.catagoryService.createCatagory(catagoryDto);
		return new ResponseEntity(savedcatagoryDto,HttpStatus.CREATED);
	}
	//PUT-update catagory
	@PutMapping("/{catagoryId}")
	public ResponseEntity<CatagoryDto> updateCatagory(@Valid @PathVariable Integer catagoryId, @RequestBody CatagoryDto catagoryDto){
		CatagoryDto catagoryDto2= this.catagoryService.updateCatagory(catagoryId, catagoryDto);
		return ResponseEntity.ok(catagoryDto2);
	}
	//DELETE-delete catagory by id
	@DeleteMapping("/{catagoryId}")
	public ResponseEntity<ApiResponce> deleteCatagory(@PathVariable Integer catagoryId){
		this.catagoryService.deleteCatagory(catagoryId);
		ApiResponce apiResponce = new ApiResponce("Catagory deleted with id : "+catagoryId, true);
		
		return ResponseEntity.ok(apiResponce);
	}
	//GET-get a single catagory
	@GetMapping("/{catagoryId}")
	public ResponseEntity<CatagoryDto> getCatagory(@PathVariable Integer catagoryId){
		CatagoryDto catagoryDto = this.catagoryService.getCatagory(catagoryId);
		return ResponseEntity.ok(catagoryDto);
	}
	//GET-get all catagories
	@GetMapping("/")
	public ResponseEntity<List<CatagoryDto> > getCatagories(){
		List<CatagoryDto> catagoryDto = this.catagoryService.getAllCatagorys();
		return ResponseEntity.ok(catagoryDto);
	}
}
