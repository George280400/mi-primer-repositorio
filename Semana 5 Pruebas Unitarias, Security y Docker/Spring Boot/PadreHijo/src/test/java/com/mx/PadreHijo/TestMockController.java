package com.mx.PadreHijo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc //configura MockMVC para probar controladores
public class TestMockController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void PruebaMockitoMensajePredeterminado() throws Exception{
		this.mockMvc.perform(get("/"))//simular la solicitud http GET
		.andDo(print()) //imprimir la respuesta http para la depuracion
		.andExpect(status().isOk()) //SStatus esperado
		.andExpect(content().string(containsString("Hola, Mundo")));//la respuesta esperada
	}

}
