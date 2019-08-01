package com.sakshi.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sakshi.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public Resource<User> findUser(@PathVariable Integer id) {
		User user = userDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("User is not available for id " + id);
		}

		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public User removeUser(@PathVariable Integer id) {
		User user = userDaoService.deleteOne(id);
		if (user == null) {
			throw new UserNotFoundException("User is not available for id " + id + "Can not delete.");
		}
		return user;
	}

}
