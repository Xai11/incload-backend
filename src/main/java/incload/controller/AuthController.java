package incload.controller;

import incload.model.User;
import incload.security.JwtService;
import incload.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        UserDetails userDetails = (UserDetails) userService.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Проверка пароля
        if (new BCryptPasswordEncoder().matches(user.getPassword(), userDetails.getPassword())) {
            String token = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).build();
    }
}
