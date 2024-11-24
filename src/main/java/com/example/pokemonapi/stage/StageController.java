package com.example.pokemonapi.stage;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/stage")
@CrossOrigin
public class StageController {

            private final StageService stageService;


            public StageController(StageService stageService) {
                this.stageService = stageService;
            }

            @GetMapping
            public List<Stage> getStages() {
                return stageService.getStages();
            }

            @GetMapping(path = "{stageId}")
            public Stage getStage(
                    @PathVariable("stageId") Long id) {
                return stageService.getStageById(id);
            }

            @GetMapping(path = "randomStage")
            public Stage getRandomStage() {
                return stageService.getRandomStage();
            }

            @PostMapping
            public Stage createStage(@RequestBody Stage newStage) {
                return stageService.createStage(newStage);
            }

            @DeleteMapping(path = "{stageId}")
            public void deleteStage(@PathVariable("stageId") Long id) {
                stageService.deleteStage(id);
            }

}
