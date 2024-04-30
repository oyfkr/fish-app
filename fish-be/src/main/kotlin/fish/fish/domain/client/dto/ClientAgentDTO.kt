package fish.fish.domain.client.dto

import fish.fish.domain.client.ClientAgent

class ClientAgentDTO(

    var id : Long?,

    var name : String?, // 성명

    var position: String?, // 직책

    var extension: String?, // 내선번호

    var email: String?, // 이메일

    var phoneNumber: String?, // 자택전화

    var agent2Name : String?, // 담당자2

    var agent2CellPhoneNumber : String?, // 휴대폰2

    var agent2PhoneNumber : String?, // 연락처2

    var agent2Email : String?, // 이메일2
) {

    companion object {
        fun ofByClientAgent(clientAgent: ClientAgent) : ClientAgentDTO {
            return ClientAgentDTO(clientAgent.id, clientAgent.name, clientAgent.position,clientAgent.extension, clientAgent.email, clientAgent.phoneNumber,
                clientAgent.agent2Name, clientAgent.agent2CellPhoneNumber, clientAgent.agent2PhoneNumber, clientAgent.agent2Email)
        }
    }
}