package com.sakshi.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.sakshi.rest.webservices.restfulwebservices.user.post.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//swagger documentation annotation @ApiModelProperty and  @ApiModel
@ApiModel(description = "User model class documenation.")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name should have atleast two characters.")
	@ApiModelProperty(notes = "Name should have atleast two characters.")
	private String name;

	@Past
	@ApiModelProperty(notes = "Birth date should be in past.")
	private Date dob;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	protected User() {
		super();
	}

	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

}
