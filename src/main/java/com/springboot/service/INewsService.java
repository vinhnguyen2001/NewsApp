package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.springboot.dto.NewsDTO;

public interface INewsService {

	
	public NewsDTO save(NewsDTO newsDTO);
	
	public void delete(long[] ids);
	
	public List<NewsDTO> findAll(Pageable pageable);
	
	int totalItem();
//	public NewsDTO update(NewsDTO newsDTO);
}
