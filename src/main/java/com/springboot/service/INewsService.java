package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.springboot.dto.NewsDTO;

public interface INewsService {


	public NewsDTO getNewsById(Long id);

	public NewsDTO save(NewsDTO newsDTO);
	
	public void delete(long[] ids);
	
	public List<NewsDTO> findAll(Pageable pageable);

	List<NewsDTO> findNewsByTitle(Pageable pageable, String title);
	int totalItem();

	public int totalItemBySearch(String search);
//	public NewsDTO update(NewsDTO newsDTO);
}
