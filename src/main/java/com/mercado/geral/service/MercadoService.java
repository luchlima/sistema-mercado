package com.mercado.geral.service;


import com.mercado.geral.entity.Mercado;
import com.mercado.geral.repository.MercadoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoService {
    private MercadoRepository mercadoRepository;

    public MercadoService(MercadoRepository mercadoRepository) {
        this.mercadoRepository = mercadoRepository;
    }

    public List<Mercado> create(Mercado mercado){
        mercado.setId(null);
        mercado.calcularValorTotal();
        mercadoRepository.save(mercado);
        return list();
    }

    public List<Mercado> list(){
        Sort sort = Sort.by("preco").descending().and(
                Sort.by("nome").ascending()
        );
        return mercadoRepository.findAll(sort);
    }

    public List<Mercado> update(Mercado mercado){
        if (mercado.getId() == null || !mercadoRepository.existsById(mercado.getId())){
            throw new IllegalArgumentException("Item com id " + mercado.getId() + " não existe!");
        }
        mercado.calcularValorTotal();
        mercadoRepository.save(mercado);
        return list();
    }

    public List<Mercado> delete(Long id){
        mercadoRepository.deleteById(id);
        return list();
    }

}
