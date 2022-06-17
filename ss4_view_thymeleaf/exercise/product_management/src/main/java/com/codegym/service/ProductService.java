package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Colgate", 1500, "new", "Smile"));
        productList.add(new Product(2, "Crest", 2000, "new", "SunShine"));
        productList.add(new Product(3, "P/S", 3000, "new", "P/S"));
        productList.add(new Product(4, "Max fresh", 4000, "new", "Smile"));

    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        for (Product item : productList) {
            if (item.getId() == (id)) {
                product = item;
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        int id = product.getId();
        for (Product item : productList) {
            if (item.getId() == id) {
                item.setName(product.getName());
                item.setPrice(product.getPrice());
                item.setStatus(product.getStatus());
                item.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void remove(int id) {
        Product product = null;
        for (Product item : productList) {
            if (item.getId() == id) {
                product = item;
            }
        }
        productList.remove(product);
    }

    @Override
    public int size() {
        return productList.size();
    }

    @Override
    public List<Product> searchByName(String name) {
            List<Product> productList = new ArrayList<>();
            for (Product item:productList) {
                if (item.getName().contains(name)){
                    productList.add(item);
                }
            }
            return productList;
    }
}
