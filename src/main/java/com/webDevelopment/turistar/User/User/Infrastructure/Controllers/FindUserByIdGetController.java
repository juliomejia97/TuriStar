package com.webDevelopment.turistar.User.User.Infrastructure.Controllers;

import com.webDevelopment.turistar.Shared.Domain.UUIDNotValid;
import com.webDevelopment.turistar.User.User.Application.Find.UserFinder;
import com.webDevelopment.turistar.User.User.Application.Find.UserFinderResponse;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/users")
public class FindUserByIdGetController
{
    @Autowired
    private UserFinder userFinder;

    @GetMapping(value="find/{userId}")
    public ResponseEntity<HashMap> execute(@PathVariable("userId") String id)
    {
        UserFinderResponse response = new UserFinderResponse(userFinder.execute(id));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
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