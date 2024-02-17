package az.ingress.domain;

import jakarta.persistence.*;
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
