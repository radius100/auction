package com.drew.jat.auction.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	
	private String description;
	
	@Column(name="published_date")
	private Date publishedDate;
	
	private String link;

	@ManyToOne
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	public final Blog getBlog() {
		return blog;
	}

	public final void setBlog(Blog blog) {
		this.blog = blog;
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final Date getPublishedDate() {
		return publishedDate;
	}

	public final void setPublishedDate(Date date) {
		this.publishedDate = date;
	}

	public final String getLink() {
		return link;
	}

	public final void setLink(String link) {
		this.link = link;
	}
	
}
