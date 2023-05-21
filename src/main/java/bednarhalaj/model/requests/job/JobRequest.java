package bednarhalaj.model.requests.job;

import bednarhalaj.model.Position;
import bednarhalaj.model.requests.job.state.JobRequestState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
@EqualsAndHashCode
public class JobRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "first_name")
    private String firstname;

    @NonNull
    @Column(name = "surname")
    private String surname;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "address")
    private String address;

    @NonNull
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @NonNull
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "position_id"))
    private Position position;

    @NonNull
    @Embedded
    @Column(name = "state")
    //@Convert(converter = JobRequestStateConverter.class)
    private JobRequestState jobRequestState;
}
