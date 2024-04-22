package fish.fish.service

import fish.fish.controller.fish.request.FishCreateRequest
import fish.fish.domain.fish.Fish
import fish.fish.domain.fish.dto.FishDTO
import fish.fish.domain.fish.repository.FishRepository
import org.springframework.stereotype.Service

@Service
class FishService(
    private val fishRepository: FishRepository
) {

    fun createFish(fishCreateRequest: FishCreateRequest): FishDTO? {
        val fish = Fish.ofByCreateRequest(fishCreateRequest)

        val savedFish = fishRepository.save(fish)

        return FishDTO.of(savedFish)
    }
}