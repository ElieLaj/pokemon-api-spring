package com.example.pokemonapi.pokemon;

import com.example.pokemonapi.move.Move;
import com.example.pokemonapi.move.MoveRepository;
import com.example.pokemonapi.type.Type;
import com.example.pokemonapi.type.TypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final MoveRepository moveRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, MoveRepository moveRepository, TypeRepository typeRepository) {
        this.pokemonRepository = pokemonRepository;
        this.moveRepository = moveRepository;
        this.typeRepository = typeRepository;
    }

    public Pokemon createPokemon(Pokemon newPokemon) {
        pokemonRepository.findPokemonByName(newPokemon.getName()).ifPresent(pokemon -> {
            throw new IllegalStateException("Pokemon with name " + newPokemon.getName() + " already exists");
        });
        return pokemonRepository.save(newPokemon);
    }

    public Pokemon getPokemon(Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new IllegalStateException("Pokemon with id " + id + " not found"));
    }

    public List<Pokemon> getPokemons() {
        return pokemonRepository.findAll();
    }

    public void deletePokemon(Long pokemonId) {
        boolean exists = pokemonRepository.existsById(pokemonId);
        if (!exists) throw new IllegalStateException("Pokemon with id " + pokemonId + " not found");
        pokemonRepository.deleteById(pokemonId);
    }

    @Transactional
    public Pokemon updatePokemon(Long pokemonId, String name, Integer hp, Integer attack, Integer speed, Long typeId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new IllegalStateException("Pokemon with id " + pokemonId + " not found"));

        if (name != null && !name.isEmpty() && !name.equals(pokemon.getName())) {
            pokemonRepository.findPokemonByName(name).ifPresent(p -> {
                throw new IllegalStateException("Pokemon with name " + name + " already exists");
            });
            pokemon.setName(name);
        }

        if (hp != null && hp > 0 && hp != pokemon.getHp()) {
            pokemon.setHp(hp);
        }

        if (attack != null && attack > 0 && attack != pokemon.getAttack()) {
            pokemon.setAttack(attack);
        }

        if (speed != null && speed > 0 && speed != pokemon.getSpeed()) {
            pokemon.setSpeed(speed);
        }

        if (typeId != null && typeId > 0) {
            Type type = typeRepository.findById(typeId).orElseThrow(() -> new IllegalStateException("Move with id " + typeId + " not found"));
            pokemon.addType(type);
        }

        return pokemon;
    }

}


