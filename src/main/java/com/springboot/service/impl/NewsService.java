package com.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.converter.NewsConverter;
import com.springboot.dto.NewsDTO;
import com.springboot.entity.CategoryEntity;
import com.springboot.entity.NewsEntity;
import com.springboot.repository.CategoryRepository;
import com.springboot.repository.NewsRepository;
import com.springboot.service.INewsService;


@Service
public class NewsService implements INewsService {

	
	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewsConverter newsConverter;
	
	@Override
	public NewsDTO save(NewsDTO newsDTO) {
		
		NewsEntity newsEntity = new NewsEntity();
		
		if(newsDTO.getId() != null) {
			NewsEntity oldNewsEntity = newsRepository.findOne(newsDTO.getId());
			newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity);
		}
		else {
			newsEntity = newsConverter.toEntity(newsDTO);
		}
		
		CategoryEntity  categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		newsEntity.setCategory(categoryEntity);
		newsEntity = newsRepository.save(newsEntity);
		return newsConverter.toDTO(newsEntity);
	}

	@Override
	public void delete(long[] ids) {
		
		for(long id: ids) {
			newsRepository.delete(id);
		}
		
	}

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> results = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		
		for(NewsEntity item: entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			results.add(newsDTO);
		}
		
		return results;
	}

	@Override
	public int totalItem() {
		
		return (int) newsRepository.count();
	}

//	@Override
//	public NewsDTO update(NewsDTO newsDTO) {
//		
//		NewsEntity newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity);
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
//		newsEntity.setCategory(categoryEntity);
//		newsEntity = newsRepository.save(newsEntity);
//		
//		return newsConverter.toDTO(newsEntity);
//		return null;
//	}
}
