package fish.fish.domain.fish.repository

import fish.fish.domain.fish.Fish

interface FishRepositoryCustom {

    fun findByName(name:String) : Fish?
}