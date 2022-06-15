package com.springmesh.userservice

import com.springmesh.userservice.model.User
import com.springmesh.userservice.repositories.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.text.ParseException


@SpringBootApplication
class UserServiceApplication(
    @Value("\${debug}")
    private val debug: String
)
{
    var logger: Logger = LoggerFactory.getLogger(UserServiceApplication::class.java)

    @Bean
    fun init(repository: UserRepository): ApplicationRunner? {
        if(this.debug.toBoolean()){
            logger.warn("Application running in local mode")
        } else {
            logger.warn("Application running in cloud mode")
        }
        val data = arrayOf(
            arrayOf("John"),
            arrayOf("Karen"),
            arrayOf("Potato")
        )
        return ApplicationRunner {
            data.forEach {
                try {
                    val user = User(null,
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

