package com.example.pokemonapi.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/type")
@CrossOrigin
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<Type> getTypes() {
        return typeService.getTypes();
    }

    @GetMapping(path = "{typeId}")
    public Type getType(
            @PathVariable("typeId") Long id) {
        return typeService.getType(id);
    }

    @PostMapping
    public Type createType(@RequestBody Type newType) {
        return typeService.createType(newType);
    }

    @PostMapping(path = "bulk")
    public List<Type> createTypes(@RequestBody List<Type> newTypes) {
        return typeService.createTypes(newTypes);
    }
}
