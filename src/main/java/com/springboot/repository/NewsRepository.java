package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

	
}
