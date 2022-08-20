package kz.com.factoring.Controller;

import kz.com.factoring.Entity.User;
import kz.com.factoring.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.allUsers());
    }

    @RequestMapping(value = "/register/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @RequestMapping(value = "/register/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody User user) {


        return ResponseEntity.ok(userService.saveUser(user));
    }
    @CrossOrigin
    @RequestMapping(value = "/signIn", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> signin(@RequestParam(required=false,name="username")  String username,@RequestParam(required=false,name="password")  String password) {
        try {

            return ResponseEntity.ok(userService.signIn(username,password));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}

