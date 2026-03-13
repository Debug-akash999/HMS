package com.example.HMS.controller;

import com.example.HMS.model.Account;
import com.example.HMS.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService ser;

    public AccountController(AccountService ser) {
        this.ser = ser;
    }
    @PostMapping("/save")
    public ResponseEntity<Account> save(@RequestBody Account act){
        Account sve = ser.save(act);
        return ResponseEntity.ok(sve);
    }


    @GetMapping("/get")
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(ser.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable Long id){

        return ResponseEntity.ok(ser.getById(id));
    }

    @PutMapping("/{id}") public ResponseEntity<Account> updateByID(@PathVariable long id,
                                                                   @RequestBody Account act){
        Account d =ser.updateById(id);
        d.setId(act.getId());
        d.setAccountHolderName(act.getAccountHolderName());
        d.setBalance(act.getBalance());
        return ResponseEntity.ok(d);}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        ser.deleteByID(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}