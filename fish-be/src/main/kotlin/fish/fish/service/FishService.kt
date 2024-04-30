package fish.fish.service

import fish.fish.controller.fish.request.FishCreateRequest
import fish.fish.controller.fish.request.FishModifyRequest
import fish.fish.domain.account.repository.AccountRepository
import fish.fish.domain.fish.Fish
import fish.fish.domain.fish.dto.FishDTO
import fish.fish.domain.fish.repository.FishRepository
import fish.fish.support.exception.BaseException
import fish.fish.support.exception.ErrorType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FishService(
    private val accountRepository: AccountRepository,
    private val fishRepository: FishRepository
) {

    @Transactional
    fun createFish(fishCreateRequest: FishCreateRequest, name : String): FishDTO {

        val account = accountRepository.findByUsername(name) ?: throw BaseException(ErrorType.ACCOUNT_NOT_FOUND)

        val fish = Fish.ofByCreateRequest(fishCreateRequest, account)

        val savedFish = fishRepository.save(fish)

        return FishDTO.of(savedFish)
    }

    @Transactional(readOnly = true)
    fun getFish(code: Int, accountName: String): FishDTO? {

        val account = accountRepository.findByUsername(accountName) ?: throw BaseException(ErrorType.ACCOUNT_NOT_FOUND)

        val fish = fishRepository.findByCntAndAccount(code, account) ?:throw BaseException(ErrorType.FISH_NOT_FOUNT)

        return FishDTO.of(fish)
    }

    @Transactional(readOnly = true)
    fun getFishesOfAccount(name: String): List<FishDTO> {

        val account = accountRepository.findByUsername(name) ?: throw BaseException(ErrorType.ACCOUNT_NOT_FOUND)

        val fishDTOs = fishRepository.findAllByAccount(account).map { FishDTO.of(it) }

        return fishDTOs
    }

    @Transactional
    fun modifyFish(id: Long, fishModifyRequest: FishModifyRequest): FishDTO? {

        var fish = fishRepository.findByIdWithAccount(id) ?: throw BaseException(ErrorType.FISH_NOT_FOUNT)

        val modifiedFish = fish.modifyFish(fishModifyRequest)

        return FishDTO.of(modifiedFish)
    }

    @Transactional
    fun deleteFish(id: Long) {

        var fish = fishRepository.findByIdWithAccount(id) ?: throw BaseException(ErrorType.FISH_NOT_FOUNT)

        fish.changeToDisabled()
    }

    fun getFishLatestCode(accountName: String): Int {

        var fish = fishRepository.findByAccountLast(accountName) ?: throw BaseException(ErrorType.FISH_NOT_FOUNT)

        return fish.code + 1
    }
}