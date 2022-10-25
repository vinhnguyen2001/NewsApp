
package com.springboot.api.user;

import com.springboot.security.SecurityConfig;
import com.springboot.utils.ValidateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.springboot.api.output.BaseOutput;
import com.springboot.dto.NewsDTO;
import com.springboot.service.INewsService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NewsAPI {

    @Autowired
    private INewsService newsService;


    // URL and where get requests from the client.
    @GetMapping(value = "/news")
    public BaseOutput getNews(@RequestParam("page") Integer page,
                              @RequestParam("limit") Integer limit,
                              @RequestParam("sortBy") String sortBy,
                              @RequestParam("sort") String sort,
                              @RequestParam("search") String search) throws Exception {


        try {

            BaseOutput result = new BaseOutput();

            page = ValidateParams.validatePage(page);
            limit = ValidateParams.validateLimit(limit);
            sortBy = ValidateParams.validateSortBy(sortBy);
            result.setSearch(search.trim());

            Pageable pageable = new PageRequest(page - 1, limit, ValidateParams.validateSort(sort), sortBy);
            result.setListResults(newsService.findNewsByTitle(pageable, result.getSearch()));
            result.setTotalPage((int) Math.ceil((double) newsService.totalItemBySearch(search) / limit));
            result.setPage(page);
            return result;

        } catch (Exception exc) {
            throw new Exception(exc);
        }
    }

    @GetMapping(value = "/news/detail/{id}")
    public NewsDTO getDetailNews(@PathVariable Long id) {
        return newsService.getNewsById(id);
    }

}