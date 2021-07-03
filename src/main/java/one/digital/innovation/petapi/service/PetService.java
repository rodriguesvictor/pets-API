package one.digital.innovation.petapi.service;

import one.digital.innovation.petapi.dto.request.PetDTO;
import one.digital.innovation.petapi.dto.response.MessageResponseDTO;
import one.digital.innovation.petapi.entity.Pet;
import one.digital.innovation.petapi.mapper.PetMapper;
import one.digital.innovation.petapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private PetRepository petRepository;

    private final PetMapper petMapper = PetMapper.INSTANCE;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public MessageResponseDTO createPet(PetDTO petDTO){

        Pet petToSave = petMapper.toModel(petDTO);

        Pet savedPet = petRepository.save(petToSave);
        return MessageResponseDTO
                .builder()
                .message("Created pet with ID " + savedPet.getId())
                .build();
    }


}
