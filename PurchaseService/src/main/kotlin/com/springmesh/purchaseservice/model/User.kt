package com.springmesh.purchaseservice.model

import javax.persistence.*


@Entity
@Table(name = "USERS")
data class User(
    @field:Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,
    val name: String,
) {
    constructor(name:String) : this(null,name) {

    }
}