package com.drew.jat.auction.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.drew.jat.auction.entity.Blog;
import com.drew.jat.auction.entity.Item;

public interface ItemRepository  extends JpaRepository<Item, Integer> {
	
	List<Item> findByBlog(Blog blog, Pageable pageable);
}
