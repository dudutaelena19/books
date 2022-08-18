package com.example.main.service;

import com.example.main.model.ClientEntity;
import com.example.main.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientEntity createClient(ClientEntity client){
        return clientRepository.save(client);
    }

    public List<ClientEntity> getClients(){
        return clientRepository.findAll();
    }

    public void deleteClient(Integer clientId){
        clientRepository.deleteById(clientId);
    }

    public ClientEntity updateClient(Integer clientId, ClientEntity clientDetails){
        ClientEntity client=clientRepository.findById(clientId).get();
        client.setName(clientDetails.getName());
        return clientRepository.save(client);
    }
}
