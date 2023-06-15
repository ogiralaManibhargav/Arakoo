package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Phone;
import com.example.demo.repository.Repository;

@RestController
public class Controller {
	@Autowired
	Repository repo;
	
	@PostMapping("save")
	public void savePhone(@RequestBody Phone phone)
	{
		repo.save(phone);
	}

}
