package com.micro;

import java.math.BigDecimal;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.micro.dto.ProductRequest;

public class ProductControllerTests extends ProductServiceApplicationBase {
    
    @Test
	public void shouldCreateProduct() throws JsonProcessingException, Exception {
		ProductRequest request = getProductRequest();

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("Apple iPad")
				.description("iPad Pro")
				.price(BigDecimal.valueOf(67.78))
				.build();
	}
}
