package com.dreyer.agendaapi.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dreyer.agendaapi.jpa.entities.ItemEntity;

@Repository
public interface ItemEntityRepository extends JpaRepository<ItemEntity, Long>{
	
	@Query("SELECT i FROM ItemEntity i WHERE i.user.id = :id")
	List<ItemEntity> findByUserId(@Param("id") Long userId);
}
