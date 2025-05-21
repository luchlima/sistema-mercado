package com.mercado.geral.controller;

import com.mercado.geral.entity.Mercado;
import com.mercado.geral.service.MercadoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercado")
public class MercadoController {
    private MercadoService mercadoService;

    public MercadoController(MercadoService mercadoService) {
        this.mercadoService = mercadoService;
    }

    @PostMapping
    List<Mercado> create(@RequestBody @Valid Mercado mercado){
        mercado.setId(null);
        return mercadoService.create(mercado);
    }

    @GetMapping
    List<Mercado> list(){
        return mercadoService.list();
    }

    @PutMapping
    List<Mercado> update(@RequestBody @Valid Mercado mercado){
        if (mercado.getId() == null){
            throw new IllegalArgumentException("O campo id é obrigatório para atualização!");
        }
        return mercadoService.update(mercado);
    }

    @DeleteMapping("/{id}")
    List<Mercado> delete(@PathVariable("id") Long id){
        return mercadoService.delete(id);
    }
}
