package com.passport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.passport.entity.PassportOffice;

@Repository
public interface PassportOfficeRepository extends JpaRepository<PassportOffice, Long>{

}