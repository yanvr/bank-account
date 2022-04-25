package com.letscode.bankaccount.controller;

import com.letscode.bankaccount.dto.AccountRequest;
import com.letscode.bankaccount.dto.AccountResponse;
import com.letscode.bankaccount.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public AccountResponse create(@RequestBody AccountRequest accountRequest, @PathVariable Long id) {
        return accountService.create(accountRequest, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable Long id) {
        return accountService.findById(id);
    }
}
