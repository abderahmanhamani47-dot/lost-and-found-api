package com.polytech.lostandfound.controller;

import com.polytech.lostandfound.dto.ItemRequest;
import com.polytech.lostandfound.model.Item;
import com.polytech.lostandfound.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@Tag(name = "Items", description = "Lost and found item management")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "List all items")
    public List<Item> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an item by id")
    public Item getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a lost or found item")
    public Item create(@Valid @RequestBody ItemRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an item")
    public Item update(@PathVariable Long id, @Valid @RequestBody ItemRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an item")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
