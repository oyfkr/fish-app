package fish.fish.service

import fish.fish.domain.client.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository
) {
}