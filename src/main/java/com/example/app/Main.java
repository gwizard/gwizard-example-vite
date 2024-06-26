package com.example.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.gwizard.config.ConfigModule;
import org.gwizard.logging.LoggingModule;
import org.gwizard.rest.RestModule;
import org.gwizard.services.Run;

import java.io.File;

/**
 * Set up the injector and start all services
 */
public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			args = new String[] {"test.yml"};
		}

		final Injector injector = Guice.createInjector(
				new ExampleModule(),
				new ConfigModule(new File(args[0]), ExampleConfig.class),
				new LoggingModule(),
				new RestModule("/api"),
				new StaticAssetModule()	// Must be after the RestModule because it catches /*
		);

		injector.getInstance(Run.class).start();
	}
}
