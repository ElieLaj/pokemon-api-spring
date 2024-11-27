package com.example.pokemonapi.healingItem;

import com.example.pokemonapi.effect.Effect;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/healingItem")
public class HealingItemController {
    private final HealingItemService healingItemService;

    public HealingItemController(HealingItemService healingItemService){
        this.healingItemService = healingItemService;
    }

    @GetMapping
    public List<HealingItem> getAllHealingItems(){
        return healingItemService.getAll();
    }

    @PostMapping
    public HealingItem addHealingItem(@RequestBody HealingItemDTO dto){
        return healingItemService.addHealingItem(dto);
    }

    @PatchMapping(path = "{healingItemId}")
    public HealingItem patchHealingItem(
            @PathVariable Long healingItemId,
            @RequestBody HealingItemDTO dto
    ){
        return healingItemService.patchHealingItem(healingItemId, dto);
    }

    @DeleteMapping(path = "{healingItemId}")
    public void deleteHealingItem(@PathVariable Long healingItemId){
        healingItemService.deleteHealingItem(healingItemId);
    }
}
