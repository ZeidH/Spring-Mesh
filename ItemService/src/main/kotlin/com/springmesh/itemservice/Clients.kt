package com.springmesh.itemservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient


class Clients(
    @Value("\${debug}")
    private val debug: String
)  {

}