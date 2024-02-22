package com.dreyer.agendaapi.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dreyer.agendaapi.jpa.entities.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{
	
	@Query("SELECT u FROM UserEntity u JOIN FETCH u.roles where u.username = :username")
	UserEntity findUserByUsernameFetchRoles(@Param("username") String username);
}
