package com.dreyer.agendaapi.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreyer.agendaapi.jpa.entities.RoleEntity;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long>{

}
