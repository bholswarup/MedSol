package com.sm.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "ms_user")
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;

	@Column(name = "user_name")
	private String name;
	@Column(name = "user_email", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	@Column(name = "user_mobile")
	private String mobile;
	@Column(name = "user_password")
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + "]";
	}

}
