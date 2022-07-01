package com.springmesh.inventoryservice.controller

import com.springmesh.inventoryservice.model.Inventory
import com.springmesh.inventoryservice.model.Item
import com.springmesh.inventoryservice.service.InventoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/inventory")
class InventoryController(
    @Autowired
    val inventoryService: InventoryService
) {

    @GetMapping
    fun getAllInventories(): ResponseEntity<List<Inventory>> {
        return ResponseEntity(inventoryService.getAllInventories(), HttpStatus.OK)
    }

    @GetMapping("/{itemId}")
    fun getInventoryOfItem(@PathVariable("itemId") itemId: Int): ResponseEntity<Inventory> {
        return ResponseEntity(inventoryService.getInventory(itemId), HttpStatus.OK)
    }

    @PostMapping("/{itemId}")
    fun postInventory(@PathVariable("itemId") itemId: Int){
        this.inventoryService.updateInventory(itemId)
    }
}