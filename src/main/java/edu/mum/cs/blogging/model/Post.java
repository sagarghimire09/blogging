package edu.mum.cs.blogging.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Title can not be empty.")
	private String title;
	@Column(nullable = false, unique = true)
	private String slug;
	@Lob
	@Column(columnDefinition = "TEXT")
	@NotBlank(message="Please provide content")
	private String body;
	private String image;
	private double avgRating;
	private int ratedCount;
	@CreationTimestamp
	private LocalDate created_at;
	private boolean status;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public int getRatedCount() {
		return ratedCount;
	}
	public void setRatedCount(int ratedCount) {
		this.ratedCount = ratedCount;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", slug=" + slug + ", body=" + body + ", image=" + image
				+ ", avgRating=" + avgRating + ", ratedCount=" + ratedCount + ", created_at=" + created_at + ", status="
				+ status + ", user=" + user + ", category=" + category + "]";
	}
	
	
}
