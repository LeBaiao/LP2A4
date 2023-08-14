package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;
}
