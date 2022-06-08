package com.springmesh.userservice

import com.springmesh.userservice.model.User
import com.springmesh.userservice.repositories.UserRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.text.ParseException


@SpringBootApplication
class UserServiceApplication
{
    @Bean
    fun init(repository: UserRepository): ApplicationRunner? {
        val data = arrayOf(
            arrayOf("John"),
            arrayOf("Karen"),
            arrayOf("Potato")
        )
        return ApplicationRunner { args: ApplicationArguments? ->
            data.forEach {
                try {
                    val user = User(
                        it[0],
                    )
                    repository.save(user)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
            repository.findAll().forEach(System.out::println)
        }
    }
}
fun main(args: Array<String>) {
    runApplication<UserServiceApplication>(*args)
}

