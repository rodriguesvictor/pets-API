package one.digital.innovation.petapi.service;

import one.digital.innovation.petapi.dto.request.PetDTO;
import one.digital.innovation.petapi.dto.response.MessageResponseDTO;
import one.digital.innovation.petapi.entity.Pet;
import one.digital.innovation.petapi.mapper.PetMapper;
import one.digital.innovation.petapi.repository.PetRepository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static one.digital.innovation.petapi.utils.PetUtils.createFakeDTO;
import static one.digital.innovation.petapi.utils.PetUtils.createFakeEntity;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetMapper petMapper;

    @InjectMocks
    private PetService petService;

    @Test
    public void testGivenPersonDTOThenReturnSuccessSavedMessage(){
       PetDTO petDTO = createFakeDTO();
       Pet expectedSavedPet = createFakeEntity();

       // when(petMapper.toModel(petDTO)).thenReturn(expectedSavedPet);
        when(petRepository.save(any(Pet.class))).thenReturn(expectedSavedPet);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPet.getId());
        MessageResponseDTO successMessage = petService.createPet(petDTO);


        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPetId){
        return MessageResponseDTO.builder()
                .message("Created Pet with ID " + savedPetId)
                .build();
    }

}
