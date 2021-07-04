package one.digital.innovation.petapi.mapper;

import one.digital.innovation.petapi.dto.request.PetDTO;
import one.digital.innovation.petapi.dto.request.PhoneDTO;
import one.digital.innovation.petapi.entity.Pet;
import one.digital.innovation.petapi.entity.Phone;
import one.digital.innovation.petapi.utils.PetUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PetMapperTest {

    @Autowired
    private PetMapper petMapper;

    @Test
    public void testGivenPersonDTOThenReturnPersonEntity() {
        PetDTO petDTO = PetUtils.createFakeDTO();
        Pet pet = petMapper.toModel(petDTO);

        assertEquals(petDTO.getFirstName(), pet.getFirstName());
        assertEquals(petDTO.getBreed(), pet.getBreed());
        assertEquals(petDTO.getRga(), pet.getRga());

        Phone phone = pet.getPhones().get(0);
        PhoneDTO phoneDTO = petDTO.getPhones().get(0);

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    @Test
    public void testGivenPersonEntityThenReturnPersonDTO() {
        Pet pet = PetUtils.createFakeEntity();
        PetDTO petDTO = petMapper.toDTO(pet);

        assertEquals(pet.getFirstName(), petDTO.getFirstName());
        assertEquals(pet.getBreed(), petDTO.getBreed());
        assertEquals(pet.getRga(), petDTO.getRga());

        Phone phone = pet.getPhones().get(0);
        PhoneDTO phoneDTO = petDTO.getPhones().get(0);

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }
}
