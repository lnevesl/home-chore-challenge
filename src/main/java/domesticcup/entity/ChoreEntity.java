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
@Table(name = "chore")
public class ChoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chore_id")
    private Long choretId;
    @Setter
    @Column(name = "chore_name", nullable = false)
    private String choretName;
    @Setter
    @Column(name = "chore_description", nullable = false)
    private String choretDescription;
    @Setter
    @Column(name = "chore_active", nullable = false)
    private Boolean active;
}
