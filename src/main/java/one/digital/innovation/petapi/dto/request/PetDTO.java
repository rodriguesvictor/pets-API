package one.digital.innovation.petapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2,max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 4,max = 100)
    private String breed;


    @NotNull
    @Size(max = 5)
    private String rga;

    @NotEmpty
    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;


}
