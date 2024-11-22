package com.example.pokemonapi.stage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {

    private final StageRepository stageRepository;

    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public Stage getStageByName(String name) {
        return stageRepository.findStageByName(name).orElse(null);
    }

    public Stage getStageById(Long id) {
        return stageRepository.findById(id).orElse(null);
    }

    public Stage createStage(Stage newStage) {
        stageRepository.findStageByName(newStage.getName()).ifPresent(stage -> {
            throw new IllegalStateException("Stage with name " + newStage.getName() + " already exists");
        });
        return stageRepository.save(newStage);
    }

    public List<Stage> getStages() {
        return stageRepository.findAll();
    }

    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }
}
