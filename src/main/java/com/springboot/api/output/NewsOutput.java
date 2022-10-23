package com.springboot.api.output;

import java.util.ArrayList;
import java.util.List;

import com.springboot.dto.NewsDTO;

public class  NewsOutput<T>{

	
	private int page;
	private int totalPage;
	private List<T> listResults = new ArrayList<>();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public List<T> getListResults() {
		return listResults;
	}
	public void setListResults(List<T> listResults) {
		this.listResults = listResults;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
