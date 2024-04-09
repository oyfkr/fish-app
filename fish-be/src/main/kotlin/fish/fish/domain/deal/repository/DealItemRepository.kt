package fish.fish.domain.deal.repository

import fish.fish.domain.deal.DealItem
import org.springframework.data.jpa.repository.JpaRepository

interface DealItemRepository : JpaRepository<DealItem, Long> {
}