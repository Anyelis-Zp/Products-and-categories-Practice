package com.anyi.productos_categorias.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anyi.productos_categorias.models.Category;
import com.anyi.productos_categorias.models.Product;

@Repository
public interface ProductRepository extends BaseRepository <Product>
{
    List<Product> findByCategoriesNotContains(Category category);
}
