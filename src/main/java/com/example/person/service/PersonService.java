package com.example.person.service;

import com.example.person.dto.MessageResponseDTO;
import com.example.person.entity.Person;
import com.example.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder()
                .message("Created person with id" + savedPerson.getId())
                .build();
    }

    public void listAll() {
        personRepository.findAll();
    }
}
