package br.com.pedroyodasaito.stoom.api.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoInserirDTO {

    @NotBlank(message = "Campo nome da rua é obrigatório.")
    private String streetName;

    @NotNull(message = "Campo número da rua é obrigatório.")
    private Integer number;

    private String complement;

    @NotBlank(message = "Campo bairro é obrigatório.")
    private String neighbourhood;

    @NotBlank(message = "Campo cidade é obrigatório.")
    private String city;

    @NotBlank(message = "Campo país é obrigatório.")
    private String country;

    @NotNull(message = "Campo cep da rua é obrigatório.")
    private Integer zipcode;

    private String latitude;

    private String longitude;

}
