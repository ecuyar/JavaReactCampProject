package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	// if program see geyBy, search for ProductName column and send a query to
	// database containing WHERE ProductName = '...'
	Product getByProductName(String productName);

	Product getByProductNameAndCategoryId(String productName, int id);

	List<Product> getByProductNameOrCategoryId(String productName, int id);

	// select * from products where category_id in (1,2,3,4)...
	List<Product> getByCategoryIdIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	// JPQL
	@Query("From Product Where productName = :productName And categoryId = :categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
}