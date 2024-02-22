package org.bookerbuddies.bookease.client.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.account.Account;

@AllArgsConstructor
@NoArgsConstructor
//@Data
@Builder
public class RegisterAccount {
    private Integer accountId;
    private String name;
    private Double balance;

    private Integer clientId;
    private String email;
    private String password;

    public RegisterAccount(Integer accountId, String name, Double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public RegisterAccount( Integer clientId, String email, String password,String name,Account account) {
        this.name = name;
        this.balance = balance;
        this.clientId = clientId;
        this.email = email;
        this.password = password;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterAccount{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", clientId=" + clientId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
