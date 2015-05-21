package com.drew.jat.auction.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drew.jat.auction.entity.Blog;
import com.drew.jat.auction.entity.Role;
import com.drew.jat.auction.entity.Item;
import com.drew.jat.auction.entity.User;
import com.drew.jat.auction.repository.BlogRepository;
import com.drew.jat.auction.repository.ItemRepository;
import com.drew.jat.auction.repository.RoleRepository;
import com.drew.jat.auction.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setEnabled(true);
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		User userTest = new User();
		userTest.setName("test");
		BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
		userTest.setPassword(encoder1.encode("test"));
		userTest.setEnabled(true);
		List<Role> roles1 = new ArrayList<Role>();
		roles1.add(roleUser);
		userTest.setRoles(roles1);
		userRepository.save(userTest);
		
		
		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids.setUser(userAdmin);
		blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogRepository.save(blogJavavids);
		
		Item item1 = new Item();
		item1.setTitle("first");
		item1.setBlog(blogJavavids);
		item1.setLink("http:\\javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setTitle("second");
		item2.setBlog(blogJavavids);
		item2.setLink("http:\\javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
		Item item3 = new Item();
		item3.setTitle("third");
		item3.setBlog(blogJavavids);
		item3.setLink("http:\\javavids.com");
		item3.setPublishedDate(new Date());
		itemRepository.save(item3);
		
		Item item4 = new Item();
		item4.setTitle("fourth");
		item4.setBlog(blogJavavids);
		item4.setLink("http:\\javavids.com");
		item4.setPublishedDate(new Date());
		itemRepository.save(item4);
	}
}
