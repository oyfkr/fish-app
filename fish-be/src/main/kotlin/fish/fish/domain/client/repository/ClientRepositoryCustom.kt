package fish.fish.domain.client.repository

import fish.fish.domain.client.Client

interface ClientRepositoryCustom {

    fun findByName(name: String) : Client?
    fun findAllByAccountName(accountName: String) : List<Client>
    fun findByIdWithClientAgent(id: Long): Client?
    fun findByAccountNameLastOne(accountName: String): Client?
}