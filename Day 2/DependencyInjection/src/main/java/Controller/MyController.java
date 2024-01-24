package Controller;

import Service.AuthenticationService;
import Service.DatabaseService;
import Service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import SFactory.ServiceFactory;

@RestController
public class MyController {
    private final DatabaseService databaseService;
    private final LoggingService loggingService;
    private final AuthenticationService authenticationService;

    @Autowired
    public MyController(ServiceFactory serviceFactory) {
        this.databaseService = serviceFactory.createDatabaseService();
        this.loggingService = serviceFactory.createLoggingService();
        this.authenticationService = serviceFactory.createAuthenticationService();
    }

    public void performControllerAction() {
        databaseService.performDatabaseOperation();
        loggingService.Message();
        authenticationService.authenticate("Prathibha", "Prathi@67");
    }
}
