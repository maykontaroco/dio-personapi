package br.com.maykontaroco.personapi.repository;

import br.com.maykontaroco.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
