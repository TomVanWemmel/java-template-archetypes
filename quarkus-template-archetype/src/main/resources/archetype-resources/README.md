# ${artifactId}

A multi-module Java application generated from the Quarkus Template Archetype.

## Project Structure

This project is organized into four modules:

1. **${artifactId}-web**: Contains the web layer (controllers, DTOs, etc.)
2. **${artifactId}-service**: Contains the business logic
3. **${artifactId}-persistence**: Contains the data access layer (repositories, entities, etc.)
4. **${artifactId}-app**: Contains the main application class and serves as the entry point

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

### Building the Application

```bash
mvn clean install
```

### Running the Application

This is a minimal archetype without specific implementation dependencies. To run the application:

1. Add your preferred dependencies to each module's pom.xml file
2. Configure your application based on the dependencies you've added
3. Run the application using your preferred method

For example, with Quarkus:

```bash
cd ${artifactId}-app
mvn quarkus:dev
```

Or if you prefer to build and run the application:

```bash
cd ${artifactId}-app
mvn package
java -jar target/${artifactId}-app-runner.jar
```

## Module Dependencies

The modules have the following dependencies:

- **${artifactId}-app** depends on **${artifactId}-web**, **${artifactId}-service**, and **${artifactId}-persistence**
- **${artifactId}-web** depends on **${artifactId}-service**
- **${artifactId}-service** depends on **${artifactId}-persistence**
- **${artifactId}-persistence** is independent

## Configuration

Each module has its own configuration files:

- **${artifactId}-app**: `application.properties` (main application configuration)
- **${artifactId}-web**: `application.properties` (web-specific configuration)
- **${artifactId}-persistence**: `application-persistence.properties` (persistence-specific configuration)

## Database

This archetype doesn't include any specific database dependencies. To add database support:

1. Add your preferred database dependencies to the `${artifactId}-persistence` module's pom.xml
2. Configure your database connection in `${artifactId}-persistence/src/main/resources/application-persistence.properties`
3. Implement your data access layer using your preferred approach (JPA, JDBC, etc.)

Examples of databases you might want to use:
- H2 (in-memory or file-based)
- PostgreSQL
- MySQL
- MongoDB
- etc.

## Adding Features

- Add application initialization and startup logic to the **${artifactId}-app** module
- Add controllers to the **${artifactId}-web** module
- Add services to the **${artifactId}-service** module
- Add repositories and entities to the **${artifactId}-persistence** module
