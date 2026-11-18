package domesticcup.dto.request;
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
public class UpdateParticipantRequest {
    private Long participantId;
    private String participantName;
    private Boolean active;
}
