package domesticcup.dto.response;


import domesticcup.dto.ParticipantDto;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetParticipantByIdResponse {
    private ParticipantDto participant;
    private String mensagem;
}
