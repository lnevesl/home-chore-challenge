package domesticcup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "participants")
public class ParticipantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "participant_id")
    private Long participantId;
    @Setter
    @Column(name = "participant_name", nullable = false)
    private String participantName;
    @Setter
    @Column(name = "participant_active", nullable = false)
    private Boolean active;

}

