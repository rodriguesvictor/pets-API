package one.digital.innovation.petapi.service;

import one.digital.innovation.petapi.dto.request.PetDTO;
import one.digital.innovation.petapi.dto.response.MessageResponseDTO;
import one.digital.innovation.petapi.entity.Pet;
import one.digital.innovation.petapi.exception.PetNotFoundException;
import one.digital.innovation.petapi.mapper.PetMapper;
import one.digital.innovation.petapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    public List<PetDTO> listAll() {
        List<Pet> allPets = petRepository.findAll();
        return allPets.stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PetDTO findById(Long id) throws PetNotFoundException {
        Pet pet = verifyIfExists(id);

        return petMapper.toDTO(pet);
    }

    public void deletePet(Long id) throws PetNotFoundException {
        verifyIfExists(id);
        petRepository.deleteById(id);
    }

    private Pet verifyIfExists (Long id) throws PetNotFoundException {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }
}
