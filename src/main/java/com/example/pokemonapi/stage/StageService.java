package com.example.pokemonapi.stage;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Stage getRandomStage() {
        List<Stage> stages = stageRepository.findAll();
        return stages.get((int) (Math.random() * stages.size()));
    }

    public Stage modifySTage(Long stageId, Long minLevel, String name) {
        Stage stage = stageRepository.findStageById(stageId);
        if (stage != null){
             if (minLevel != null) {
                 stage.setMinLevel(minLevel);
             }

             if (name != null) {
                 stage.setName(name);
             }
        }
        else {
            throw new IllegalStateException("Stage with id " + stageId + " not found");
        }
        return stageRepository.save(stage);
    }
}
