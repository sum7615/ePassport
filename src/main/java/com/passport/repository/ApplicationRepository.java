package com.passport.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.passport.entity.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{

	@Query("select t from Application t where t.aadhar = :aadhar")
	Application findByAadhar(@Param("aadhar") String aadhar);

}
