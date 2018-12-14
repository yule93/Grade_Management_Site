package org.dbfm.HelloSpringMVC.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	
	private int id;
	private int year;
	private int semester;
	private String code;
	
	@Size(min=2, max=100, message="Name must be between 2 and 100 chars")
	@NotEmpty(message = "The name cannot be empty")
	private String name;
	
	private String sort;
	
	@Size(max = 1, message="학점은 1자리 수 입니다.")
	private int credit;
	
	// 아래 field들은 필요없음
	
	/*@Email(message = "Please provide a valid email address")
	@NotEmpty(message = "The email address cannot be empty")
	private String email;
	
	@Size(min=5, max = 100, message = "Text must be between 2 and chars")
	private String text;*/
	
}
