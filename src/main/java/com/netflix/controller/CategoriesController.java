/*
 * Categories Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.exception.NetflixException;
import com.netflix.model.Categories;
import com.netflix.response.NetflixResponse;
import com.netflix.restModel.CategoriesRestModel;
import com.netflix.service.CategoriesServiceI;
import com.netflix.utils.constants.CommonConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;


// TODO: Auto-generated Javadoc
/**
 * The Class CategoriesController.
 */
@RestController
@SwaggerDefinition
public class CategoriesController {
	
	/** The categories service. */
	@Autowired
	@Qualifier("CategoriesServiceImpl")
	
	private CategoriesServiceI categoriesService;
	
	/**
	 * List all categories.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos las categorias"
            ,notes = "Este end point sirve para listar todas las categorias")
	
	@GetMapping("/categories")
	public NetflixResponse<List<CategoriesRestModel>> listAllCategories() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,categoriesService.listAllCategories());
	}
	
	
	
}
