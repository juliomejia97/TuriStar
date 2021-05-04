package com.webDevelopment.turistar.User.User.Infrastructure.Controllers;

import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import com.webDevelopment.turistar.User.User.Application.Update.UserModifier;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/users")
public class UpdateUserPutController {

    @Autowired
    private UserModifier userModifier;

    @PutMapping(value = "/{userId}")
    public ResponseEntity<String> execute(@PathVariable String userId, @RequestBody Request request)
    {
        userModifier.execute(userId, request.getFirstName(), request.getLastName(), request.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body("User " + request.getId() + "has been modified");
    }


    @ExceptionHandler(UserNotExist.class)
    public ResponseEntity<HashMap> handleUserNotExist(UserNotExist exception)
    {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UUIDNotValid.class)
    public ResponseEntity<HashMap> handleUUIDNotValid(UUIDNotValid exception)
    {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }



}
