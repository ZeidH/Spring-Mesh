package com.springmesh.itemservice.controller

import com.springmesh.itemservice.model.Item
import com.springmesh.itemservice.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/items")
class ItemController(
    @Autowired
    val itemService: ItemService
) {

    @GetMapping
    fun getAllItems(): ResponseEntity<List<Item>> {
        return ResponseEntity(itemService.getAllItems(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getItem(@PathVariable("id") id: Int): ResponseEntity<Item> {
        return ResponseEntity(itemService.getItem(id), HttpStatus.OK)
    }
}