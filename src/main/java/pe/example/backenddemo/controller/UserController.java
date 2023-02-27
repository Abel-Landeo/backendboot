package pe.example.backenddemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.example.backenddemo.controller.dto.UserRequest;
import pe.example.backenddemo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String hello() {
        return "hello from spring";
    }

    @PostMapping
    public ResponseEntity<String> save (@RequestBody UserRequest userRequest) {
        System.out.println(userRequest);
        userService.save(userRequest);
        return ResponseEntity.ok("Saved");
    }

}
