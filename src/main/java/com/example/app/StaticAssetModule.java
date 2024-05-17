package com.example.app;

import com.google.inject.servlet.ServletModule;
import io.dropwizard.servlets.assets.AssetServlet;
import jakarta.inject.Singleton;

import java.nio.charset.StandardCharsets;

/**
 * Mounts dropwizard's AssetServlet so that classpath:/dist will become the web root.
 * Be sure to add this module after the RestModule or it will capture /api calls too.
 */
public class StaticAssetModule extends ServletModule {
	@Singleton
	public static class StaticAssetServlet extends AssetServlet {
		public StaticAssetServlet() {
			super("/dist", "/", "index.html", StandardCharsets.UTF_8);
		}
	}

	@Override
	protected void configureServlets() {
		serve("/*").with(StaticAssetServlet.class);
	}
}
