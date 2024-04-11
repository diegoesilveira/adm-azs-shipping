package com.admazsshipping.api.adapter.input.v1;

import com.admazsshipping.api.adapter.input.dto.FreteDto;
import com.admazsshipping.api.adapter.input.mapper.FreteMapperAdapter;
import com.admazsshipping.api.core.usecase.FreteUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/fretes")
public class FreteController {

    private final FreteUseCase freteUseCase;
    private final FreteMapperAdapter freteMapperAdapter;


    public FreteController(FreteUseCase freteUseCase, FreteMapperAdapter freteMapperAdapter) {
        this.freteUseCase = freteUseCase;
        this.freteMapperAdapter = freteMapperAdapter;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarFrete(@RequestBody FreteDto freteDto) {
        freteUseCase.cadastrarFrete(freteMapperAdapter.toDomain(freteDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<FreteDto>> buscarFretes(@RequestParam(required = false, defaultValue = "") String termoBusca,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        Page<FreteDto> fretes = freteUseCase.buscarFretes(termoBusca, PageRequest.of(page, size))
                .map(freteMapperAdapter::toDto);
        return ResponseEntity.ok(fretes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarFrete(@PathVariable Long id, @RequestBody FreteDto freteDto) {
        freteUseCase.atualizarFrete(id, freteMapperAdapter.toDomain(freteDto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerFrete(@PathVariable Long id) {
        freteUseCase.removerFrete(id);
        return ResponseEntity.noContent().build();
    }
}
