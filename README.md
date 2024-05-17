# GWizard Example (Vite)

This GWizard example demonstrates how to serve static content, built with Vite. It uses DropWizard's
AssetServlet to serve static content. In this case, the `src/main/frontend` directory is a
freshly-created vite project.

 * `/api` is served by jaxrs rest resources in your app
 * `/*` (everything else) is served the static content

## Running in Development

```
$ cd src/main/frontend
$ npm run dev
```

This opens up the frontend development server on http://localhost:9001/. Vite will hot-reload
your javascript as you build it.

The `vite.config.ts` has been modified to add a proxy for `/api` so that your javascript running
from the development server can talk to your real application (just like production).

## Running in Production

This builds a self-contained executable jar which includes the vite-built static content
as well as the API.

```
$ mvn package
$ java -jar target/gwizard-example-vite-1.0-SNAPSHOT.jar test.yml
```

Visit http://localhost:8081

## GWizard

For more information about GWizard:
https://github.com/gwizard/gwizard
