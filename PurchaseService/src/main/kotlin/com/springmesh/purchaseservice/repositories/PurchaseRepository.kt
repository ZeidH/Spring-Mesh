package com.springmesh.purchaseservice.repositories

import com.springmesh.purchaseservice.model.Purchase
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRepository :  CrudRepository<Purchase,Int> {
}