package com.springmesh.itemservice.service

import com.springmesh.itemservice.model.Item
import com.springmesh.itemservice.repositories.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class ItemService(
    @Autowired
    val itemRepository: ItemRepository
) {
    fun getItem(id: Int): Item {
        return itemRepository.findById(id).orElse(null) // todo implement exception handling
    }

    fun getAllItems(): List<Item> {
        return itemRepository.findAll() as List<Item>
    }
}