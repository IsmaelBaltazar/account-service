package com.nttdata.account.api;

import com.nttdata.account.model.document.Account;
import com.nttdata.account.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Mono<Account> register(@RequestBody Account account){
        return accountService.save(account);
    }
    @GetMapping("")
    public Flux<Account> getAll(){
        return accountService.getAll();
    }
    @GetMapping("/{idAccount}")
    public Mono<Account> getOne(@PathVariable Long idAccount){
        return accountService.findById(idAccount);
    }
    @PutMapping
    public Mono<Account> update(@RequestBody Account account){
        return  accountService.update(account);
    }
    @GetMapping("/getAccountsCustomer/{idCustomer}")
    public Flux<Account> accountsByCustomer(@PathVariable long idCustomer){
        return accountService.findByIdCustomer(idCustomer);
    }
}
