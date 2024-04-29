package com.ssafy.sampleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.sampleapp.model.dto.Product;
import com.ssafy.sampleapp.model.service.ProductService;

@RequestMapping("/product")
@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String deptList(Model model) throws Exception {
        System.out.println(model.getAttribute("msg"));
        // 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
        model.addAttribute("products", productService.getAll());
        return "list";
    }

    @PostMapping("/regist")
    protected String registerDept(Product product, Model model)
            throws Exception {
        boolean result = productService.register(product);
        if (result) {
            model.addAttribute("product", product);
            return "list";
        } else {
            return "redirect:/regist";
        }
    }

}
