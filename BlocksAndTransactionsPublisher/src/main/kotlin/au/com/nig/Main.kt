package au.com.nig

import au.com.nig.service.AltcoinSubscription
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Main : CommandLineRunner {

    @Autowired lateinit var altcoinSubscription: AltcoinSubscription

    override fun run(vararg args: String?) {
        println("hello 78")

        altcoinSubscription.subscribe()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Main::class.java, *args)
}