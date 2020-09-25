package pl.kupczyk.springoo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.kupczyk.springoo.model.Room;

import java.util.Optional;

@Controller
@RequestMapping("api")
public class SpringooController {

    private final SpringooService springooService;


    @Autowired
    public SpringooController(SpringooService springooService) {
        this.springooService = springooService;
    }

    @RequestMapping("/findAll")
    public Iterable<Room> findAll(){
        return springooService.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Optional<Room> findById(@PathVariable Long id){
        return springooService.findById(id);
    }
}
