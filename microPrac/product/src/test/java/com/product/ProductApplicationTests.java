package com.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.product.entities.Product;
import com.product.repository.ProductRepository;

@SpringBootTest
class ProductApplicationTests {
	@Autowired
	private ProductRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	void createTest() {
		
		/*
		 * for(int i=0;i<1000;i++) {
		 * 
		 * Product product = new Product(); product.setName("Iphone-"+i);
		 * product.setPrice(1000d+i); product.setDesc("version "+i); repo.save(product);
		 * 
		 * 
		 * }
		 */
		

	}

	@Test
	void testRead() {
		List<Product> productOptional = repo.findByNameAndPrice("Iphone", 1000d);
		Product product = null;

		if (productOptional != null) {
			System.out.println("=========================================================================>"
					+ productOptional.size() + "size");
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
@Test
void testPageable() 
{
Pageable pageable= PageRequest.of(0,10,Sort.by("name").descending().and(Sort.by("price")));
Page<Product> resultList=repo.findAll(pageable)	;
resultList.forEach(p->System.out.println(p));

}


}
