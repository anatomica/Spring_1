package Homework4.controllers;

import Homework4.model.Product;
import Homework4.services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsServices productsServices;
    // private int page = 0;

    @Autowired
    public void setProductsServices(ProductsServices productsServices) {
        this.productsServices = productsServices;
    }

    @GetMapping
    public String showAllProducts(Model model, @RequestParam(name = "p", defaultValue = "1", required = false) Integer pageNumber) {
        // List<Product> products = productsServices.getAllProducts();
        // page += pageNumber;
        List<Product> products = productsServices.findByPage(pageNumber, 7).getContent();
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
                                   @RequestParam(name = "minCost", required = false) Integer minCost,
                                   @RequestParam(name = "maxCost", required = false) Integer maxCost) {
        List<Product> products;
        if (maxCost == null) products = productsServices.findByMinCost(minCost);
        else if (minCost == null) products = productsServices.findByMaxCost(maxCost);
        else products = productsServices.findByMinMaxCost(minCost, maxCost);
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/change_page")
    public String changePage(Model model, @RequestParam(name = "p", defaultValue = "1", required = false) Integer pageNumber) {
        pageNumber++;
        List<Product> products = productsServices.findByPage(pageNumber, 5).getContent();
        model.addAttribute("products", products);
        return "all_products";
    }

}
