package fish.fish.domain.fish.repository.impl

import com.querydsl.jpa.impl.JPAQueryFactory
import fish.fish.domain.fish.Fish
import fish.fish.domain.fish.repository.FishRepositoryCustom
import org.springframework.stereotype.Component

import fish.fish.domain.fish.QFish.fish

@Component
class FishRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : FishRepositoryCustom {
    override fun findByName(name: String): Fish? {
        return queryFactory.selectFrom(fish)
            .where(fish.name.eq(name))
            .fetchOne()
    }
}