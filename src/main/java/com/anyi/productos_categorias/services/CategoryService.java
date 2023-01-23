package com.anyi.productos_categorias.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anyi.productos_categorias.models.Category;
import com.anyi.productos_categorias.models.Product;
import com.anyi.productos_categorias.repositories.CategoryRepository;

@Service
public class CategoryService extends BaseService <Category>
{

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) 
    {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    public List<Category> categoriesWithoutproducts(Product product)
    {
        return categoryRepository.findByProductsNotContains(product);
    }
}
