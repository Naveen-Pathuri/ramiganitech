package com.example.RamiganiTech.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RamiganiTech.Entity.Ramigani;
import com.example.RamiganiTech.Repository.RamiganiRepository;
import com.example.RamiganiTech.Service.RamiganiService;

@RestController
@CrossOrigin(origins = "*") // Allow all origins // Change this to your frontend URL
@RequestMapping
public class RamiganiController {

	@Autowired
	private RamiganiService ramiganiService;
	
	 @Autowired
	    private RamiganiRepository ramiganiRepository;
	
	
	  @GetMapping("/ramigani")
	   public List<Ramigani>  findALL(Ramigani ramigani)
	   {
		return ramiganiService.findALL(ramigani);
		   
	   }
	   
	  @GetMapping("/ramigani/find/{id}")
	  public Ramigani create(@PathVariable Long id) 
	  {
	       
	        return ramiganiService.findById(id);
	    }
	  
	  @PostMapping("/ramigani/add")
	    public ResponseEntity<Ramigani> create(@RequestBody Ramigani ramigani)
	  {
	        // Determine the current size of the list and store it into the current size
	        long currentSize = ramiganiRepository.count();

	        // to  Set the sno to the new size + 1 ,when we enter the new data 
	        ramigani.setSno(currentSize + 1);

	        // Save the new entry
	        Ramigani savedRamigani = ramiganiRepository.save(ramigani);

	        return ResponseEntity.status(HttpStatus.CREATED).body(savedRamigani);
	    }
	  
	    @DeleteMapping("/ramigani/delete")
	    public ResponseEntity<Map<String,String>> deleteRamigani(@RequestParam Long id)
	    {
		  
	        if (ramiganiRepository.existsById(id))
	        {
	            ramiganiRepository.deleteById(id);
	            
	           
	            
	            // After deletion, update the sno for remaining entries
	            
	            List<Ramigani> remainingEntries = ramiganiRepository.findAll();
	            for (int i = 0; i < remainingEntries.size(); i++)
	            {
	                Ramigani entry = remainingEntries.get(i);
	                entry.setSno((long) (i + 1)); // Set sno to 1, 2, 3, ...
	                ramiganiRepository.save(entry); // Update the entry
	            }
	            
	          
	        }
	        
	        
	        else
	        {
	            return ResponseEntity.notFound().build(); // Handle not found case
	        }
	        Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("success", "Deleted id " +id+" Successfully....");
            errorResponse.put("status", "200");

	        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	    }
	    
	    @PutMapping("/ramigani/update")
        public ResponseEntity<Ramigani> updateById(@RequestParam Long id, 
                                                @RequestParam(required = false) String firstName, 
                                                @RequestParam(required = false) String email,
                                                @RequestParam(required = false) String organisation,
                                                @RequestParam(required = false)  String phone,
                                                @RequestParam(required = false) String region,
                                                @RequestParam(required = false)  String inquirytype,
                                                @RequestParam(required = false)  String message)
                                                
  
 {
          
            
            Ramigani ramigani = ramiganiService.updateById(id,firstName,email,organisation,phone,region,inquirytype,message);
            return ResponseEntity.ok(ramigani);
	       // Map<String, String> errorResponse = new HashMap<>();

           // return new ResponseEntity<Ramigani>(errorResponse, HttpStatus.OK);
           
           
        }
}
