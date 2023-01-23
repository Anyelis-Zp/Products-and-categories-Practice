package com.anyi.productos_categorias.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.anyi.productos_categorias.models.Category;
import com.anyi.productos_categorias.models.Product;
import com.anyi.productos_categorias.services.CategoryService;
import com.anyi.productos_categorias.services.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class NewProductController 
{
    private final ProductService productService;
    private final CategoryService categoryService;

    //listar products
    @RequestMapping("")
    public String listProduct(Model model)
    {
        List <Product> products = productService.list();
        model.addAttribute("products", products);
        return "showProduct";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product) 
    {
        return"newProduct";
    }

    //creando producto
    @PostMapping("/new")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result ){
    if(result.hasErrors())
    {
        return"newProduct";
    }
    else
    {
        productService.create(product);
        return "redirect:/product/new";
    }
}

//Añadir categoria a un producto 
    @GetMapping("/{id}")
    public String addCategory(@PathVariable("id") Long id, @ModelAttribute("product") Product product, Model model)
    {
        product = productService.findId(id);
        
        List <Category> categories = categoryService.categoriesWithoutproducts(product);
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return"addCategory";
    }
    

    @PostMapping("/{id}")
    public String saveCategoryToProduct(
        @PathVariable("id") Long id,
        @Valid @ModelAttribute("product") Product product, 
        BindingResult result) 
        {
            if (result.hasErrors()) 
            {
                return "addCategory";
            } 
            else 
            {
                Product productInBaseData = productService.findId(id);
                List <Category> categorias = productInBaseData.getCategories();
                categorias.addAll(product.getCategories());
                productInBaseData.setCategories(categorias);
                productService.create(productInBaseData);
            }
        return "redirect:/product/" + id;
    }
}

