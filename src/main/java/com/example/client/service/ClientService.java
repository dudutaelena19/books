package com.example.client.service;

import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void deleteClient(long clientId){
        clientRepository.deleteById(clientId);
    }

    public Client updateClient(Long clientId, Client clientDetails){
        Client client=clientRepository.findById(clientId).get();
        client.setName(clientDetails.getName());
        return clientRepository.save(client);
    }
}
