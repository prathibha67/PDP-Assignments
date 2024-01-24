package Service;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    void authenticate(String Username, String Password);
}
