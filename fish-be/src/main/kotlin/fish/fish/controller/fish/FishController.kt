package fish.fish.controller.fish

import fish.fish.controller.fish.request.FishCreateRequest
import fish.fish.controller.fish.request.FishModifyRequest
import fish.fish.domain.fish.dto.FishDTO
import fish.fish.service.FishService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/fish")
class FishController(
    private val fishService: FishService
) {

    @PostMapping()
    fun createFish(@RequestBody fishCreateRequest: FishCreateRequest) : ResponseEntity<FishDTO> {

        val name = SecurityContextHolder.getContext().authentication.name;

        return ResponseEntity.ok(fishService.createFish(fishCreateRequest, name))
    }

    // 단품 조회
    @GetMapping("/{cnt}")
    fun getFish(@PathVariable cnt : Int) : ResponseEntity<FishDTO> {
        val accountName = SecurityContextHolder.getContext().authentication.name;

        return ResponseEntity.ok(fishService.getFish(cnt, accountName));
    }

    // 여러개 조회
    @GetMapping()
    fun getFishes(): ResponseEntity<List<FishDTO>> {

        val name = SecurityContextHolder.getContext().authentication.name;

        return ResponseEntity.ok(fishService.getFishesOfAccount(name))
    }

    @PatchMapping("/{id}")
    fun modifyFish(@PathVariable id: Long, @RequestBody fishModifyRequest: FishModifyRequest) : ResponseEntity<FishDTO> {

        return ResponseEntity.ok(fishService.modifyFish(id, fishModifyRequest))
    }

    @DeleteMapping("/{id}")
    fun deleteFish(@PathVariable id: Long) : ResponseEntity<Void> {

        fishService.deleteFish(id)

        return ResponseEntity.ok().build()
    }

    @GetMapping("/now-cnt")
    fun getFishNowCnt() : ResponseEntity<Int>{

        val accountName = SecurityContextHolder.getContext().authentication.name;

        return ResponseEntity.ok(fishService.getFishNowCnt(accountName));
    }
}