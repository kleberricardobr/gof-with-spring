package com.estudos.gof.controller;

import com.estudos.gof.ViaCep;
import com.estudos.gof.dto.ClienteDTO;
import com.estudos.gof.model.Cliente;
import com.estudos.gof.repository.CepRepository;
import com.estudos.gof.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ViaCep viaCep;
    @Autowired
    private CepRepository cepRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Cliente>> getClientes() {
        var clientes = clienteService.getClientes();

        return clientes.iterator().hasNext() ? new ResponseEntity<>(clientes, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @RequestMapping(path = "{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id) {

        var cliente = clienteService.getCliente(id);
        return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody @Valid ClienteDTO dto) {
        var cliente = getClienteFromRequest(dto);

        if (clienteService.cpfAlreadyUsed(dto.getCpf()))
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var clienteBD = clienteService.saveCliente(cliente);
        return new ResponseEntity<>(clienteBD, HttpStatus.CREATED);
    }

    private Cliente getClienteFromRequest(ClienteDTO dto) {
        var cep = viaCep.getCep(dto.getCep());
        cepRepository.save(cep);

        return Cliente.builder()
                .cpf(dto.getCpf())
                .nome(dto.getNome())
                .telefone(dto.getTelefone())
                .cep(cep)
                .build();
    }
}
