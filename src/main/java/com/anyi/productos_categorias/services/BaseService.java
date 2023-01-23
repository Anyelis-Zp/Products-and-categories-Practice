package com.anyi.productos_categorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anyi.productos_categorias.repositories.BaseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public abstract class BaseService <T>
{
    private final BaseRepository <T> baseRepository;

    public T findId(Long id)
    {
        Optional <T> optional = baseRepository.findById(id);
        if(optional.isPresent())
        {
            return optional.get();
        }
        else 
        {
            return null;
        }
    }

    //listar modelos

    public List <T> list()
    {
        return baseRepository.findAll();
    }

    
    //guardar
    public T create(T object)
    {
        return baseRepository.save(object);
    }
}
