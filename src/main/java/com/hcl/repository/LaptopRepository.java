package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
