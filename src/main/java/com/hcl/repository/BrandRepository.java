package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}