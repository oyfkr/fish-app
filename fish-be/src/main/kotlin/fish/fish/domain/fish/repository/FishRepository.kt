package fish.fish.domain.fish.repository

import fish.fish.domain.fish.Fish
import org.springframework.data.jpa.repository.JpaRepository

interface FishRepository : JpaRepository<Fish, Long>, FishRepositoryCustom {
}