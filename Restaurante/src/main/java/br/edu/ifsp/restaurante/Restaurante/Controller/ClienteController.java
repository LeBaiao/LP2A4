package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;
}
