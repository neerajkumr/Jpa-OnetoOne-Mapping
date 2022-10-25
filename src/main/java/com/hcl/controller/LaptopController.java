package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Brand;
import com.hcl.model.Laptop;

import com.hcl.repository.BrandRepository;
import com.hcl.repository.LaptopRepository;
import com.hcl.request.LaptopRequest;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
	@Autowired
	private LaptopRepository lrep;
	@Autowired
	private BrandRepository brep;

	@PostMapping("/save")
	public ResponseEntity<Laptop> saveData(@RequestBody LaptopRequest req) {
		Brand b = new Brand();
		b.setBrandName(req.getBrand());
		b = brep.save(b);
		Laptop l = new Laptop(req);
		l.setBrand(b);
		l = lrep.save(l);
		return new ResponseEntity<Laptop>(l, HttpStatus.CREATED);

	}

	@GetMapping
	public List<Laptop> getAll() {
		return lrep.findAll();

	}

	@GetMapping("/brand")
	public List<Brand> getByID() {
		return brep.findAll();
	}

	@GetMapping("/{id}")
	public Laptop getByID(@PathVariable Long id) {
		return lrep.findById(id).get();
	}

	@PostMapping("/{id}")
	public List<Laptop> deleteByID(@PathVariable Long id) {
		lrep.deleteById(id);
		return lrep.findAll();
	}
}