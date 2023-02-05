package com.si.springboot.repository;

import com.si.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNaziv(String naziv);
}
