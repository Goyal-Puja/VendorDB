package com.example.demo.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	
	private final VendorService vendorService;

	   
	   public VendorController(VendorService vendorService) {
	       this.vendorService = vendorService;
	   }

	   @PostMapping
	   public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
	       Vendor createdVendor = vendorService.createVendor(vendor);
	       return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
	   }
	   @GetMapping(value = "/getAll")
	    public ResponseEntity<List<Vendor>> getAllVendors() {
	        List<Vendor> vendors = vendorService.getAllVendors();
	        return ResponseEntity.ok(vendors);
	    }

	   @GetMapping(value = "/get/{id}")
	   public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
	       Vendor vendor = vendorService.getVendorById(id);
	       return new ResponseEntity<>(vendor, HttpStatus.OK);
	   }

	   @GetMapping(value = "/vendor/{vendorCode}")
	   public ResponseEntity<Vendor> getVendorByVendorCode(@PathVariable String vendorCode) {
	       Vendor vendor = vendorService.getVendorByVendorCode(vendorCode);
	       return new ResponseEntity<>(vendor, HttpStatus.OK);
	   }

	   @PutMapping("/update/{id}")
	   public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
	       Vendor updatedVendor = vendorService.updateVendor(id, vendor);
	       return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
	   }

	   @DeleteMapping("/delete/{id}")
	   public ResponseEntity<?> deleteVendor(@PathVariable Long id) {
	       vendorService.deleteVendor(id);
	       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	   }
}
