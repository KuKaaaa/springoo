package pl.kupczyk.springoo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kupczyk.springoo.model.Room;

import java.util.Optional;

@Service
public class SpringooService {

    private final SpringooRepository springooRepository;

    @Autowired
    public SpringooService(SpringooRepository springooRepository) {
        this.springooRepository = springooRepository;
    }

    public Iterable<Room> findAll(){
        return springooRepository.findAll();
    }

    public Optional<Room> findById(Long id){
        return springooRepository.findById(id);
    }
}
