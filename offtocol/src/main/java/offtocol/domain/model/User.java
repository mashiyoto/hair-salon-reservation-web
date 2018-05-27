package offtocol.domain.model;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;



@Entity
@Data
public class User implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	private String username;

	private String username2;

	private String password;

	private String passwordConfirm;

	//USER, OWNER, ADMIN
	private String roleName;


}
