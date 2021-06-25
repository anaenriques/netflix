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

import com.netflix.exception.NotFoundException;
import com.netflix.model.TvShows;
import com.netflix.restModel.SeasonsRestModel;
import com.netflix.service.impl.SeasonsServiceImpl;
import com.netflix.utils.constants.ExceptionConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class SeasonControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class SeasonControllerTest {
	
	
	/** The Seasons service impl. */
	@MockBean
	private SeasonsServiceImpl seasonsServiceImpl;
	
	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;
	
	
	/**
	 * Testlist seasons by id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistSeasonsById() throws Exception {
		
		List<SeasonsRestModel> list= new ArrayList<SeasonsRestModel>();
		list.add(new SeasonsRestModel(1L, 1,"Esto es una prueba"));
		
		TvShows tvShows = new TvShows();
		tvShows.setId(2L);
		tvShows.setName("Narcos");
		tvShows.setShortDescription("Es una serie muy buena");
		tvShows.setLongDescription("Es una serie muy buena");
		tvShows.setYear(2005);
		tvShows.setRecommendedAge(16);
		tvShows.setAdvertising("Recomendada para un público mayor de 16 años");
		
		when (seasonsServiceImpl.findByTvShows(tvShows)).thenReturn(list);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/tv-shows/1/seasons");
				mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":[]}"))
				.andReturn();
	}
	
	
	/**
	 * Testlist seasons by id not exist.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testlistSeasonsByIdNotExist() throws Exception {
		
		final TvShows tvShows = new TvShows();
		tvShows.setId(Long.getLong("5"));
		when(seasonsServiceImpl.findByTvShows(tvShows)).thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/tv-shows/3/seasons");
				mockMvc.perform(request)
				.andExpect(status().isNotFound())
				.andExpect(content().json(""))
				.andReturn();
	}
	
	/**
	 * Test seasons.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testSeasons() throws Exception{
		
		SeasonsRestModel season= new SeasonsRestModel();
		season.setId(1L);
		season.setName("FIN");
		season.setNumber(25);
		
		when (seasonsServiceImpl.findByTvShowsIdAndNumber(1L,1)).thenReturn(season);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/tv-shows/1/seasons/1");
				mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"status\":\"Success\",\"code\":\"200 OK\",\"message\":\"OK\",\"data\":{\"ID\":1,\"NUMBER\":25,\"NAME\":\"FIN\"}}"))
				.andReturn();
	}
	
	
	/**
	 * Test seasons not exist.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testSeasonsNotExist() throws Exception{
		
		when (seasonsServiceImpl.findByTvShowsIdAndNumber(1L,1)).thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/tv-shows/1/seasons/1");
				mockMvc.perform(request)
				.andExpect(status().isNotFound())
				.andExpect(content().json("{\"status\":\"ERROR\",\"code\":\"404\",\"message\":\"SEASON INEXISTENT - Season does not exist\",\"data\":[]}"))
				.andReturn();
	
	}

}
