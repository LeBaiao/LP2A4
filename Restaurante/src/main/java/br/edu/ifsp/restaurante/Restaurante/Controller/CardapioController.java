package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;
import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.PedidoRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.CardapioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cardapio")
public class CardapioController {

    @Autowired
    CardapioRepository cardapioRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public List<CardapioResponseDTO> getAll() {
        return cardapioRepository.findAll() //busca uma lista de pratos
                .stream().map(CardapioResponseDTO::new).toList(); //converte para DTO e tranforma em lista
    }

    @GetMapping("/{id}")
    public Prato findPrato(@PathVariable Integer id) {
        if (cardapioRepository.findById(id).isEmpty()) {
            System.out.println("Prato não encontrado");
            return null;
        } else {
            return cardapioRepository.findById(id).get();
        }
    }

    @PostMapping
    public void addPrato(@RequestBody CardapioRequestDTO data) {
        cardapioRepository.save(new Prato(data));
    }

    @DeleteMapping("/{id}")
    public void removePrato(@PathVariable Integer id) {
        if (cardapioRepository.findById(id).isEmpty()) {
            System.out.println("Id do prato inválido :( ");
        } else {
            cardapioRepository.deleteById(id);
        }
    }


    @PutMapping("/{id}")
    public void editarPrato(@PathVariable Integer id, @RequestBody CardapioRequestDTO data) {
        try{
            Prato prato = new Prato(data);
            prato.setId(id);
            cardapioRepository.save(prato);
        }catch(Exception e){
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

    }
}

