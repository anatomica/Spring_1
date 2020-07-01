package Homework2.controllers;

import Homework2.model.Product;
import Homework2.services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsServices productsServices;

    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = productsServices.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_product_form";
    }

    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute Product newProduct) {
        productsServices.modifyProduct(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productsServices.findById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String modifyProduct(@ModelAttribute Product product) {
        productsServices.modifyProduct(product);
        return "redirect:/products/";
    }

}
