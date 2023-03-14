package com.passport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passport.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByUsername(String str);
}
