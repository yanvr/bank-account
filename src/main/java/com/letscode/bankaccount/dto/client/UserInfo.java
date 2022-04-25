package com.letscode.bankaccount.dto.client;

import com.letscode.bankaccount.enums.client.UserStatus;
import lombok.Data;

@Data
public class UserInfo {

    private Long id;
    private UserStatus userStatus;
}
