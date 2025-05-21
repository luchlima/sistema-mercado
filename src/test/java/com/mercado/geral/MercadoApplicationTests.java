package com.mercado.geral;

import com.mercado.geral.entity.Mercado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MercadoApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateMercadoSucess() {
		var mercado = new Mercado("Arroz", 2.99, 3);

		webTestClient
				.post()
				.uri("/mercado")
				.bodyValue(mercado)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(mercado.getNome())
				.jsonPath("$[0].preco").isEqualTo(mercado.getPreco())
				.jsonPath("$[0].quantidade").isEqualTo(mercado.getQuantidade());
	}

	@Test
	void testCreateMercadoFailure(){
		webTestClient
				.post()
				.uri("/mercado")
				.bodyValue(
						new Mercado("", 0, 0)
				).exchange()
				.expectStatus().isBadRequest();
	}

}
