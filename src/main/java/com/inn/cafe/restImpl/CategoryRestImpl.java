package com.inn.cafe.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.inn.cafe.POJO.Category;
import com.inn.cafe.constants.CafeConstants;
import com.inn.cafe.rest.CategoryRest;
import com.inn.cafe.service.CategoryService;
import com.inn.cafe.utils.CafeUtils;

@RestController
public class CategoryRestImpl implements CategoryRest {
	
	@Autowired
	CategoryService categoryService;

	@Override
	public ResponseEntity<String> addNewCategory(Map<String, String> reqestMap) {
		try {
			return categoryService.addNewCategory(reqestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMTHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<Category>> gatAllCategory(String filterValue) {
		try {
			return categoryService.gatAllCategory(filterValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Category>> (new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	
	}

	@Override
	public ResponseEntity<String> updateCategory(Map<String, String> requestMap) {
		
		try {
			return categoryService.updateCategory(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return CafeUtils.getResponseEntity(CafeConstants.SOMTHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
