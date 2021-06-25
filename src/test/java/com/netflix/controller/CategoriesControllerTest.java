package com.netflix.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.netflix.restModel.CategoriesRestModel;
import com.netflix.service.impl.CategoriesServiceImpl;
import com.netflix.utils.constants.RestConstants;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class CategoriesControllerTest {
	
	/** The categories service impl. */
	@MockBean
	private CategoriesServiceImpl categoriesServiceImpl;
	
	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;
	
	/**
	 * Test categories.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testCategories() throws Exception {
		
		List<CategoriesRestModel> list= new ArrayList<CategoriesRestModel>();
		list.add(new CategoriesRestModel(1L, "Esto es una prueba"));
		
		when (categoriesServiceImpl.listAllCategories()).thenReturn(list);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get(RestConstants.RESOURCE_CATEGORY);
				mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[{\"id\":1,\"name\":\"Esto es una prueba\"}]}"))
				.andReturn();
	}

}

