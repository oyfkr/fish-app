package fish.fish.domain.fish.repository

import fish.fish.domain.account.Account
import fish.fish.domain.fish.Fish

interface FishRepositoryCustom {

    fun findByName(name:String) : Fish?

    fun findByCntAndAccount(cnt:Int, account: Account) : Fish?

    fun findAllByAccount(account: Account) : List<Fish>
    fun findByIdWithAccount(id: Long): Fish?
}