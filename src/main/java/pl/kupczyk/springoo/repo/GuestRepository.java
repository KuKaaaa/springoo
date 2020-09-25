package pl.kupczyk.springoo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kupczyk.springoo.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
