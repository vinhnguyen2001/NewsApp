package com.springboot.service;

import com.springboot.dto.NewsDTO;

public interface INewsService {

	
	public NewsDTO save(NewsDTO newsDTO);
	
	public void delete(long[] ids);
//	public NewsDTO update(NewsDTO newsDTO);
}
