package cl.neoris.desafio.repository;

import cl.neoris.desafio.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, String> {
}
