package edu.mum.cs.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.blogging.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
