package fish.fish.service

import fish.fish.controller.deal.request.DealCreateRequest
import fish.fish.domain.account.repository.AccountRepository
import fish.fish.domain.client.repository.ClientRepository
import fish.fish.domain.deal.Deal
import fish.fish.domain.deal.DealItem
import fish.fish.domain.deal.dto.DealDTO
import fish.fish.domain.deal.repository.DealItemRepository
import fish.fish.domain.deal.repository.DealRepository
import fish.fish.domain.fish.repository.FishRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class DealService(
    val dealRepository: DealRepository,
    val dealIteRepository: DealItemRepository,
    val clientRepository: ClientRepository,
    val fishRepository: FishRepository,
    val accountRepository: AccountRepository
) {

    @Transactional(rollbackFor = [Exception::class])
    fun createDeal(dealCreateRequest: DealCreateRequest, username: String) : DealDTO {

        val account = accountRepository.findByUsername(username) ?: throw Exception("account 예외") // 예외처리 필요

        val client = clientRepository.findByName(dealCreateRequest.clientName) ?: throw Exception("거래처 예외") // 예외처리 필요
        val deal = Deal(
            id = null,
            client = client,
            dealItem = null,
            cnt = dealCreateRequest.cnt,
            account = account,
            dealDate = dealCreateRequest.dealDate,
            createdDate = LocalDateTime.now(),
            modifiedDate = null
        )

        val savedDeal = dealRepository.save(deal)

        val dealItemCreateRequests = dealCreateRequest.dealItemCreateRequests

        for(dealItemCreateRequest in dealItemCreateRequests) {
            val fish = fishRepository.findByName(dealItemCreateRequest.fishName) ?: throw Exception("물고기 예외") // 예외처리 필요

            val dealItem = DealItem(
                id = null, fish = fish, deal = savedDeal, weight = dealItemCreateRequest.weight,
                quantity = dealItemCreateRequest.quantity, unit = dealItemCreateRequest.unit,
                unitPrice = dealItemCreateRequest.unitPrice, totalPrice = dealItemCreateRequest.totalPrice, note = dealItemCreateRequest.note
            )

            dealIteRepository.save(dealItem)
        }

        return DealDTO.of(deal)
    }

    fun getDealNowPageCnt(dealDate: LocalDate): Int {

        var cnt = dealRepository.findByLastDeal(dealDate)?.cnt ?: 0

        return cnt
    }

    fun getDealByCntAndDate(cnt: Int, dealDate: LocalDate): DealDTO? {

        val deal = dealRepository.findByCntAndDate(cnt, dealDate) ?: return null// 예외처리필요

        return DealDTO.of(deal)
    }
}