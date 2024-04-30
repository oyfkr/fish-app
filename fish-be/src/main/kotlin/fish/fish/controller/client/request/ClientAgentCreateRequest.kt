package fish.fish.controller.client.request

import jakarta.persistence.Column

class ClientAgentCreateRequest(

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
}