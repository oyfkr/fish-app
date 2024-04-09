package fish.fish.domain.client.repository.impl

import com.querydsl.jpa.impl.JPAQueryFactory
import fish.fish.domain.client.Client
import fish.fish.domain.client.repository.ClientRepositoryCustom
import org.springframework.stereotype.Component

import fish.fish.domain.client.QClient.client

@Component
class ClientRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : ClientRepositoryCustom {
    override fun findByName(name: String): Client? {
        return queryFactory.selectFrom(client)
            .where(client.name.eq(name))
            .fetchOne()
    }
}