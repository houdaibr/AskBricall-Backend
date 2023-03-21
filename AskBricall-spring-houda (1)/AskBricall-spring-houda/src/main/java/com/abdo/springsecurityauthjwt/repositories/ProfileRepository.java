package com.abdo.springsecurityauthjwt.repositories;

import org.springframework.stereotype.Repository;

import com.abdo.springsecurityauthjwt.models.User;

import org.springframework.data.jpa.repository.JpaRepository;




@Repository
public interface ProfileRepository extends JpaRepository<User, Long>{

}

