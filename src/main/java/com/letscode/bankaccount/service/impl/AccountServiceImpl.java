package com.letscode.bankaccount.service.impl;

import com.letscode.bankaccount.client.CheckUserClient;
import com.letscode.bankaccount.dto.AccountRequest;
import com.letscode.bankaccount.dto.AccountResponse;
import com.letscode.bankaccount.dto.client.UserInfo;
import com.letscode.bankaccount.enums.client.UserStatus;
import com.letscode.bankaccount.exception.AccountNotFoundException;
import com.letscode.bankaccount.exception.UserNotFoundException;
import com.letscode.bankaccount.model.Account;
import com.letscode.bankaccount.repository.AccountRepository;
import com.letscode.bankaccount.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final CheckUserClient checkUserClient;
    private final AccountRepository accountRepository;

    @Override
    public AccountResponse create(AccountRequest accountRequest, Long id) {
        UserInfo userInfo = checkUserClient.execute(id);

        if (userInfo.getUserStatus().equals(UserStatus.CREATED)) {
            Account account = new Account(accountRequest);
            account.setUserId(id);
            Account createdAccount = accountRepository.save(account);
            return new AccountResponse(createdAccount);
        }
        throw new UserNotFoundException("Don't exists user with id " + id);
    }

    @Override
    public AccountResponse findById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Not found account with id: " + id));

        return new AccountResponse(account);
    }
}
