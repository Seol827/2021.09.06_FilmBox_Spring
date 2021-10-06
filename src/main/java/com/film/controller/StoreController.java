package com.film.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StoreController {

	
	@GetMapping("/store")
	public String store(Model model) {
		model.addAttribute("page","store/storeList.jsp");
		
		return "view";
	}
	
	//상품상세
	@GetMapping("/store/{product_no}")
	public String store(@PathVariable int product_no, Model model) {

		model.addAttribute("page","store/storeDetail.jsp");
		
		return "view";
	}
}