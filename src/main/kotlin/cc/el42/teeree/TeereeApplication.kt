package cc.el42.teeree

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["cc.el42.teeree.services"])
@ComponentScan(basePackages = ["cc.el42.teeree.controllers"])
@ComponentScan(basePackages = ["cc.el42.teeree.interceptors"])
@EnableJpaRepositories(basePackages = ["cc.el42.teeree.repositories"])
@EntityScan(basePackages = ["cc.el42.teeree.entities"])
@EnableCaching
class TeereeApplication

fun main(args: Array<String>) {
	runApplication<TeereeApplication>(*args)
}
