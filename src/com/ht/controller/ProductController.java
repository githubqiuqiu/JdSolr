package com.ht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.model.ResultModel;
import com.ht.service.ProductService;

/**
 *  
 * <p>
 * Title: ProductController
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-12-28 下午5:19:28    @version 1.0
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping("/list")
	public String list(String queryString, String catalog_name, String price,
			String sort, Integer page, Model model) throws Exception {
		ResultModel rm = service.getProducts(queryString, catalog_name, price,
				sort, page);

		// 将查询结果放到request域
		model.addAttribute("result", rm);

		// 简单类型的数据回显
		model.addAttribute("queryString", queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("sort", sort);
		model.addAttribute("page", page);

		return "product_list";
	}

}
