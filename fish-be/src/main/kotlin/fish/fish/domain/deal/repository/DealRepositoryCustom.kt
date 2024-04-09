package fish.fish.domain.deal.repository

import fish.fish.domain.deal.Deal
import java.time.LocalDate

interface DealRepositoryCustom {

    fun findByLastDeal(dealDate: LocalDate) : Deal?
    fun findByCntAndDate(cnt : Int, dealDate: LocalDate) : Deal?
}