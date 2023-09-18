package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;
import br.edu.ifsp.restaurante.Restaurante.Repository.FuncionarioRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {


    @Autowired
    FuncionarioRepository funcionarioRepository;

    List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<FuncionarioResponseDTO> getAll() {
        return funcionarioRepository.findAll().stream().map(FuncionarioResponseDTO::new).toList();
    }

    @PostMapping
    public void addFuncionario(@RequestBody FuncionarioRequestDTO data){
        funcionarioRepository.save(new Funcionario(data));
    }

    @DeleteMapping("/{id}")
    public void removeFuncionario(@PathVariable Integer id){
        try{
            funcionarioRepository.deleteById(id);
        }catch(Exception e){
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public Funcionario findFuncionario(@PathVariable Integer id) {
        if (funcionarioRepository.findById(id).isEmpty()) {
            System.out.println("Funcionario não encontrado");
            return null;
        }else {
            return funcionarioRepository.findById(id).get();
        }
    }

    @PutMapping("/{id}")
    public void updateFuncionario(@PathVariable Integer id, @RequestBody FuncionarioRequestDTO data){
       try{
           Funcionario funcionario = new Funcionario(data);
           funcionario.setId(id);
           funcionarioRepository.save(funcionario);
       }catch (Exception e){
           System.out.println("Ocorreu um erro ao atualizar o funcionário: " + e.getMessage());
       }
    }


    }

