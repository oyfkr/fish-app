package fish.fish.service

import fish.fish.controller.deal.request.DealCreateRequest
import fish.fish.controller.deal.request.DealModifyRequest
import fish.fish.domain.account.repository.AccountRepository
import fish.fish.domain.client.Client
import fish.fish.domain.client.repository.ClientRepository
import fish.fish.domain.deal.Deal
import fish.fish.domain.deal.DealItem
import fish.fish.domain.deal.dto.DealDTO
import fish.fish.domain.deal.repository.DealItemRepository
import fish.fish.domain.deal.repository.DealRepository
import fish.fish.domain.fish.Fish
import fish.fish.domain.fish.repository.FishRepository
import fish.fish.support.exception.BaseException
import fish.fish.support.exception.ErrorType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class DealService(
    val dealRepository: DealRepository,
    val dealItemRepository: DealItemRepository,
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
            val fish = fishRepository.findByName(dealItemCreateRequest.fishName) ?: throw BaseException(ErrorType.FISH_NOT_FOUNT) // 예외처리 필요

            val dealItem = DealItem(
                id = null, fish = fish, deal = savedDeal, weight = dealItemCreateRequest.weight,
                quantity = dealItemCreateRequest.quantity, unit = dealItemCreateRequest.unit,
                unitPrice = dealItemCreateRequest.unitPrice, totalPrice = dealItemCreateRequest.totalPrice, note = dealItemCreateRequest.note
            )

            dealItemRepository.save(dealItem)
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

    fun modifyDeal(id: Long, dealModifyRequest: DealModifyRequest): DealDTO {

        val deal = dealRepository.findById(id).orElseThrow { throw Exception("예외처리") }

        val modifiedDeal = deal.modifyDeal(dealModifyRequest)

        // 거래처 입력 수정 로직
        modifyClientOfDeal(modifiedDeal, dealModifyRequest.clientName)

        // deal_item 수정






        return DealDTO.of(modifiedDeal)
    }

    private fun modifyClientOfDeal(deal : Deal, clientName : String) {
        if(!deal.isEqualClient(clientName)) {
            val client : Client = clientRepository.findByName(clientName) ?: throw Exception("예외처리")

            deal.modifyClient(client)
        }
    }

    private fun modifyDealItem(deal : Deal, dealModifyRequest: DealModifyRequest) {
        val dealItems = deal.dealItem

        val dealItemModifyRequests = dealModifyRequest.dealItemModifyRequests

        for(dealItemModifyRequest in dealItemModifyRequests) {
            if(dealItemModifyRequest.id == null) {
                val fish : Fish =
                    fishRepository.findByName(dealItemModifyRequest.fishName) ?: throw Exception("예외처리")

                val dealItem = DealItem(id = null, fish = fish, deal = deal,
                    weight = dealItemModifyRequest.weight, quantity = dealItemModifyRequest.quantity,
                    unit = dealItemModifyRequest.unit, unitPrice = dealItemModifyRequest.unitPrice,
                    totalPrice = dealItemModifyRequest.totalPrice, note = dealItemModifyRequest.note
                )

                dealItemRepository.save(dealItem)
            } else {
                if (dealItems != null) {
                    for(dealItem in dealItems) {
                        if(dealItem.id == dealItemModifyRequest.id) {
                            var fish = dealItem.fish
                            if(!dealItem.isEqualFish(dealItemModifyRequest.fishName)) {
                                fish = fishRepository.findByName(dealItemModifyRequest.fishName) ?: throw Exception("예외처리")
                            }
                            dealItem.modifyDealItem(dealItemModifyRequest, fish)
                        }
                    }
                }
            }
        }

    }
}