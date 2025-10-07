package com.mx.PadreHijo;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.PadreHijo.Controller.Padrews;
import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.PadreServiceImp;

@WebMvcTest(Padrews.class)
public class RestControllerTestMock {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private PadreServiceImp service;
	
	@Test
	void PadreMensajeMock() throws Exception{
		//crear algunos registros de prueba
		 Padre padre1 = new Padre(1, "Juan", "Martinez", 45, "Carpintero");
		 Padre padre2 = new Padre(2, "Pedro", "Fernandez", 23, "Mesero");
		 
		 List<Padre> lista = List.of(padre1, padre2);
		 
		 //simulacion: el servicio siempre nos va devolver una lista de padres
		 when(service.listar()).thenReturn(lista);
		 
		 //convertir la lista de padres a JSON
		 ObjectMapper objectMapper = new ObjectMapper();
		 String jsonResponse = objectMapper.writeValueAsString(lista);
		 
		 //realizar la solicitud GET al endpoint listar
		 this.mockMvc.perform(get("/api/padre/listar"))
		 .andDo(print())
		 .andExpect(status().isOk())
		 .andExpect(content().json(jsonResponse));
		 
	}
	
	@Test
	void testGuardarNuevo() throws Exception {
		Padre padre = new Padre(3, "Luis", "Ramirez", 30, "Ingeniero");
		
		// simulacion 
		
		doNothing().when(service).guardar(padre);
		
		//convertir la lista de padres a JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = objectMapper.writeValueAsString(padre);
		
		this.mockMvc.perform(post("/api/padre/guardar") //simular la solicitud http POST
				.contentType("application/json")//se le va a pasar un body de tipo JSOn
				.content(jsonRequest))
			.andDo(print()) //imprimir la respuesta http para la depuracion
			.andExpect(status().isOk()) //Status esperado
			.andExpect(content().string("El padre " + padre.getNombre() + " se guardó exitosamente")); //la respuesta esperada
	}
	
	@Test
	void testBuscarPorId() throws Exception {
		Padre padre = new Padre(1, "Juan", "Martinez", 45, "Carpintero");
		
		when(service.buscar(1)).thenReturn(padre);
		
		//convertir la lista de padres a JSON
				ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = objectMapper.writeValueAsString(padre);
		
		this.mockMvc.perform(get("/api/padre/buscar/{idPadre}", 1)) //simular la solicitud http GET
			.andDo(print()) //imprimir la respuesta http para la depuracion
			.andExpect(status().isOk()) //STATUS esperado
			.andExpect(content().json(jsonResponse)); //la respuesta esperada
	}
	
	@Test
	void testEliminar() throws Exception {
		doNothing().when(service).eliminar(1);
		
		this.mockMvc.perform(delete("/api/padre/eliminar")
				.param("idPadre", "1")) //se le pasa el id del padre a eliminar
			.andDo(print()) //imprimir la respuesta http para la depuracion
			.andExpect(status().isOk()); //status esperado
	}
	
	@Test
	void testEditar() throws Exception {
		Padre padre = new Padre(1, "Juan", "Martinez", 50, "Carpintero");
		
		doNothing().when(service).editar(padre);
		
		//convertir la lista de padres a JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = objectMapper.writeValueAsString(padre);
		
		this.mockMvc.perform(put("/api/padre/editar") //simular la solicitud http PUT
				.contentType("application/json") //se le va a pasar un body de tipo JSOn
				.content(jsonRequest))
			.andDo(print()) //imprimir la respuesta http para la depuracion
			.andExpect(status().isOk()); //status esperado
	}

}
