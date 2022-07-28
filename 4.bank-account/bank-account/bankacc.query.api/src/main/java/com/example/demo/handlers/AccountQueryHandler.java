package com.example.demo.handlers;

import com.example.demo.dto.AccountLookupResponse;
import com.example.demo.queries.FindAccountByHolderIdQuery;
import com.example.demo.queries.FindAccountByIdQuery;
import com.example.demo.queries.FindAccountsWithBalanceQuery;
import com.example.demo.queries.FindAllAccountsQuery;

public interface AccountQueryHandler {
    AccountLookupResponse findAccountById(FindAccountByIdQuery query);
    AccountLookupResponse findAccountByHolderId(FindAccountByHolderIdQuery query);
    AccountLookupResponse findAllAccounts(FindAllAccountsQuery query);
    AccountLookupResponse findAccountsWithBalance(FindAccountsWithBalanceQuery query);
}
