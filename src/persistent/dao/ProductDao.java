package persistent.dao;

import java.util.List;

import persistent.entity.Product;

public interface ProductDao {

	// CRUD operations
	public void saveProduct(Product product) throws DaoException;
	public Product getProductBydId(int id) throws DaoException;
	public void updateProduct(Product product, int id) throws DaoException;
	public void deleteProduct(int id) throws DaoException;
	
	// Query operations
	public List<Product> getAllProducts() throws DaoException;
	public List<Product> getProductsByPrice(double min, double max) throws DaoException;
	public List<Product> getProductsByCategory(int categoryId) throws DaoException;
	
}





