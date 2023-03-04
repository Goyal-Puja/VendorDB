package com.example.demo.serviceimpl;
import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.InvalidDataException;
import com.example.demo.service.ResourceNotFoundException;
import com.example.demo.service.VendorService;
@Service
public class VendorServiceImpl implements VendorService {

	private final VendorRepository vendorRepository;

	   
	   public VendorServiceImpl(VendorRepository vendorRepository) {
	       this.vendorRepository = vendorRepository;
	   }

	   @Override
	   public Vendor createVendor(Vendor vendor) {
	       validateVendor(vendor);
	       return vendorRepository.save(vendor);
	   }
	   @Override
	   public List<Vendor> getAllVendors() {
	        return vendorRepository.findAll();
	    }

	   @Override
	   public Vendor updateVendor(Long id, Vendor vendor) {
	       validateVendor(vendor);

	       Vendor existingVendor = getVendorById(id);
	       existingVendor.setVendorName(vendor.getVendorName());
	       existingVendor.setVendorCode(vendor.getVendorCode());
	       existingVendor.setAddress(vendor.getAddress());
	       existingVendor.setCity(vendor.getCity());
	       existingVendor.setState(vendor.getState());
	       existingVendor.setPincode(vendor.getPincode());
	       existingVendor.setPhone(vendor.getPhone());
	       existingVendor.setEmail(vendor.getEmail());

	       return vendorRepository.save(existingVendor);
	   }
	   @Override
	   public Vendor getVendorById(Long id) {
	       return vendorRepository.findById(id)
	               .orElseThrow(() -> new ResourceNotFoundException("Vendor", "id", id));
	   }

	   @Override
	   public Vendor getVendorByVendorCode(String vendorCode) {
	       return vendorRepository.findByVendorCode(vendorCode)
	               .orElseThrow(() -> new ResourceNotFoundException("Vendor", "vendorCode", vendorCode));
	   }

	   @Override
	   public void deleteVendor(Long id) {
	       vendorRepository.deleteById(id);
	   }

	   private void validateVendor(Vendor vendor) {
	       if (!isValidPincode(vendor.getPincode())) {
	           throw new InvalidDataException("Invalid pincode");
	       }

	       if (!isValidPhone(vendor.getPhone())) {
	           throw new InvalidDataException("Invalid phone number");
	       }

	       if (!isValidEmail(vendor.getEmail())) {
	           throw new InvalidDataException("Invalid email address");
	       }

//	       if (vendor.getId() != null) {
//	           throw new InvalidDataException("Cannot set vendor id");
//	       }

	       Optional<Vendor> vendorByVendorCode = vendorRepository.findByVendorCode(vendor.getVendorCode());
	       if (vendorByVendorCode.isPresent()) {
	           if (!vendorByVendorCode.get().getId().equals(vendor.getId())) {
	               throw new InvalidDataException("Vendor code already exists");
	           }
	       }
   }

	   private boolean isValidPincode(String pincode) {
	       return pincode != null && pincode.matches("^\\d{6}$");
	   }

	   private boolean isValidPhone(String phone) {
	       return phone != null && phone.matches("^\\d{10}$");
	   }

	   private boolean isValidEmail(String email) {
	       return email != null && email.matches("^[\\w-_.+]*[\\w-_.]@[\\w]+[\\w-.]+[\\w-_.]+$");
	   }
	}

	


