package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    List<Person> listOfPerson = new ArrayList<>(){{
        add(new Person(1,"Nidhi","Patel","nidhi@gmail.com"));
        add(new Person(2,"Apurva","Patel","nidhi2@gmail.com"));
        add(new Person(3,"Rima","Patel","nidhi3@gmail.com"));
        add(new Person(4,"Tejas","Patel","nidhi4@gmail.com"));

    }};

    @GetMapping("/person")
    public List<Person> listOfPerson() {
        return listOfPerson;
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Integer id) {

        Optional<Person> personOptional = listOfPerson.stream().filter(e -> e.getId() == id).findFirst();
        if(personOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id "+id);
        }
        return personOptional.get();
    }
    @PostMapping("/person")
    public void createPerson(@RequestBody Person person){
        listOfPerson.add(person);
    }

    @DeleteMapping("person/{id}")
    public  void deletePerson(@PathVariable Integer id){
        listOfPerson.remove(id=id);
    }
}
