package com.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.product.entities.Product;
import com.product.repository.ProductRepository;

@SpringBootTest
class ProductApplicationTests {
	@Autowired
	private ProductRepository repo;

	@Test
	void contextLoads() {
	}
	
	  @Test void createTest() { Product product=new Product();
	  product.setName("Iphone"); product.setPrice(1000d);
	  product.setDesc("double cam"); repo.save(product);
	  
	  }
	 

	@Test
	void testRead() {
		List<Product> productOptional = repo.findByNameAndPrice("Iphone", 1000d);
		Product product = null;
		
		if (productOptional != null) {
			System.out.println("=========================================================================>"+productOptional.size()+"size");
			productOptional.forEach(a -> System.out.println("name is " + a.getName()));
		} else {
			System.out.println("=========================================================================>");
			System.out.println("nothing found");
		}

	}

	@Test
	void testUpdate() {
		Optional<Product> productOptional = repo.findById(3);
		Product product = null;
		if (productOptional.isPresent()) {
			product = productOptional.get();
			product.setPrice(1200d);

			Product savedProduct = repo.save(product);
			assertEquals(savedProduct.getPrice(), 1200d);
		} else {
			// assertFalse(true);
		}

	}

	/*
	 * @Test void testDelete() { if (repo.existsById(5)) { repo.deleteById(3); } }
	 */
}
