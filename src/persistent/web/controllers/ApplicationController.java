package persistent.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import persistent.dao.DaoException;
import persistent.dao.ProductDao;
import persistent.entity.Product;
import persistent.validators.ProductValidator;

@Controller
public class ApplicationController {

	@Autowired
	private ProductDao dao;

	@RequestMapping("/products")
	public ModelAndView getAllProducts() throws DaoException {
		return new ModelAndView("displayProducts", "products",
				dao.getAllProducts());
	}
	
	@RequestMapping("delete-product")
	public String deleteProduct(@RequestParam int id) throws DaoException{
		dao.deleteProduct(id);
		return "redirect:products";
	}

	@RequestMapping(value = "/product", params = { "id" })
	public String getOneProduct(@RequestParam("id") int id, Model model)
			throws DaoException {
		Product p = dao.getProductBydId(id);
		model.addAttribute("prd", p);

		return "displayOneProduct";
	}

	@RequestMapping(value = "/edit-product", params = { "id" }, method = RequestMethod.GET)
	public String editProduct(@RequestParam("id") int id, Model model)
			throws DaoException {
		Product p = dao.getProductBydId(id);
		model.addAttribute("prd", p); // command object
		return "productForm";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product p = new Product();
		p.setProductId(-1);
		model.addAttribute("prd", p);
		return "productForm";
	}

	@RequestMapping(value = "/save-product", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("prd") Product p,
			BindingResult errors, HttpServletRequest request)
			throws DaoException {

		Validator v = new ProductValidator();
		v.validate(p, errors);

		if (errors.hasErrors()) {
			return "productForm";
		}

		if (p.getProductId() == -1) {
			dao.saveProduct(p);
		} else {
			dao.updateProduct(p, p.getProductId());
		}

		// request.setAttribute("msg", "Data successfully saved.");
		return "redirect:product?id=" + p.getProductId();
	}
}
