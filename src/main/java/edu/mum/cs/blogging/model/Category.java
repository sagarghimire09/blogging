package edu.mum.cs.blogging.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	@Column(nullable = false, unique = true)
	@NotBlank(message = "The name field is required.")
	private String name;
	@Column(columnDefinition = "TEXT")
	private String detail;
	private boolean publish;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate created_at;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Post> posts;
	
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long catgeoryId) {
		this.categoryId = catgeoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public boolean isPublish() {
		return publish;
	}
	public void setPublish(boolean publish) {
		this.publish = publish;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
}
