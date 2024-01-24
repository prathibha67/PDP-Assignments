package Service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public void authenticate(String username, String password) {
        System.out.println("user with "+username+" logged in successfully.");
    }
}
