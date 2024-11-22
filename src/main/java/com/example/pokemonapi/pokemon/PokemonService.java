package com.example.pokemonapi.pokemon;

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
    private final TypeRepository typeRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, MoveRepository moveRepository, TypeRepository typeRepository) {
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
    }

    public Pokemon createPokemon(Pokemon newPokemon, List<String> typeNames) {
        pokemonRepository.findPokemonByName(newPokemon.getName()).ifPresent(pokemon -> {
            throw new IllegalStateException("Pokemon with name " + newPokemon.getName() + " already exists");
        });

        for (String typeName : typeNames) {
            Type type = (
                    typeRepository.findTypeByName(typeName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Type with name " + typeName + " not found")
                            )
            );
            newPokemon.addType(type);
        }

        newPokemon.setMaxHp(newPokemon.getHp());
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
    public Pokemon updatePokemon(Long pokemonId, String name, Integer hp, Integer attack, Integer defense, Integer specialAttack, Integer specialDefense, Integer speed, Integer expRate, Long typeId, String typeName) {
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
            pokemon.setMaxHp(hp);
        }

        if (attack != null && attack > 0 && attack != pokemon.getAttack()) {
            pokemon.setAttack(attack);
        }

        if (defense != null && defense > 0 && defense != pokemon.getDefense()) {
            pokemon.setDefense(defense);
        }

        if (specialAttack != null && specialAttack > 0 && specialAttack != pokemon.getSpecialAttack()) {
            pokemon.setSpecialAttack(specialAttack);
        }

        if (specialDefense != null && specialDefense > 0 && specialDefense != pokemon.getSpecialDefense()) {
            pokemon.setSpecialDefense(specialDefense);
        }

        if (speed != null && speed > 0 && speed != pokemon.getSpeed()) {
            pokemon.setSpeed(speed);
        }

        if (expRate != null && expRate > 0 && expRate != pokemon.getExpRate()) {
            pokemon.setExpRate(expRate);
        }

        if (typeId != null && typeId > 0 && pokemon.getTypes().size() < 2) {
            Type type = typeRepository.findById(typeId).orElseThrow(() -> new IllegalStateException("Move with id " + typeId + " not found"));
            pokemon.addType(type);
        }

        if (typeName != null && pokemon.getTypes().size() < 2 && (pokemon.getTypes().isEmpty() || (pokemon.getTypes().stream().noneMatch(type -> {return typeName.equals(type.getName()); } )) )) {
            Type type = (
                    typeRepository.findTypeByName(typeName)
                            .orElseThrow(() -> new IllegalStateException
                                    ("Type with name " + typeName + " not found")
                            )
            );
            pokemon.addType(type);
        }

        return pokemon;
    }

    @Transactional
    public Pokemon resetType(Long pokemonId) {
        System.out.println("resetType");
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new IllegalStateException("Pokemon with id " + pokemonId + " not found"));
        pokemon.deleteTypes();
        return pokemon;
    }


}


