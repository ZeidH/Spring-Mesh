package com.springmesh.itemservice.controller

import com.springmesh.itemservice.model.Item
import com.springmesh.itemservice.service.ItemService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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
    var logger: Logger = LoggerFactory.getLogger(ItemController::class.java)

    @GetMapping
    fun getAllItems(): ResponseEntity<List<Item>> {
        logger.info("Getting all items")
        return ResponseEntity(itemService.getAllItems(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getItem(@PathVariable("id") id: Int): ResponseEntity<Item> {
        logger.info("Fetching item with id: $id")
        return ResponseEntity(itemService.getItem(id), HttpStatus.OK)
    }
}