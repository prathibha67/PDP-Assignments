package Service;

import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl implements DatabaseService {
    @Override
    public void performDatabaseOperation() {
        System.out.println("Database Connected Successfully");
    }
}
