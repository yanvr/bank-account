package com.letscode.bankaccount.client;

import com.letscode.bankaccount.dto.client.UserInfo;
import com.letscode.bankaccount.exception.UserNotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CheckUserClient {

    public UserInfo execute(Long id) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        var userInfoResponseEntity = restTemplate.exchange(
                "http://localhost:8081/api/user/client/{id}",
                HttpMethod.GET,
                entity,
                UserInfo.class,
                id.toString()
        );

        if (userInfoResponseEntity.getStatusCode().isError())
            throw new UserNotFoundException("Don't exists user with id " + id);

        return userInfoResponseEntity.getBody();

    }
}
