package fish.fish.service

import fish.fish.controller.client.request.ClientCreateRequest
import fish.fish.controller.client.request.ClientModifyRequest
import fish.fish.domain.account.repository.AccountRepository
import fish.fish.domain.client.Client
import fish.fish.domain.client.ClientAgent
import fish.fish.domain.client.dto.ClientDTO
import fish.fish.domain.client.repository.ClientRepository
import fish.fish.support.exception.BaseException
import fish.fish.support.exception.ErrorType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClientService(
    private val accountRepository: AccountRepository,
    private val clientRepository: ClientRepository
) {

    @Transactional
    fun createClient(clientCreateRequest: ClientCreateRequest, accountName: String): ClientDTO {

        val account = accountRepository.findByUsername(accountName) ?: throw BaseException(ErrorType.ACCOUNT_NOT_FOUND)

        val client = Client.of(clientCreateRequest, account)

        if(clientCreateRequest.clientAgent != null) {
            val clientAgents =
                ClientAgent.ofByCreateRequest(clientCreateRequest.clientAgent!!, client)

            client.addClientAgents(clientAgents)
        }

        val savedClient = clientRepository.save(client)

        return ClientDTO.ofByClient(savedClient)
    }

    fun getClients(accountName: String): List<ClientDTO> {

        val clients = clientRepository.findAllByAccountName(accountName)

        return clients.map {ClientDTO.ofByClient(it)}
    }

    fun getClient(id: Long): ClientDTO {

        val client = clientRepository.findByIdWithClientAgent(id) ?: throw BaseException(ErrorType.CLIENT_NOT_FOUND)

        return ClientDTO.ofByClient(client)
    }

    @Transactional
    fun modifyClient(id: Long, clientModifyRequest: ClientModifyRequest): ClientDTO {

        val client = clientRepository.findByIdWithClientAgent(id) ?: throw BaseException(ErrorType.CLIENT_NOT_FOUND)

        val modifiedClient = client.modifyClientByModifyRequest(clientModifyRequest)

        if(clientModifyRequest.clientAgent != null) {
            if(modifiedClient.clientAgent != null) {
                modifiedClient.modifyClientAgent(clientModifyRequest.clientAgent!!)
            } else {
                val clientAgent =
                    ClientAgent.ofByModifyRequest(clientModifyRequest.clientAgent!!, modifiedClient)

                modifiedClient.addClientAgents(clientAgent)
            }
        }

        return ClientDTO.ofByClient(modifiedClient)
    }

    @Transactional
    fun deleteClient(id: Long) {

        val client = clientRepository.findById(id).orElseThrow { BaseException(ErrorType.CLIENT_NOT_FOUND) }

        client.changeToDisabled()
    }

    fun getClientLatestCode(accountName: String): Int {

        val code = clientRepository.findByAccountNameLastOne(accountName)?.code ?: 1

        return code+1
    }
}