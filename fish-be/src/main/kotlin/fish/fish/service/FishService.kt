package fish.fish.service

import fish.fish.controller.fish.request.FishCreateRequest
import fish.fish.domain.account.repository.AccountRepository
import fish.fish.domain.fish.Fish
import fish.fish.domain.fish.dto.FishDTO
import fish.fish.domain.fish.repository.FishRepository
import fish.fish.support.exception.BaseException
import fish.fish.support.exception.ErrorType
import org.springframework.stereotype.Service

@Service
class FishService(
    private val accountRepository: AccountRepository,
    private val fishRepository: FishRepository
) {

    fun createFish(fishCreateRequest: FishCreateRequest, name : String): FishDTO? {

        val account = accountRepository.findByUsername(name) ?: throw BaseException(ErrorType.ACCOUNT_NOT_FOUND)

        val fish = Fish.ofByCreateRequest(fishCreateRequest, account)

        val savedFish = fishRepository.save(fish)

        return FishDTO.of(savedFish)
    }
}