package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {

	// dataresult ya da result dönecek her zaman
	DataResult<List<Product>> getAll();

	Result add(Product product);

	// productdao dan aldıklarımızı buraya ekliyoruz sonrada dataresult tipine
	// çeviriyoruz. Dao'ya eklediğimiz metotlar servise eklenince business classtaki
	// productmanagerda çağrılabilir hale geliyor
	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
