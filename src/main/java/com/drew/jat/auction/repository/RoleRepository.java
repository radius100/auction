package com.drew.jat.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drew.jat.auction.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);
}
