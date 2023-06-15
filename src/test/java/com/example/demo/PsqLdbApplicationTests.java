package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.example.demo.entity.Phone;
import com.example.demo.repository.Repository;

@SpringBootTest
@Testcontainers
class PsqLdbApplicationTests {
	@Autowired
	private Repository repo;
	

	   @Container
		public static PostgreSQLContainer container = new PostgreSQLContainer("postgres:11.1")
				.withUsername("postgres").withPassword("Manib@27101996").withDatabaseName("Practice");
	    

	@Test
	void contextLoads() {
		Phone phone = new Phone();
		phone.setPhoneNo("6525252");
		repo.save(phone);
		System.out.println(repo.findAll());
		
	}

}
/*@Testcontainers
@SpringBootTest

//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // deactivate the default behaviour

class ContainersApplicationTests  extends PostgreSQLContainer<ContainersApplicationTests> {
	  public static final String IMAGE_VERSION = "postgres:11.1";
	  @Autowired
	  private PersonRepo repo;
	
	 public ContainersApplicationTests() {
	        super(IMAGE_VERSION);
	    }

	
	   @Container
		public static PostgreSQLContainer container = new PostgreSQLContainer("postgres:11.1")
				.withUsername("postgres").withPassword("Manib@27101996").withDatabaseName("testContainers");
	    
	    @DynamicPropertySource
	      public static void properties(DynamicPropertyRegistry registry)
	      {
	    	  registry.add("spring.datasource.url", container::getJdbcUrl);
	    	  registry.add("spring.datasource.password", container::getPassword);
	    	  registry.add("spring.datasource.username", container::getUsername);
	      }
	@Test
	void contextLoads() {
		
		PersonEntity person = new PersonEntity();
		
		person.setAddress("Address2");
		person.setContactNo("0123456ss89");
		person.setName("Jack1");
		
		PersonEntity saveAndFlush = repo.saveAndFlush(person);
		System.out.println(saveAndFlush.getAddress());
		
		
		//System.out.println("Please load" + repo.findAll());
	}

}
*/