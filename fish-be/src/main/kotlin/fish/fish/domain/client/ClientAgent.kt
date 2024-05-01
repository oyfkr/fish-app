package fish.fish.domain.client

import fish.fish.controller.client.request.ClientAgentCreateRequest
import fish.fish.controller.client.request.ClientAgentModifyRequest
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Table(name = "client_agent")
@Entity
class ClientAgent(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @Column(name = "name")
    var name : String?, // 성명

    @Column(name = "position")
    var position: String?, // 직책

    @Column(name = "extension")
    var extension: String?, // 내선번호

    @Column(name = "email")
    var email: String?, // 이메일

    @Column(name = "phone_number")
    var phoneNumber: String?, // 자택전화

    @Column(name = "agent_2_name")
    var agent2Name : String?, // 담당자2

    @Column(name = "agent_2_cell_phone_number")
    var agent2CellPhoneNumber : String?, // 휴대폰2

    @Column(name = "agent_2_phone_number")
    var agent2PhoneNumber : String?, // 연락처2

    @Column(name = "agent_2_email")
    var agent2Email : String?, // 이메일2

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "clientAgent")
    var client: Client,

    @CreatedDate
    @Column(name = "created_date")
    var createdDate: LocalDateTime,

    @LastModifiedDate
    @Column(name = "modified_date")
    var modifiedDate: LocalDateTime?
) {

    companion object {
        fun ofByCreateRequest(clientAgentCreateRequest: ClientAgentCreateRequest, client: Client) : ClientAgent {
            return ClientAgent(null, clientAgentCreateRequest.name, clientAgentCreateRequest.position, clientAgentCreateRequest.extension, clientAgentCreateRequest.email, clientAgentCreateRequest.phoneNumber,
                clientAgentCreateRequest.agent2Name, clientAgentCreateRequest.agent2CellPhoneNumber, clientAgentCreateRequest.agent2PhoneNumber, clientAgentCreateRequest.agent2Email ,client, LocalDateTime.now(), null)
        }

        // 거래처 수정인데 client_agent가 기존에 null인 경우
        fun ofByModifyRequest(clientAgentModifyRequest: ClientAgentModifyRequest, client: Client) : ClientAgent {
            return ClientAgent(null, clientAgentModifyRequest.name, clientAgentModifyRequest.position, clientAgentModifyRequest.extension, clientAgentModifyRequest.email, clientAgentModifyRequest.phoneNumber, clientAgentModifyRequest.agent2Name, clientAgentModifyRequest.agent2CellPhoneNumber, clientAgentModifyRequest.agent2PhoneNumber, clientAgentModifyRequest.agent2Email, client, LocalDateTime.now(), null)
        }
    }

    fun modifyByRequest(clientAgentModifyRequest: ClientAgentModifyRequest) : ClientAgent {
        this.name = clientAgentModifyRequest.name
        this.position = clientAgentModifyRequest.position
        this.extension = clientAgentModifyRequest.extension
        this.email = clientAgentModifyRequest.email
        this.phoneNumber = clientAgentModifyRequest.phoneNumber
        this.agent2Name = clientAgentModifyRequest.agent2Name
        this.agent2CellPhoneNumber = clientAgentModifyRequest.agent2CellPhoneNumber
        this.agent2PhoneNumber = clientAgentModifyRequest.agent2PhoneNumber
        this.agent2Email = clientAgentModifyRequest.agent2Email

        return this
    }
}