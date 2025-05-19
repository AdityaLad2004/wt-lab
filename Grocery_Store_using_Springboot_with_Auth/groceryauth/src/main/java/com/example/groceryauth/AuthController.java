package main.java.com.example.groceryauth;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    ConsumerRepository consumerRepo;

    @PostMapping("/register")
    public String register(@RequestBody Consumer user) {
        user.setPassword(user.getPassword());
        consumerRepo.save(user);
        return "Registered successfully";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest data) {
        Consumer user = consumerRepo.findByEmail(data.getEmail()).orElse(null);
        if (user != null && user.getPassword().equals(data.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

}
