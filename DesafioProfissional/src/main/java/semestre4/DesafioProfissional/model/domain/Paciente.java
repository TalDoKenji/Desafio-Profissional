package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import lombok.*;
import semestre4.DesafioProfissional.model.enuns.Ubs;

import java.util.Date;

@Entity
@Table(name = "DP_PACIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paciente {

    @Column(name = "CPF", length = 11)
    @Id
    private String cpf;

    private String nome;

    private Integer Matricula;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    private String ubs;
}
