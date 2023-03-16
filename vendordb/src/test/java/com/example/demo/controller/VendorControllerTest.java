package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;


@SpringBootTest
class VendorControllerTest {

	@Autowired
	private VendorController vendorController;
	
	@MockBean
	private VendorService vendorService;
	
	@Test
	public void testCreateVendor() {
	    // Set up a mock vendor and service
	    Vendor vendor = new Vendor();
	    vendor.setVendorName("Test Vendor");
		vendor.setVendorCode("TESTVENDOR");
		vendor.setAddress("123 Test St");
		vendor.setCity("Testville");
		vendor.setState("TS");
		vendor.setPincode("123456");
		vendor.setPhone("1234567890");
		vendor.setEmail("testvendor@test.com");
		
	    Vendor createdVendor = new Vendor();
	    vendor.setVendorName("Test Vendor");
		vendor.setVendorCode("TESTVENDOR");
		vendor.setAddress("123 Test St");
		vendor.setCity("Testville");
		vendor.setState("TS");
		vendor.setPincode("123456");
		vendor.setPhone("1234567890");
		vendor.setEmail("testvendor@test.com");
	    when(vendorService.createVendor(vendor)).thenReturn(createdVendor);

	    
	    ResponseEntity<Vendor> response = vendorController.createVendor(vendor);

	   
	    verify(vendorService, times(1)).createVendor(vendor);
	    assertEquals(HttpStatus.CREATED, response.getStatusCode());
	    assertEquals(createdVendor, response.getBody());
	}
	
	@Test
	public void testGetAllVendor() {
		Vendor vendor1 = new Vendor();
	    vendor1.setVendorName("Test Vendor");
		vendor1.setVendorCode("TESTVENDOR");
		vendor1.setAddress("123 Test St");
		vendor1.setCity("Testville");
		vendor1.setState("TS");
		vendor1.setPincode("123456");
		vendor1.setPhone("1234567890");
		vendor1.setEmail("testvendor@test.com");
		
		Vendor vendor2 = new Vendor();
	    vendor2.setVendorName("Test Vendor2");
		vendor2.setVendorCode("TESTVENDOR2");
		vendor2.setAddress("123 Test St2");
		vendor2.setCity("Testville2");
		vendor2.setState("TS2");
		vendor2.setPincode("123457");
		vendor2.setPhone("1234567990");
		vendor2.setEmail("testvendor2@test.com");
		
		List<Vendor> expectedVendor = new ArrayList<>();
		expectedVendor.add(vendor1);
		expectedVendor.add(vendor2);
		
		when(vendorService.getAllVendors()).thenReturn(expectedVendor);
		
		ResponseEntity<List<Vendor>> response = vendorController.getAllVendors();
		List<Vendor> actualVendor = response.getBody();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedVendor.size(), actualVendor.size());
		
	}
	@Test
	public void testGetVendorById() {
		long id = 1L;
		Vendor expectedVendor = new Vendor();
		expectedVendor.setId(id);
		expectedVendor.setVendorName("Test Vendor2");
		expectedVendor.setVendorCode("TESTVENDOR2");
		expectedVendor.setAddress("123 Test St2");
		expectedVendor.setCity("Testville2");
		expectedVendor.setState("TS2");
		expectedVendor.setPincode("123457");
		expectedVendor.setPhone("1234567990");
		expectedVendor.setEmail("testvendor2@test.com");
		
		when(vendorService.getVendorById(id)).thenReturn(expectedVendor);
		ResponseEntity<Vendor> response = vendorController.getVendorById(id);
		Vendor actualVendor = response.getBody();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	
	
	
}
