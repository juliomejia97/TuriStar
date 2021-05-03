package com.webDevelopment.turistar.User.User.Infrastructure.Controllers;


import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import com.webDevelopment.turistar.User.User.Application.Create.UserCreator;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.*;
import com.webDevelopment.turistar.User.User.Infrastructure.BadWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/users")
public final class CreateUserPostController {

    @Autowired
    private UserCreator creator;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        creator.execute(request.getId(), request.getFirstName(), request.getLastName(), request.getNickName(), request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler({UUIDNotValid.class, UpperLowerError.class, NotSymbolsFound.class, LengthNotValid.class})
    public ResponseEntity<HashMap> hanldleDataErrors(RuntimeException exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadWordsError.class)
    public ResponseEntity<HashMap> hanldleBadWords(BadWordsError exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<HashMap> hanldleUserAlreadyExist(UserAlreadyExists exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}

class Request {
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}