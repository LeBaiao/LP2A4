package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Prato;
import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.CardapioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cardapio")
public class CardapioController {

    @Autowired
    CardapioRepository cardapioRepository;

    List<Prato> pratos = new ArrayList<>();

    @GetMapping
    public List<CardapioResponseDTO> getAll() {
        return cardapioRepository.findAll() //busca uma lista de pratos
                .stream().map(CardapioResponseDTO::new).toList(); //converte para DTO
    }

    @PostMapping
    public void addPrato(@RequestBody Prato prato){
        cardapioRepository.save(prato);
    }

    @DeleteMapping("/{id}")
    public void removePrato(@PathVariable Integer id){
    cardapioRepository.deleteById(id);
    }
    @GetMapping("/{id}")
    public Prato findPrato(@PathVariable Integer id) {
        cardapioRepository.findById(id);
        return null;
    }
    @PutMapping("/{id}")
    public void editarPrato(@PathVariable Integer id, @RequestBody CardapioRequestDTO data){
        Prato prato = new Prato(data);
        prato.setId(id);
        cardapioRepository.save(prato);
    }
}
