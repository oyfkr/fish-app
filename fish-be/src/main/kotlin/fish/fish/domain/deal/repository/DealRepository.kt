package fish.fish.domain.deal.repository

import fish.fish.domain.deal.Deal
import fish.fish.domain.deal.DealItem
import org.springframework.data.jpa.repository.JpaRepository

interface DealRepository : JpaRepository<Deal, Long>, DealRepositoryCustom {
}