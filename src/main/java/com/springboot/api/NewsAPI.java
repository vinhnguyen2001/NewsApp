
package com.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.springboot.api.output.NewsOutput;
import com.springboot.dto.NewsDTO;
import com.springboot.service.INewsService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NewsAPI{
	
	@Autowired
	private INewsService newsService;
	
	
	 // URL and where get requests from the client.
	 @GetMapping(value="/news")
     public NewsOutput createNews(@RequestParam("page") int page, 
    		 					 @RequestParam("limit") int limit,
    		 					@RequestParam("sort") String sort) {
		 
		 System.out.println("sort"+ sort);
		 NewsOutput result = new NewsOutput();
		 result.setPage(page);
		 Pageable pageable  = new PageRequest(page - 1, limit,Sort.Direction.DESC, sort);
		 result.setListResults(newsService.findAll(pageable));
		 result.setTotalPage((int)Math.ceil((double) newsService.totalItem() / limit));

		 
		 return result;
     }
	 
	 
	 @PostMapping(value="/news")
	 public NewsDTO createNews(@RequestBody NewsDTO model) {
		 
		 return newsService.save(model);
	 }
	 
	 @PutMapping(value="/news/{id}")
	 public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") Long id ) {
		 model.setId(id);
		 return newsService.save(model);
	 }
	
	 @DeleteMapping(value="/news")
	 public void deleteNews(@RequestBody long[] ids) {
		 newsService.delete(ids);
	 }
	 
	 
	
}