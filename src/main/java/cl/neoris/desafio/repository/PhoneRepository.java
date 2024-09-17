package cl.neoris.desafio.repository;

import cl.neoris.desafio.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
