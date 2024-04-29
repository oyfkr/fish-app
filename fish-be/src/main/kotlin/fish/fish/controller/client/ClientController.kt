package fish.fish.controller.client

import fish.fish.controller.client.request.ClientCreateRequest
import fish.fish.controller.client.request.ClientModifyRequest
import fish.fish.domain.client.dto.ClientDTO
import fish.fish.service.ClientService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController(
    private val clientService: ClientService
) {

    @GetMapping()
    fun findClients() : ResponseEntity<List<ClientDTO>> {

        return ResponseEntity.ok(listOf(ClientDTO()))
    }

    @GetMapping("/{id}")
    fun getClient(@PathVariable id: Long) : ResponseEntity<ClientDTO> {

        return ResponseEntity.ok(ClientDTO())
    }

    @PostMapping()
    fun createClient(@RequestBody clientCreateRequest: ClientCreateRequest ) : ResponseEntity<ClientDTO> {

        return ResponseEntity.ok(ClientDTO())
    }

    @PatchMapping("/{id}")
    fun modifyClient(@PathVariable id: Long, @RequestBody clientModifyRequest: ClientModifyRequest) : ResponseEntity<ClientDTO> {
        return ResponseEntity.ok(ClientDTO())
    }

    @DeleteMapping("/{id}")
    fun deleteClient(@PathVariable id: Long) : ResponseEntity<Void> {
        return ResponseEntity.ok().build()
    }
}