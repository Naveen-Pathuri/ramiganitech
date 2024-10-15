package com.example.RamiganiTech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.RamiganiTech.Entity.Ramigani;
import com.example.RamiganiTech.Repository.RamiganiRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class RamiganiService {
	
	@Autowired
	private RamiganiRepository ramiganiRepository;
	
	
	
	public Ramigani save(Ramigani ramigani)
	{
		
		return ramiganiRepository.save(ramigani);
		
	}
	
	
	public List<Ramigani> findALL(Ramigani ramigani){
		return ramiganiRepository.findAll();
		
	}
    
	public Ramigani deleteById(Long id)
	{
		return ramiganiRepository.findById(id).get();
		
	}

	public Ramigani findById(Long id)
	{
		return ramiganiRepository.findById(id).get();
		
	}
	public Ramigani updateById(@RequestParam Long id, String firstName , String email,String organisation,String phone,String region,String inquirytype,String message) {
		 
		Ramigani ramigani = ramiganiRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
        
        if (firstName != null) {
        	ramigani.setFirstName(firstName);
        }
        if (email != null) {
        	ramigani.setEmail(email);
        }
        if (organisation!=null) 
        {
			ramigani.setOrganisation(organisation);
		}
        if (phone!=null)
        {
        	ramigani.setPhone(phone);
		}
        if (region!=null) 
        {
        	ramigani.setRegion(region);
		}
        if (inquirytype!=null) 
        {
			ramigani.setInquirytype(inquirytype);
		}
        if (message!=null)
        {
			ramigani.setMessage(message);
		}
       
        
        return ramiganiRepository.save(ramigani);
    }

	
}
