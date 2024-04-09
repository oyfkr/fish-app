package fish.fish.domain.client.repository

import fish.fish.domain.client.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Long>, ClientRepositoryCustom {
}