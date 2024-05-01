package fish.fish.domain.client.repository.impl

import com.querydsl.jpa.impl.JPAQueryFactory
import fish.fish.domain.client.Client
import fish.fish.domain.client.repository.ClientRepositoryCustom
import org.springframework.stereotype.Component

import fish.fish.domain.client.QClient.client
import fish.fish.domain.client.QClientAgent.clientAgent

@Component
class ClientRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : ClientRepositoryCustom {

    override fun findByName(name: String): Client? {
        return queryFactory.selectFrom(client)
            .where(client.name.eq(name))
            .fetchOne()
    }

    override fun findAllByAccountName(accountName: String): List<Client> {
        return queryFactory.selectFrom(client)
            .where(client.account.username.eq(accountName), client.enabled.eq(true))
            .fetch()
    }

    override fun findByIdWithClientAgent(id: Long): Client? {
        return queryFactory.selectFrom(client)
            .where(client.id.eq(id))
            .leftJoin(client.clientAgent, clientAgent).fetchJoin()
            .fetchOne()
    }

    override fun findByAccountNameLastOne(accountName: String): Client? {
//        return queryFactory.selectFrom(client)
//                .where(client.)

        return null
    }
}