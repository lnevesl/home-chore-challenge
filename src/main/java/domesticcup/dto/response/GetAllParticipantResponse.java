package domesticcup.dto.response;

import domesticcup.dto.ParticipantDto;

import java.util.List;
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
public class GetAllParticipantResponse {

    private List<ParticipantDto> participant;

}
