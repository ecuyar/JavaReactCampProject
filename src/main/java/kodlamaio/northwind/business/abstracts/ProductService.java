package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

	// dataresult ya da result dönecek her zaman
	DataResult<List<Product>> getAll();

	// pagination olan bir servis
	DataResult<List<Product>> getAll(int pageNo, int pageSize);

	DataResult<List<Product>> getAllSorted();

	Result add(Product product);

	// productdao dan aldıklarımızı buraya ekliyoruz sonrada dataresult tipine
	// çeviriyoruz. Dao'ya eklediğimiz metotlar servise eklenince business classtaki
	// productmanagerda çağrılabilir hale geliyor
	DataResult<Product> getByProductName(String productName);

// DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId);

	// service with join
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
