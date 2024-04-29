package fish.fish.domain.fish.repository.impl

import com.querydsl.jpa.impl.JPAQueryFactory
import fish.fish.domain.account.Account
import fish.fish.domain.fish.Fish
import fish.fish.domain.fish.repository.FishRepositoryCustom
import org.springframework.stereotype.Component

import fish.fish.domain.fish.QFish.fish
import fish.fish.domain.account.QAccount.account;

@Component
class FishRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : FishRepositoryCustom {
    override fun findByName(name: String): Fish? {
        return queryFactory.selectFrom(fish)
            .where(fish.name.eq(name))
            .fetchOne()
    }

    override fun findByCntAndAccount(cnt: Int, account: Account): Fish? {
        return queryFactory.selectFrom(fish)
            .where(fish.cnt.eq(cnt), fish.account.eq(account))
            .fetchOne()
    }

    override fun findAllByAccount(account: Account): List<Fish> {
        return queryFactory.selectFrom(fish)
            .where(fish.enabled.eq(true), fish.account.eq(account), fish.enabled.eq(true))
            .fetch()
    }

    override fun findByIdWithAccount(id: Long): Fish? {
        return queryFactory.selectFrom(fish)
            .where(fish.id.eq(id))
            .join(fish.account, account).fetchJoin()
            .fetchOne()
    }

    override fun findByAccountLast(accountName: String): Fish? {
        return queryFactory.selectFrom(fish)
            .where(fish.account.username.eq(accountName))
            .orderBy(fish.id.desc())
            .fetchFirst()
    }
}