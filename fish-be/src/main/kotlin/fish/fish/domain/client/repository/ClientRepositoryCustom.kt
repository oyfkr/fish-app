package fish.fish.domain.client.repository

import fish.fish.domain.client.Client

interface ClientRepositoryCustom {

    fun findByName(name: String) : Client?
}