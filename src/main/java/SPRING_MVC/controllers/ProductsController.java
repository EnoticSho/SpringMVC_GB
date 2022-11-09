package SPRING_MVC.controllers;

import SPRING_MVC.dao.ProductRepository;
import SPRING_MVC.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("allProducts", repository.getProducts());
        model.addAttribute("product", new Product());
        return "startPage";
    }


    @PostMapping("/products")
    public String addNewProduct(@RequestParam int id, @RequestParam String name, @RequestParam int cost) {
        repository.addProduct(new Product(id, name, cost));
        return "redirect:/products";
    }
}
