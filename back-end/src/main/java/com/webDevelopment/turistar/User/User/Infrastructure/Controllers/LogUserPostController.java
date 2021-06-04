package com.webDevelopment.turistar.User.User.Infrastructure.Controllers;

import com.webDevelopment.turistar.User.User.Application.Login.UserLogger;
import com.webDevelopment.turistar.User.User.Domain.Exceptions.UserNotExist;
import com.webDevelopment.turistar.User.User.Domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/users")
public class LogUserPostController {
    @Autowired
    private UserLogger userLogger;
    @PostMapping(value ="/login")

    public ResponseEntity execute(@RequestBody Request request)
    {
        Token token = null;
        HttpStatus code = HttpStatus.FORBIDDEN;
        System.out.println("e: " + request.getEmail() + "  p: " + request.getPassword());
        try
        {
            if(userLogger.execute(request.getEmail(),request.getPassword()))
            {
                String tokenJWT = this.userLogger.getToken(request.getEmail());
                token = new Token(tokenJWT);
                code = HttpStatus.OK;

            }
            else
            {
                code = HttpStatus.UNAUTHORIZED;
            }

        }catch( Exception e )
        {

        }

        return ResponseEntity.status(code).body(token);
    }
    @ExceptionHandler(UserNotExist.class)
    public ResponseEntity<HashMap> handleUserNotExist(UserNotExist exception)
    {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
