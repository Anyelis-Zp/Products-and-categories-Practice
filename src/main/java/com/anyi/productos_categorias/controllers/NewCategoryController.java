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
@RequiredArgsConstructor
@RequestMapping("/category")
public class NewCategoryController 
{

    private final CategoryService categoryService;
    private final ProductService productService;

    @RequestMapping("")
    public String showCategory(Model model)
    {
        List <Category> categories = categoryService.list();
        model.addAttribute("categories", categories);
        return"showCategory";

    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("category") Category category) 
    {
        return"newCategory";
    }

    //creando categoria
    @PostMapping("/new")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result )
    {
        if(result.hasErrors())
        {
            return"newCategory";
        }
        else
        {
            categoryService.create(category);
            return "redirect:/category/new";
        }
    }

    @GetMapping("/{id}")
    public String addProduct(@PathVariable("id") Long id, @ModelAttribute("category") Category category, Model model)
    {
        category = categoryService.findId(id);

        List<Product> products = productService.productsWithoutcategories(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "addProduct";
    }

    @PostMapping("/{id}")
    public String saveProductToCategory(@PathVariable("id") Long id, @Valid @ModelAttribute("category") Category category,BindingResult result)
        {
            if (result.hasErrors()) 
            {
                return "addProduct";
            } else 
            {
                Category categoryInBaseData = categoryService.findId(id);
                List <Product> productsList = categoryInBaseData.getProducts();
                productsList.addAll(category.getProducts());
                categoryInBaseData.setProducts(productsList);
                categoryService.create(categoryInBaseData);
            }
            return "redirect:/category/" + id;
        }
}
