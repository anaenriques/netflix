package com.netflix.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.netflix.service.impl.TvShowsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class TvShowsControllerTest {

	
	/** The tv shows service impl. */
	@MockBean
	private TvShowsServiceImpl tvShowsServiceImpl;
	
	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;
	
	
	/**
	 * Test list tv shows by category id.
	 */
	@Test
	void testListTvShowsByCategoryId() throws Exception{
		
////		Calendar calendar= Calendar.getInstance();
////		calendar.get(Calendar.
////		List<TvShowsRestModel> list= new ArrayList<TvShowsRestModel>();
////		list.add(new TvShowsRestModel(1L,"Prueba","Esto es una prueba","Esto es una prueba2",new Date("2005"),16,"Advertising"));
////		
//		when (tvShowsServiceImpl.findByCategoryId(1L)).thenReturn(list);
//		
//		RequestBuilder request = MockMvcRequestBuilders
//				.get("/tv-shows/categories/1");
//				mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().json(""))
//				.andReturn();
	}

	/**
	 * Test list tv show by id.
	 */
	@Test
	void testListTvShowById() {
		fail("Not yet implemented");
	}

}
