package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Vendor;

public interface VendorService {
	Vendor createVendor(Vendor vendor);

	Vendor updateVendor(Long id, Vendor vendor);

	Vendor getVendorById(Long id);

	Vendor getVendorByVendorCode(String vendorCode);

	void deleteVendor(Long id);

	List<Vendor> getAllVendors();
}
