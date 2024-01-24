package SFactory;

import Service.AuthenticationService;
import Service.DatabaseService;
import Service.LoggingService;

public interface ServiceFactory {
	DatabaseService createDatabaseService();

	LoggingService createLoggingService();

	AuthenticationService createAuthenticationService();
}
