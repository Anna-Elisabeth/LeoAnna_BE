package com.lbg.everestbe.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.everestbe.domain.Customer;
import com.lbg.everestbe.service.CustomerService;

@RequestMapping("/customer")
@CrossOrigin
@RestController
public class CustomerController {

	private CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
		return this.service.createCustomer(newCustomer);
	}

	@GetMapping("/get")
	public List<Customer> getCustomer() {
		return this.service.getCustomer();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		return this.service.getCustomer(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteCustomer(@PathVariable int id) {
		return this.service.deleteCustomer(id);

	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer newCustomer) {
		return this.service.updateCustomer(id, newCustomer);

	}

}
