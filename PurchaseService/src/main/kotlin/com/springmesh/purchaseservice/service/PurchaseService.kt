package com.springmesh.purchaseservice.service

import com.springmesh.purchaseservice.model.Purchase
import com.springmesh.purchaseservice.repositories.PurchaseRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PurchaseService(
    @Autowired
    private val itemService: ItemService,
    @Autowired
    private val inventoryService: InventoryService,
    @Autowired
    private val purchaseRepository: PurchaseRepository
) {

    var logger: Logger = LoggerFactory.getLogger(PurchaseService::class.java)

    fun purchaseItem(userId: Int, itemId: Int){
        logger.info("Purchasing item with id: $itemId")
        this.itemService.getItemAsync(itemId).subscribe {
            logger.info("Updating Inventory: $itemId")
            this.inventoryService.updateInventory(userId,it)
        }
        logger.info("Transaction has been logged!: $itemId")
        this.purchaseRepository.save(Purchase(null,userId,itemId))
    }
}