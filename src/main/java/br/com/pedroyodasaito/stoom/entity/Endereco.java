package br.com.pedroyodasaito.stoom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    @NotBlank(message = "Campo nome da rua é obrigatório.")
    private String streetName;

    @Column
    @NotNull(message = "Campo número da rua é obrigatório.")
    private Integer number;

    @Column
    private String complement;

    @Column
    @NotBlank(message = "Campo bairro é obrigatório.")
    private String neighbourhood;

    @Column
    @NotBlank(message = "Campo cidade é obrigatório.")
    private String city;

    @Column
    @NotBlank(message = "Campo país é obrigatório.")
    private String country;

    @Column
    @NotNull(message = "Campo cep da rua é obrigatório.")
    private Integer zipcode;

    @Column
    private String latitude;

    @Column
    private String longitude;
}
