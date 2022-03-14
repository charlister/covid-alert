package fr.tp.springboottp.repositories;

import fr.tp.springboottp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
