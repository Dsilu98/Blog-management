package com.debakanta.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {
	private int id;
	
	@NotBlank(message = "Name is mandatory, can't be blanck")
	@NotEmpty(message = "Enter a valid name")
	private String name;
	
	@Email(message = "Enter a valid Emialid")
	private String emailid;
	
	@Size(min = 3,max=10,message = "Password must be min of 3 char and max 10 char")
	private String password;
	
	@NotBlank(message ="Write something about uaer" )
	@NotEmpty(message = "Write something about uaer")
	private String about;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int id,
			@NotBlank(message = "Name is mandatory, can't be blanck") @NotEmpty(message = "Enter a valid name") String name,
			@Email(message = "Enter a valid Emialid") String emailid,
			@Size(min = 3, max = 10, message = "Password must be min of 3 char and max 10 char") String password,
			@NotBlank(message = "Write something about uaer") @NotEmpty(message = "Write something about uaer") String about) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.password = password;
		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", emailid=" + emailid + ", password=" + password + ", about="
				+ about + "]";
	}
	
	
	
	
}
