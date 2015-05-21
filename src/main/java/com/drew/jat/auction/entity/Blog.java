package com.drew.jat.auction.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	
	private String url;

	@ManyToOne
	@JoinColumn(name="user_id") //@Column(s) not allowed on a @ManyToOne property: com.drew.jat.auction.entity.Blog.user
	private User user;

	@OneToMany(mappedBy="blog") 
	private List<Item> items;

	
	public final User getUser() {
		return user;
	}

	public final void setUser(User user) {
		this.user = user;
	}

	public final List<Item> getItems() {
		return items;
	}

	public final void setItems(List<Item> items) {
		this.items = items;
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getUrl() {
		return url;
	}

	public final void setUrl(String url) {
		this.url = url;
	}
}
