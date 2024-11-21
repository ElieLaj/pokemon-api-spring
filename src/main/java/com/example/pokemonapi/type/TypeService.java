package com.example.pokemonapi.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type createType(Type newType) {
        typeRepository.findTypeByName(newType.getName()).ifPresent(type -> {
            throw new IllegalStateException("Type with name " + newType.getName() + " already exists");
        });
        return typeRepository.save(newType);
    }

    public Type getType(Long id) {
        return typeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Type with id " + id + " not found"));
    }

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }
}
