package pl.kupczyk.springoo.business.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kupczyk.springoo.business.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
