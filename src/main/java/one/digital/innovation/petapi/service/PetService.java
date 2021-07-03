package one.digital.innovation.petapi.service;

import one.digital.innovation.petapi.dto.MessageResponseDTO;
import one.digital.innovation.petapi.entity.Pet;
import one.digital.innovation.petapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public MessageResponseDTO createPet(Pet pet){
        Pet savedPet = petRepository.save(pet);
        return MessageResponseDTO
                .builder()
                .message("Created pet with ID " + savedPet.getId())
                .build();
    }
}
