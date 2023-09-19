package hk.com.eastech.test.Controllers;

import hk.com.eastech.test.Entity.Users;
import hk.com.eastech.test.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable("id") Long id)  {
        Users users = usersRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/users")
    public Users postUsers(@RequestBody(required = true) Users users){
        return usersRepository.save(users);
    }
}
