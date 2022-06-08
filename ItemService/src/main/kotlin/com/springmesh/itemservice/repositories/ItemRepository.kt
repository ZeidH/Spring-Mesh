package com.springmesh.itemservice.repositories

import com.springmesh.itemservice.model.Item
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository :  CrudRepository<Item,Int> {
}