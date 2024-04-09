package fish.fish.domain.deal.repository.impl

import com.querydsl.jpa.impl.JPAQueryFactory
import fish.fish.domain.deal.Deal
import fish.fish.domain.deal.repository.DealRepositoryCustom
import org.springframework.stereotype.Component

import fish.fish.domain.deal.QDeal.deal
import java.time.LocalDate

@Component
class DealRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : DealRepositoryCustom{

    override fun findByLastDeal(dealDate: LocalDate): Deal? {
        return queryFactory.selectFrom(deal)
            .where(deal.dealDate.eq(dealDate))
            .orderBy(deal.id.desc())
            .fetchFirst()
    }

    override fun findByCntAndDate(cnt: Int, dealDate: LocalDate): Deal? {
        return queryFactory.selectFrom(deal)
                .where(deal.cnt.eq(cnt).and(deal.dealDate.eq(dealDate)))
                .fetchOne()
    }
}