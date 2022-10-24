package com.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	

	@OneToMany(mappedBy="category")
	private List<NewsEntity> listNews = new ArrayList<>();

	public List<NewsEntity> getListNews() {
		return listNews;
	}

	public void setListNews(List<NewsEntity> listNews) {
		this.listNews = listNews;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
