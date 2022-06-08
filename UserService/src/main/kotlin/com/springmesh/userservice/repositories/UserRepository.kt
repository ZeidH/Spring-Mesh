package com.springmesh.userservice.repositories

import com.springmesh.userservice.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository :  CrudRepository<User,Int> {
}