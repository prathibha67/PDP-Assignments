package SFactory;

import Service.*;

public class ServiceFactoryImpl implements ServiceFactory {
	@Override
	public DatabaseService createDatabaseService() {
		return new DatabaseServiceImpl();
	}

	@Override
	public LoggingService createLoggingService() {
		return new LoggingServiceImpl();
	}

	@Override
	public AuthenticationService createAuthenticationService() {
		return new AuthenticationServiceImpl();
	}
}
