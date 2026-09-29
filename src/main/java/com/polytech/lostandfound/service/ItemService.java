package com.polytech.lostandfound.service;

import com.polytech.lostandfound.dto.ItemRequest;
import com.polytech.lostandfound.exception.ItemNotFoundException;
import com.polytech.lostandfound.model.Item;
import com.polytech.lostandfound.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> findAll() {
        return repository.findAll();
    }

    public Item findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Item create(ItemRequest request) {
        return repository.save(new Item(
                request.title(), request.description(), request.category(),
                request.location(), request.date(), request.status()
        ));
    }

    public Item update(Long id, ItemRequest request) {
        Item item = findById(id);
        item.update(request.title(), request.description(), request.category(),
                request.location(), request.date(), request.status());
        return repository.save(item);
    }

    public void delete(Long id) {
        Item item = findById(id);
        repository.delete(item);
    }
}
