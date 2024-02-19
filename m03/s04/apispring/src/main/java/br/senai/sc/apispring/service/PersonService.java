package br.senai.sc.apispring.service;

import br.senai.sc.apispring.exceptions.PersonNotFoundException;
import br.senai.sc.apispring.model.Person;
import br.senai.sc.apispring.model.transport.PersonDTO;
import br.senai.sc.apispring.model.transport.operations.CreatePersonDTO;
import br.senai.sc.apispring.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.personRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na busca por e-mail: " + username));
    }

    public Person findByEmail(String email) throws PersonNotFoundException {
        LOGGER.info("Buscando usuário por e-mail...");
        return this.personRepository.findByEmail(email)
                .orElseThrow(() -> new PersonNotFoundException("Usuário não encontrado"));
    }

    public Person findById(String guid) throws PersonNotFoundException {
        return this.personRepository.findByGuid(guid)
                .orElseThrow(() -> new PersonNotFoundException("Usuário não encontrado"));
    }

    public PersonDTO findByGuid(String guid) throws PersonNotFoundException {
        return this.personRepository.findByGuid(guid)
                .map(PersonDTO::new)
                .orElseThrow(() -> new PersonNotFoundException("Usuário não encontrado"));
    }

    @Transactional
    public PersonDTO create(CreatePersonDTO createPersonDTO) {
        LOGGER.info("Iniciando a criação de um usuário...");
        String passwordEncoded = this.passwordEncoder.encode(createPersonDTO.password());
        Person person = this.personRepository.save(new Person(createPersonDTO, passwordEncoded));
        return new PersonDTO(person);
    }
}
