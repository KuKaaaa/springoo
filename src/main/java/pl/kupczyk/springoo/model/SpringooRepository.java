package pl.kupczyk.springoo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringooRepository extends CrudRepository<Room, Long> {

}
