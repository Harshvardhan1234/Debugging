package org.bookerbuddies.bookease.client;

import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.account.AccountRepository;
import org.bookerbuddies.bookease.client.dto.RegisterAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Client newRegistration(RegisterAccount registerAccount) throws ClientException {
        System.out.println(registerAccount);
        Account account = new Account(registerAccount.getAccountId(), registerAccount.getName(), registerAccount.getBalance(), "client");
        account = this.accountRepository.save(account);
        Client client = new Client(registerAccount.getClientId(), registerAccount.getEmail(), registerAccount.getPassword(), registerAccount.getName(), account);
        client = this.clientRepository.save(client);
        account.setClient(client);
        System.out.println("========" + client + "=======" + account);
        accountRepository.save(account);
        return client;
    }

    @Override
    public Client loginPage(String email, String password) throws ClientException {
        Client client = this.clientRepository.findByEmailAndPassword(email, password);
        return client;
    }

    @Override
    public Client getClientbyId(Integer clientId) throws ClientException {
        return this.clientRepository.findById(clientId).get();
    }

    @Override
    public Client updateClient(RegisterAccount updateregisterAccount) throws ClientException {
//        return  this.clientRepository.save(updateregisterAccount);
        return null;
    }


    public Client deleteClientById(Integer clientId) throws ClientException {
        Optional<Client> client = this.clientRepository.findById(clientId);
        this.clientRepository.deleteById(clientId);
        return client.get();
    }

}
