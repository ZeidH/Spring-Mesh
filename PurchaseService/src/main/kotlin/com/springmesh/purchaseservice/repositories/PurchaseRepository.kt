package com.springmesh.userservice.repositories

import com.springmesh.userservice.model.Purchase
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRepository :  CrudRepository<Purchase,Int> {
}