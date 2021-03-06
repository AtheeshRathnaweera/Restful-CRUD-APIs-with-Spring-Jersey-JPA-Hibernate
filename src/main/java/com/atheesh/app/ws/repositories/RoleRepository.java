package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.RoleEntity;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update RoleEntity roleEntity set roleEntity.name =:newName where roleEntity.id =:id")
    int updateTheRoleById(@Param("id") int id, @Param("newName") String newName);

    List<RoleEntity> getRoleEntitiesByStatusEquals(Status status);

    RoleEntity findRoleEntityByName(String name);
}
