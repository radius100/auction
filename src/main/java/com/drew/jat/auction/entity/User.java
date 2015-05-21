package com.drew.jat.auction.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String email;

	private String password;
	
	private boolean enabled;

	@ManyToMany//(mappedBy="roles")
	@JoinTable
	private List<Role> roles;

	@OneToMany(mappedBy="user")
	private List<Blog> blogs;

	public final boolean isEnabled() {
		return enabled;
	}

	public final void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public final List<Blog> getBlogs() {
		return blogs;
	}

	public final void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public final Integer getId() {
		return id;
	}

	public final List<Role> getRoles() {
		return roles;
	}

	public final void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final void setId(Integer id) {
		this.id = id;
	}
}
