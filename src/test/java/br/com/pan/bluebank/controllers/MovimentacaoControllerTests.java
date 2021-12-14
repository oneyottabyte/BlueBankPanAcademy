package br.com.pan.bluebank.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pan.bluebank.dtos.ContaDTO;
import br.com.pan.bluebank.dtos.MovimentacaoDTO;
import br.com.pan.bluebank.factories.ContaFactory;
import br.com.pan.bluebank.factories.MovimentacaoFactory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MovimentacaoControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	private Long validId;
	private Long invalidId;
	private Long invalidAgenciaId;
	
	@BeforeEach
	void setUp() throws Exception {
		validId = 1l;
		invalidId = 70l;
		invalidAgenciaId = 1000l;
	}

	@Test
	public void createShouldReturnCorrectMessageWhenValidData() throws Exception {
		
		MovimentacaoDTO dto2 = MovimentacaoFactory.createMovimentacaoDTO();
		
		String jsonBody = objectMapper.writeValueAsString(dto2);
		
		ResultActions result =
				mockMvc.perform(post("/v1/movimentacao")					
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.message").value("Movimentação realizada com sucesso!"));
		
	}
	
	@Test
	public void createShouldReturnBadRequestWhenContaOrigemIdIsNull() throws Exception {
		
		MovimentacaoDTO dto1 = MovimentacaoFactory.createMovimentacaoDTO();
		dto1.setContaOrigemId(null);
		
		String jsonBody = objectMapper.writeValueAsString(dto1);
		
		ResultActions result =
				mockMvc.perform(post("/v1/movimentacao")					
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isBadRequest());
		result.andExpect(jsonPath("$.message").value("The given id must not be null!"));	
		result.andExpect(jsonPath("$.error").value("Illegal Argument"));		
	}
	
	@Test
	public void getAllShouldReturnCorrectData() throws Exception {
			
		ResultActions result =
				mockMvc.perform(get("/v1/movimentacao")
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());		
		
	}
	
	@Test
	public void findByIdShouldReturnCorrectDataWhenValidId() throws Exception {
			
		ResultActions result =
				mockMvc.perform(get("/v1/movimentacao/{validId}", validId)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").value("1"));		
			
	}
	
	@Test
	public void findByIdShouldReturnNotFoundWhenInvalidId() throws Exception {
			
		ResultActions result =
				mockMvc.perform(get("/v1/movimentacao/{invalidId}", invalidId)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());	

	}
	
}
