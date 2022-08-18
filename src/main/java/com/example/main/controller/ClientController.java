package com.example.main.controller;

import com.example.main.model.ClientEntity;
import com.example.main.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/clients")
    public ClientEntity createClient(@RequestBody ClientEntity client){
        return clientService.createClient(client);
    }

    @RequestMapping(value="/clients",method =RequestMethod.GET)
    public List<ClientEntity> readClients(){
        return clientService.getClients();
    }

    @RequestMapping(value="/clients/{clientId}",method = RequestMethod.PUT)
    public ClientEntity updateClient(@PathVariable(value="clientId") Integer id, @RequestBody ClientEntity clientDetails){
        return clientService.updateClient(id,clientDetails);
    }

    @RequestMapping(value="/clients/{clientId}",method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable(value="clientId") Integer id){
        clientService.deleteClient(id);
    }

}
