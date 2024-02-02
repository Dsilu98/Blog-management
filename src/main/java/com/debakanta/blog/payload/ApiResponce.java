package com.debakanta.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ApiResponce {

	private String messae;
	private boolean status;
	public ApiResponce(String messae, boolean status) {
		super();
		this.messae = messae;
		this.status = status;
	}
	public String getMessae() {
		return messae;
	}
	public void setMessae(String messae) {
		this.messae = messae;
	}
	public boolean isStatus() {
		return status;
		
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
