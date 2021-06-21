package br.com.maykontaroco.personapi.service;

import br.com.maykontaroco.personapi.dto.MessageResponseDTO;
import br.com.maykontaroco.personapi.dto.request.PersonDTO;
import br.com.maykontaroco.personapi.entity.Person;
import br.com.maykontaroco.personapi.mapper.PersonMapper;
import br.com.maykontaroco.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service

public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
