package com.example.pokemonapi.pokeball;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokeballService {
    private final PokeballRepository pokeballRepository;

    public PokeballService(PokeballRepository pokeballRepository) {
        this.pokeballRepository = pokeballRepository;
    }

    public Pokeball addPokeball(Pokeball newPokeball) {
        return pokeballRepository.save(newPokeball);
    }

    public void deletePokeball(Long id) {
        pokeballRepository.deleteById(id);
    }

    public List<Pokeball> getAll() {
        return pokeballRepository.findAll();
    }

    public Pokeball updatePokeball(Long id, Pokeball newPokeball) {
        Pokeball pokeball = pokeballRepository.findById(id).orElseThrow(() -> new IllegalStateException("Pokeball with id " + id + " not found"));
        pokeball.setName(newPokeball.getName());
        pokeball.setCatchRate(newPokeball.getCatchRate());
        pokeball.setPrice(newPokeball.getPrice());
        pokeball.setDescription(newPokeball.getDescription());

        return pokeballRepository.save(pokeball);
    }

    public Pokeball getPokeball(Long id) {
        return pokeballRepository.findById(id).orElseThrow(() -> new IllegalStateException("Pokeball with id " + id + " not found"));
    }
}
