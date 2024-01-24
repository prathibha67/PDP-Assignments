package Service;

import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService{
    @Override
    public void Message() {
        System.out.println("Logging Service Implementation");
    }
}
