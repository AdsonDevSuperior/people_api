package com.example.person.service;

import com.example.person.dto.request.PersonDTO;
import com.example.person.dto.response.MessageResponseDTO;
import com.example.person.entity.Person;
import com.example.person.exception.PersonNotFoundException;
import com.example.person.mapper.PersonMapper;
import com.example.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.color.ProfileDataException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder()
                .message("Created person with id" + savedPerson.getId())
                .build();
    }


    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }

    public void deleteId(Long id) throws PersonNotFoundException{
       verifyIfExists(id);
        personRepository.deleteById(id);
    }
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
