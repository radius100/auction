package com.drew.jat.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drew.jat.auction.entity.Blog;
import com.drew.jat.auction.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);
}
