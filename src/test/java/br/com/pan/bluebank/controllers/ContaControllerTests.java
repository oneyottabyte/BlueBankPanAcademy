package br.com.pan.bluebank.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
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
import br.com.pan.bluebank.factories.ContaFactory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ContaControllerTests {

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
		ContaDTO dto = ContaFactory.createContaDTO();
		
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result =
				mockMvc.perform(post("/v1/contas")					
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.message").value("Conta criada com sucesso!"));
		
	}
	

	@Test
	public void createShouldReturnNotFoundWhenAgenciaIdIsInvalid() throws Exception {
		
		ContaDTO dto = ContaFactory.createContaDTO();
		dto.setIdAgencia(invalidAgenciaId);
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result =
				mockMvc.perform(post("/v1/contas")					
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
		result.andExpect(jsonPath("$.message").value("Agencia não encontrada!"));	
		result.andExpect(jsonPath("$.error").value("Resource not found"));		
	}
	
	@Test
	public void createShouldReturnIllegalArgumentWhenClienteIdIsNull() throws Exception {
		
		ContaDTO dto = ContaFactory.createContaDTO();
		dto.setIdCliente(null);
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result =
				mockMvc.perform(post("/v1/contas")					
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
				mockMvc.perform(get("/v1/contas")
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$[0].id").value("1"));
		result.andExpect(jsonPath("$[1].id").value("2"));
		
		result.andExpect(jsonPath("$[0].numeroDaConta").value("1234567890"));
		result.andExpect(jsonPath("$[1].numeroDaConta").value("0987654321"));
		
	}

	@Test
	public void findByIdShouldReturnCorrectDataWhenValidId() throws Exception {
			
		ResultActions result =
				mockMvc.perform(get("/v1/contas/{validId}", validId)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").value("1"));
		result.andExpect(jsonPath("$.numeroDaConta").value("1234567890"));
			
	}
	
	@Test
	public void findByIdShouldReturnNotFoundWhenInvalidId() throws Exception {
			
		ResultActions result =
				mockMvc.perform(get("/v1/contas/{invalidId}", invalidId)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());	

	}
		
}
