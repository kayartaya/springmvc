package persistent.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import persistent.entity.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clz) {
		return clz.isAssignableFrom(Product.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "productName", 
				"productName.mandatory", 
				"Product name can not be empty.");
		
		Product p = (Product) obj;
		if(p.getProductName().trim().length()>20){
			errors.rejectValue("productName", 
				"productName.tooBig", "Product name is too big");
		}
		
		if(p.getUnitPrice()<0){
			errors.rejectValue("unitPrice", 
				"unitPrice.negative", "Unit price must >= $0.0");
		}
	}

}





