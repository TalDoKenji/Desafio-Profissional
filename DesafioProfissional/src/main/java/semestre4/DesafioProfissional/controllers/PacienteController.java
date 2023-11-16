package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Paciente;
import semestre4.DesafioProfissional.model.repository.PacienteRepository;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> all(){
        return pacienteRepository.findAll();
    }

    @GetMapping("/{cpf}")
    public Paciente buscaById(@PathVariable String cpf){
        return pacienteRepository.findByCpf(cpf).orElse(null);
    }

    @PostMapping
    public Paciente gerarPaciente(@RequestBody Paciente novoPaciente){
        return pacienteRepository.save(novoPaciente);
    }

    @PutMapping("/{cpf}")
    public void alteraPaciente(@PathVariable String cpf, @RequestBody Paciente alteraPaciente){
        Paciente paciente = pacienteRepository.findByCpf(cpf).orElse(new Paciente());

        paciente.setNome(alteraPaciente.getNome());
        paciente.setCpf(alteraPaciente.getCpf());
        paciente.setEndereco(alteraPaciente.getEndereco());
        paciente.setMatricula(alteraPaciente.getMatricula());
        paciente.setUbs(alteraPaciente.getUbs());

        pacienteRepository.save(paciente);
    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public void deletaPaciente(@PathVariable String cpf){
        pacienteRepository.deleteByCpf(cpf);
    }

}
