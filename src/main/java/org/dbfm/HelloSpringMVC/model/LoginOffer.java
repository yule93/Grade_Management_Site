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
public class LoginOffer {

	@Size(min=6, max=100, message="Name must be between 6 and 100 chars")
	@NotEmpty(message = "The user name cannot be empty")
	private String username;
	
	private String authority;
	
	@Size(min=6, max=100, message="Password must be between 6 and 100 chars")
	@NotEmpty(message = "The user name cannot be empty")
	private String password;
	private int enabled;
}
