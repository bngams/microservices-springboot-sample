package fr.hiit.javatraining.microservicesexample.auth.controllers.api;

import fr.hiit.javatraining.microservicesexample.auth.conf.jwt.JWTUtils;
import fr.hiit.javatraining.microservicesexample.auth.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class JWTAuthController {

    @Autowired
    private JWTUtils jwtTokenUtil;

    @PostMapping
    public ResponseEntity<String> createAuthenticationToken(@RequestBody AppUser partialUser) throws Exception {
        if(authenticate(partialUser.getUsername(), partialUser.getPassword())) {
            return ResponseEntity.ok(jwtTokenUtil.generateToken(partialUser.getUsername()));
        }
        else
            return ResponseEntity.status(401).body("Unknown user");
    }

    /**
     * Fake authenticate process
     * @param username
     * @param password
     * @return
     */
    private boolean authenticate(String username, String password) {
        // hard coding the users. All passwords must be encoded.
        // we can use a database where we can query the users instead
        final List<AppUser> appUsers = Arrays.asList(
                new AppUser(1, "admin", "admin", "ADMIN"),
                new AppUser(2, "user", "user", "USER")
        );

        // simulate auth and
        for (AppUser appUser : appUsers) {
            if (appUser.getUsername().equals(username)
                    && appUser.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
