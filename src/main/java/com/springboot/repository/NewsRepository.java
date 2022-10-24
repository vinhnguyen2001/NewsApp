package com.springboot.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.NewsEntity;

import java.util.List;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

	NewsEntity findNewsEntitiesById(Long id);

	int countNewsEntitiesByShortDescriptionIsContaining(String search);

	List<NewsEntity> findNewsEntitiesByShortDescriptionIsContaining(Pageable pageable,String search);
}
