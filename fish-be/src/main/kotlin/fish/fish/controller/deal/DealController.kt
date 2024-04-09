package fish.fish.controller.deal

import fish.fish.controller.deal.request.DealCreateRequest
import fish.fish.domain.deal.dto.DealDTO
import fish.fish.service.DealService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/deal")
class DealController(
    val dealService: DealService
) {

    @PostMapping()
    fun createDeal(@RequestBody dealCreateRequest: DealCreateRequest) : ResponseEntity<DealDTO> {

        val name = SecurityContextHolder.getContext().authentication.name;

        val dealDTO = dealService.createDeal(dealCreateRequest, name)

        return ResponseEntity.ok(dealDTO)
    }

    @GetMapping("/now-page-cnt")
    fun getDealNowPageCnt(@RequestParam dealDate: LocalDate) : ResponseEntity<Int>{
        return ResponseEntity.ok(dealService.getDealNowPageCnt(dealDate));
    }

    @GetMapping("/{cnt}")
    fun getDealByCntAndDate(@PathVariable cnt : Int, dealDate: LocalDate) : ResponseEntity<DealDTO?> {

        val dealDTO : DealDTO? = dealService.getDealByCntAndDate(cnt, dealDate)

        return ResponseEntity.ok(dealDTO);
    }
}