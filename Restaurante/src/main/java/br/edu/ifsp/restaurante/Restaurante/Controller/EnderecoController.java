package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;
import br.edu.ifsp.restaurante.Restaurante.Repository.EnderecoRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.EnderecoRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.EnderecoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public List<EnderecoResponseDTO> getAll(){
        return enderecoRepository.findAll().stream().map(EnderecoResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Endereco findEndereco(@PathVariable Integer id){
        if(enderecoRepository.findById(id).isEmpty()){
            System.out.println("Endereço não encontrado para esse ID :( ");
            return null;
        }else{
            return enderecoRepository.findById(id).get();
        }
    }

    @PostMapping
    public void addEndereco(@RequestBody EnderecoRequestDTO data){
        enderecoRepository.save(new Endereco(data));
    }

    @PutMapping("/{id}")
    public void updateEndereco(@PathVariable Integer id, @RequestBody EnderecoRequestDTO data){
        Endereco endereco = new Endereco(data);
        endereco.setId(id);
        enderecoRepository.save(endereco);
    }

    @DeleteMapping("/{id}")
    public void removeEndereco(@PathVariable Integer id){
        if(enderecoRepository.findById(id).isEmpty()){
            System.out.println("Endereço não encontrado para ID fornecido :( ");
        }else{
            enderecoRepository.deleteById(id);
        }
    }



}
