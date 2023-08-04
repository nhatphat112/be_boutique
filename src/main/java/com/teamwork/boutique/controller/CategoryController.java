package com.teamwork.boutique.controller;


import com.teamwork.boutique.payload.request.CategorySaveRequest;
import com.teamwork.boutique.payload.response.BaseResponse;
import com.teamwork.boutique.service.imp.CategoryServiceImp;
import com.teamwork.boutique.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(value = "*")

@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllCategory(){
    BaseResponse response=new BaseResponse();
    response.setStatusCode(200);
    response.setData(categoryServiceImp.getAllCategory());
    return new ResponseEntity<>(response, HttpStatus.OK);
}
    @GetMapping("/{id}")
    public ResponseEntity<?>getProductByCategory(@PathVariable int id){

        BaseResponse response=new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getProductByCategory(id));
        return new ResponseEntity<>(response , HttpStatus.OK);
    }


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<?> createCategory(CategorySaveRequest request){
        Boolean isSuccess =categoryServiceImp.createCate(request);
        BaseResponse response=new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseEntity<?> deletecategory(@Valid CategorySaveRequest request){
        Boolean isSuccess =categoryServiceImp.deleteCate(request);
        BaseResponse response=new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseEntity<?> updateCategory(@Valid CategorySaveRequest request){
        Boolean isSuccess =categoryServiceImp.updateCate(request);
        BaseResponse response=new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public ResponseEntity<?> updateCategory(@Valid CategorySaveRequest request){
//        Boolean isSuccess =categoryServiceImp.updateCate(request);
//        BaseResponse response=new BaseResponse();
//        response.setStatusCode(200);
//        response.setData(isSuccess);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/delete/{categoryId}",method = RequestMethod.POST)
//    public ResponseEntity<?> DeleteCategory(@PathVariable int categoryId){
//        Boolean isSuccess =categoryServiceImp.deleteCate(categoryId);
//        BaseResponse response=new BaseResponse();
//        response.setStatusCode(200);
//        response.setData(categoryServiceImp.deleteCate(categoryId));
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/update/{categoryId}",method = RequestMethod.POST)
//    public ResponseEntity<?> updateCategory(@PathVariable int id) {
//        boolean isSuccess = categoryServiceImp.updateCate(id);
//        BaseResponse response = new BaseResponse();
//        response.setStatusCode(200);
//        response.setData(isSuccess);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

}