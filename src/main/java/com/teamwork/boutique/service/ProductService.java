package com.teamwork.boutique.service;


import com.teamwork.boutique.entity.ProductEntity;
import com.teamwork.boutique.payload.response.ProductResponse;
import com.teamwork.boutique.repository.ProductRepository;
import com.teamwork.boutique.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {
@Autowired
private ProductRepository productRepository;
    @Override
    public List<ProductResponse> getProductByCategoryID(int id) {
        List<ProductEntity>list=productRepository.findByCategoryId(id);
        List<ProductResponse> listResponse=new ArrayList<>();
        for (ProductEntity data: list){
            ProductResponse productResponse=new ProductResponse();
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setImage(data.getImage());
            productResponse.setImage_list(data.getImageList());
            productResponse.setSold_quantity(data.getSoldQuantity());
            productResponse.setDescription(data.getDesc());
            listResponse.add(productResponse);
        }
            return listResponse;
    }
}
