package pl.kupczyk.springoo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kupczyk.springoo.model.Room;
import pl.kupczyk.springoo.repo.RoomRepository;

import java.util.Optional;

@Service
public class SpringooService {

    private final RoomRepository roomRepository;

    @Autowired
    public SpringooService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Iterable<Room> findAll(){
        return roomRepository.findAll();
    }

    public Optional<Room> findById(Long id){
        return roomRepository.findById(id);
    }
}
