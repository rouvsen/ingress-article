package az.ingress.repository;

import az.ingress.domain.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<HelloEntity, Integer> {
}
