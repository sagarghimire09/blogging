package edu.mum.cs.blogging.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(nullable = false)
	@NotBlank(message="*This field is required.")
	private String firstName;
	@Column(nullable = false)
	@NotBlank(message="*This field is required.")
	private String lastName;
	@Column(nullable = false, unique = true)
	@NotBlank(message="*This field is required.")
	private String email;
	@Column(nullable = false, unique = true)
	@NotBlank(message="*This field is required.")
	private String username;
	@Column(nullable = false)
	@NotBlank(message="*This field is required.")
	private String password;
	@Transient
	private String confirmPassword;
	private boolean active;
	
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;
	
	@OneToMany(mappedBy = "user")
	private Collection<Post> posts;
}
