package com.example.HMS.service;

import com.example.HMS.model.Account;
import com.example.HMS.repo.AccountRepo;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    public AccountService(AccountRepo rpo) {
        this.repo = rpo;
    }
    public Account save(Account act){
        return repo.save(act);
    }
    public List<Account> getAll() {
        return repo.findAll();
    }
    public Account updateById(Long id){
        return repo.findById(id).orElse(null);
    }
    public void deleteByID(Long id){
         repo.deleteById(id);
    }

    public Account getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id " + id));
    }
}
