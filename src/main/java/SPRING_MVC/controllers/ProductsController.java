package SPRING_MVC.controllers;

import SPRING_MVC.dao.ProductRepository;
import SPRING_MVC.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("allProducts", repository.getProducts());
        model.addAttribute("productInfo", new Product());
        return "startPage";
    }


    @PostMapping("/products")
    public String addNewProduct(@ModelAttribute("productInfo") Product product) {
        repository.addProduct(product);
        return "redirect:/products";
    }

}
