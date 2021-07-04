package one.digital.innovation.petapi.utils;

import one.digital.innovation.petapi.dto.request.PetDTO;
import one.digital.innovation.petapi.entity.Pet;

import java.time.LocalDate;
import java.util.Collections;

public class PetUtils {

    private static final String FIRST_NAME = "Totó";
    private static final String BREED_NAME = "Bulldog";
    private static final String RGA_NUMBER = "12346";
    private static final long PET_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010,10,1);

    public static PetDTO createFakeDTO() {
        return PetDTO.builder()
                .firstName(FIRST_NAME)
                .breed(BREED_NAME)
                .rga(RGA_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Pet createFakeEntity() {
        return Pet.builder()
                .id(PET_ID)
                .firstName(FIRST_NAME)
                .breed(BREED_NAME)
                .rga(RGA_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();

    }

}
