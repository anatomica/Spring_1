package Homework4.controllers;

import Homework4.model.Product;
import Homework4.services.ProductsServices;
import Lesson4.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsServices productsServices;

    @Autowired
    public void setProductsServices(ProductsServices productsServices) {
        this.productsServices = productsServices;
    }

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
        productsServices.saveOrUpdate(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productsServices.findById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String modifyProduct(@ModelAttribute Product product) {
        productsServices.saveOrUpdate(product);
        return "redirect:/products/";
    }

    @GetMapping("/find_product")
    public String showFindForm() {
        return "find_product_form";
    }

    @GetMapping("/find_by_minCost")
    public String findByMinCost(Model model, @RequestParam int minCost) {
        List<Product> products = productsServices.findByMinCost(minCost);
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/find_by_maxCost")
    public String findByMaxCost(Model model, @RequestParam int maxCost) {
        List<Product> products = productsServices.findByMaxCost(maxCost);
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/find_by_minMaxCost")
    public String findByMinMaxCost(Model model,
                                   @RequestParam(required = false) int minCost,
                                   @RequestParam(required = false) int maxCost) {
        List<Product> products = productsServices.findByMinMaxCost(minCost, maxCost);
        model.addAttribute("products", products);
        return "all_products";
    }

}
