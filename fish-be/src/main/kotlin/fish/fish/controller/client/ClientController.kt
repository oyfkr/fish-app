package fish.fish.controller.client

import fish.fish.controller.client.request.ClientCreateRequest
import fish.fish.controller.client.request.ClientModifyRequest
import fish.fish.domain.client.dto.ClientDTO
import fish.fish.service.ClientService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController(
    private val clientService: ClientService
) {

    @GetMapping()
    fun getClients() : ResponseEntity<List<ClientDTO>> {

        val accountName = SecurityContextHolder.getContext().authentication.name;

        return ResponseEntity.ok(clientService.getClients(accountName))
    }

    @GetMapping("/{id}")
    fun getClient(@PathVariable id: Long) : ResponseEntity<ClientDTO> {

        return ResponseEntity.ok(clientService.getClient(id))
    }

    @PostMapping()
    fun createClient(@RequestBody clientCreateRequest: ClientCreateRequest ) : ResponseEntity<ClientDTO> {

        val accountName = SecurityContextHolder.getContext().authentication.name;

        val clientDTO = clientService.createClient(clientCreateRequest, accountName)

        return ResponseEntity.ok(clientDTO)
    }

    @PatchMapping("/{id}")
    fun modifyClient(@PathVariable id: Long, @RequestBody clientModifyRequest: ClientModifyRequest) : ResponseEntity<ClientDTO> {
        return ResponseEntity.ok(clientService.modifyClient(id, clientModifyRequest))
    }

    @DeleteMapping("/{id}")
    fun deleteClient(@PathVariable id: Long) : ResponseEntity<Void> {

        clientService.deleteClient(id)

        return ResponseEntity.ok().build()
    }
}