package persistent.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import persistent.entity.Product;

@Repository("hibernateProductDao")
@SuppressWarnings("unchecked")
public class ProductDaoHibernateTemplateImpl implements ProductDao {
	
	private HibernateTemplate template;
	
	public ProductDaoHibernateTemplateImpl() {
	}
	
	@Autowired(required=false)
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	

	@Override
	public void saveProduct(Product product) throws DaoException {
		try {
			template.save(product);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public Product getProductBydId(int id) throws DaoException {
		try {
			return template.get(Product.class, id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void updateProduct(Product product, int id) throws DaoException {
		try {
			template.update(product);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		try {
			Product product = getProductBydId(id);
			template.delete(product);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	
	@Override
	public List<Product> getAllProducts() throws DaoException {
		try {
			return template.find("from Product");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<Product> getProductsByPrice(double min, double max)
			throws DaoException {
		try {
			return template.find(
				"from Product where unitPrice between ? and ?", min, max);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<Product> getProductsByCategory(int categoryId)
			throws DaoException {
		try {
			return template.find(
				"from Product where categoryId = ?", categoryId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

}
