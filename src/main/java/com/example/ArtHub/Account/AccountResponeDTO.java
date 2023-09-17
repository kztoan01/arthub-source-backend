package com.example.ArtHub.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountResponeDTO {
    public static AccountResponeDTO fromAccount(Account account) {
        AccountResponeDTO accountResponseDTO = new AccountResponeDTO();
        accountResponseDTO.setAccountId(account.getAccountId());
        accountResponseDTO.setUsername(account.getUsername());
        return accountResponseDTO;
    }

    public static List<AccountResponeDTO> fromAccountList(List<Account> accountList) {
        List<AccountResponeDTO> accountResponseDTOList = new ArrayList<>();
        for (Account account : accountList) {
            accountResponseDTOList.add(fromAccount(account));
        }
        return accountResponseDTOList;
    }

    private int accountId;
    private String username;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}