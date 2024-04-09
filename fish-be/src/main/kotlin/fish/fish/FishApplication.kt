package fish.fish

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class FishApplication

fun main(args: Array<String>) {
	runApplication<FishApplication>(*args)
}
