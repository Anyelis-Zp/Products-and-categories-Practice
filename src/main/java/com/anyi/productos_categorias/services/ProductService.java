package com.anyi.productos_categorias.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anyi.productos_categorias.models.Category;
import com.anyi.productos_categorias.models.Product;
import com.anyi.productos_categorias.repositories.ProductRepository;
@Service
public class ProductService extends BaseService <Product> 
{
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        super(productRepository);
        this.productRepository = productRepository;
    }
    public List<Product> productsWithoutcategories(Category category)
    {
        return productRepository.findByCategoriesNotContains(category);
    }

}
