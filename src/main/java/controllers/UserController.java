package controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login() {
        //TODO: ResponseEntity<Token> // Hacer lógica del login
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        /* try {
            if(this.userService.authentication(user.getUsername(), user.getPassword())) {
                String tokenJWT = this.userService.getToken(user.getUsername());
                token = new Token(tokenJWT);
                codigo = HttpStatus.OK;
            }
            else {
                codigo = HttpStatus.UNAUTHORIZED;
            }
        }
        catch (Exception e) {
            LOGGER.error("UserController.login Cause: " + e.getMessage());
        }*/
        return ResponseEntity.status(codigo).body(" ");
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser() {
        //TODO: Lógica de register user
        //TODO: Crear entidad user
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        /*try {
            user = this.userService.addUser(user);
            codigo = (user != null) ? HttpStatus.OK : HttpStatus.CONFLICT;
        }
        catch (Exception e) {
            LOGGER.error("UserController.addUser Cause: " + e.getMessage());
        }*/
        return ResponseEntity.status(codigo).body(null);
    }

    //TODO: Logout (?)
    @PostMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> logoutUser(){
        //TODO: Lógica de salir del sistema
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        return ResponseEntity.status(codigo).body(null);
    }
}
