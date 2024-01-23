package com.poiapi.service;

import com.poiapi.helper.Helper;
import com.poiapi.model.Product;
import com.poiapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public void save(MultipartFile file) {

        try {
            List<Product> products = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.productRepo.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    public ByteArrayInputStream createExcel() throws Exception{
        List<Product> all = this.productRepo.findAll();
        return Helper.convertDBDataToExcelData(all);
    }
}
