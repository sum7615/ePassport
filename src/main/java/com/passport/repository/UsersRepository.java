package com.passport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passport.entity.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByUsername(String str);
}
