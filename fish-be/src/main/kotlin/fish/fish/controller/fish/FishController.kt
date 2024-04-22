package fish.fish.controller.fish

import fish.fish.controller.fish.request.FishCreateRequest
import fish.fish.domain.fish.dto.FishDTO
import fish.fish.service.FishService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fish")
class FishController(
    private val fishService: FishService
) {

    @PostMapping()
    fun createFish(@RequestBody fishCreateRequest: FishCreateRequest) : ResponseEntity<FishDTO> {

        return ResponseEntity.ok(fishService.createFish(fishCreateRequest))
    }
}