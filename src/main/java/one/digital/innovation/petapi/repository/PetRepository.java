package one.digital.innovation.petapi.repository;

import one.digital.innovation.petapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
