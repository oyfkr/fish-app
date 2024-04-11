package fish.fish.domain.fish.dto

import fish.fish.domain.fish.Fish
import fish.fish.domain.fish.FishCode

class FishDTO(
    var name: String,
    var code: String
) {

    companion object{
        fun of(fish: Fish) : FishDTO {
            return FishDTO(fish.name, fish.code)
        }
    }
}