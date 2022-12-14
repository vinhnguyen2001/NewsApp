package com.springboot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="news")
public class NewsEntity extends BaseEntity {

	@Column(name="title")
	private String title;
	
	@Column(name="thumbnail")
	private String thumbnail;
	
	@Column(name="shortdescription")
	private String shortDescription;
	@Lob
	@Column(name="content")
	private String content;

	@OneToMany(mappedBy="newsId")
	private List<CommentEntity> comments = new ArrayList<>();

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoryEntity category;


	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
