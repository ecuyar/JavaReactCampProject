package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {

	// if program see geyBy, search for ProductName column and send a query to
	// database containing WHERE ProductName = '...'
	Product getByProductName(String productName);

	// servise istek atılınca tablo eşleşmelerinden ötürü id yi category nesnesi
	// gibi görüyor hata veriyor.
	// bu yüzden _ yazıp hangi sütunu(id'si) değerlendireceğini yazıyoruz
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	// select * from products where category_id in (1,2,3,4)...
	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	// JPQL
	@Query("From Product Where productName = :productName And category.categoryId = :categoryId")
	List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);

	@Query("Select New kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();

}
