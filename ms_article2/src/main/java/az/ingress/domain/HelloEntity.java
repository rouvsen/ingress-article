package az.ingress.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HelloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer helloId;

    private Integer callCount;

}
