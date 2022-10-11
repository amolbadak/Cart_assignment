package spring.boot.loan.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.loan.constants.LoanConstants;
import spring.boot.loan.entity.Customer;
import spring.boot.loan.service.CustomerService;


@Controller
public class HomeController {

	@Autowired
	private CustomerService custservice;
	
	
	@GetMapping("/register")
	public String signup(Map<String, String[]> map,
			Map<String, String> map1,
			@RequestParam(required = false) String error)
	{
		map.put("types", LoanConstants.ID_TYPE);
		map1.put("error",error);
		return "register";
	}
	@GetMapping("/login")
	public String login()
	{
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("cust");
		session.removeAttribute("custemail");
		session.invalidate();
		return "redirect:/login";
	}
	
	@PostMapping("/add")
	public String insertCustomer(Customer customer, Map<String, String> map) {
		System.out.println(customer);
		String error = null;
			try {
				if(this.custservice.addCustomer(customer))
				{
					return "redirect:/login";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = "Could not register, please try again later";
				return "register";
			}
			error = "Could not register, email id already exists";
			return "redirect:/register?error="+error;
	}
	
	
//	@PostMapping("/login")
//	public String validate(User user,
//			HttpSession session,
//			Map<String , String> map)
//	{
//		
//		System.out.println("post user "+user);
//		Customer customer;
//		try {
//			customer = this.custservice.findCustomerByEmail(user.getEmail());
//			if(customer.getPassword().equals(user.getPassword())) {
//				session.setAttribute("custemail", user.getEmail());
//				session.setAttribute("cust", customer);
//				return "redirect:/customers/"+customer.getCustemail();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			map.put("error", "Contact admin");
//		}
//		map.put("error", "Check your credentials");
//		return "login";
//	}
	
	
	
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//	}
}
