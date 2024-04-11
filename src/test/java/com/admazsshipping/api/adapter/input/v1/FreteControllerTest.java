package com.admazsshipping.api.adapter.input.v1;

import com.admazsshipping.api.adapter.input.dto.FreteDto;
import com.admazsshipping.api.adapter.input.mapper.FreteMapperAdapter;
import com.admazsshipping.api.core.usecase.FreteUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FreteController.class)
class FreteControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FreteUseCase freteUseCase;

    @MockBean
    private FreteMapperAdapter freteMapperAdapter;

    @Test
    public void buscarFretes_DeveRetornarFretes_QuandoBuscaForBemSucedida() throws Exception {
        // Mock dos parâmetros de busca
        String termoBusca = "termo";
        int page = 0;
        int size = 10;

        // Mock da página de fretes
        Page<FreteDto> pageFretes = new PageImpl<>(Collections.emptyList());

        // Configurar comportamento do mock do caso de uso
        when(freteUseCase.buscarFretes(termoBusca, PageRequest.of(page, size))).thenReturn(new PageImpl<>(Collections.emptyList()));

        // Executar requisição
        mockMvc.perform(get("/v1/fretes")
                        .param("termoBusca", termoBusca)
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Verificar se o método de uso do caso foi chamado
        verify(freteUseCase, times(1)).buscarFretes(termoBusca, PageRequest.of(page, size));
    }


    @Test
    public void removerFrete_DeveRetornarStatusNoContent_QuandoRemocaoForBemSucedida() throws Exception {
        // Mock do id do frete
        Long id = 1L;

        // Executar requisição
        mockMvc.perform(delete("/v1/fretes/{id}", id))
                .andExpect(status().isNoContent());

        // Verificar se o método de uso do caso foi chamado
        verify(freteUseCase, times(1)).removerFrete(id);
    }
}