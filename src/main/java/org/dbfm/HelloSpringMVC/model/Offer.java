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
	
	@NotEmpty(message = "연도 칸은 비어선 안 됩니다.")
	private String year;
	
	@NotEmpty(message = "학기 칸은 비어선 안 됩니다.")
	private String semester;
	private String code;
	
	@Size(min=2, max=100, message="적어도 두 글자 이상 적어야 합니다.")
	@NotEmpty(message = "이름 칸은 비어선 안 됩니다.")
	private String name;
	
	private String sort;

	private String credit;
	
	// 아래 field들은 필요없음
	
	/*@Email(message = "Please provide a valid email address")
	@NotEmpty(message = "The email address cannot be empty")
	private String email;
	
	@Size(min=5, max = 100, message = "Text must be between 2 and chars")
	private String text;*/
	
}
