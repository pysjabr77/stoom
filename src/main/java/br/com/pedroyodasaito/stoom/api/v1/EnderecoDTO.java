package br.com.pedroyodasaito.stoom.api.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Integer id;
    private String streetName;
    private Integer number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String country;
    private Integer zipcode;
    private String latitude;
    private String longitude;

}
