package com.example.client.controller;

import com.example.client.model.Client;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/test")
    public String test(){
        return "Merge";
    }

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @RequestMapping(value="/clients",method =RequestMethod.GET)
    public List<Client> readClients(){
        return clientService.getClients();
    }

    @RequestMapping(value="/clients/{clientId}",method = RequestMethod.PUT)
    public Client updateClient(@PathVariable(value="clientId") Long id, @RequestBody Client clientDetails){
        return clientService.updateClient(id,clientDetails);
    }

    @RequestMapping(value="/clients/{clientId",method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable(value="clientId") Long id){
        clientService.deleteClient(id);
    }

}
