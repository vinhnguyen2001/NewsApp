
package com.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.NewsDTO;
import com.springboot.service.INewsService;

@CrossOrigin
@RestController
public class NewsAPI{
	
	@Autowired
	private INewsService newsService;
	
	
	 // URL and where get requests from the client.
	 @PostMapping(value="/news")
     public NewsDTO createNew(@RequestBody NewsDTO model) {

          return newsService.save(model);
     }
	 
	 @PutMapping(value="/news/{id}")
	 public NewsDTO updateNew(@RequestBody NewsDTO model, @PathVariable("id") Long id ) {
		 model.setId(id);
		 return newsService.save(model);
	 }
	
	 @DeleteMapping(value="/news")
	 public void deleteNew(@RequestBody long[] ids) {
		 
	 }
	 
	 
	
}