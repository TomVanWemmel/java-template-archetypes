# Java Template Archetypes

A collection of Maven archetypes for creating multi-module Java applications with Web, Service, and Persistence layers. This repository contains:

1. **Spring Template Archetype**: For creating Spring-based applications
2. **Quarkus Template Archetype**: For creating Quarkus-based applications

## Project Structure

The generated project will have the following structure:

```
your-project/
├── your-project-web/
│   ├── src/main/java/
│   └── src/main/resources/
├── your-project-service/
│   ├── src/main/java/
│   └── src/main/resources/
├── your-project-persistence/
│   ├── src/main/java/
│   └── src/main/resources/
├── your-project-app/
│   ├── src/main/java/
│   └── src/main/resources/
├── pom.xml
└── README.md
```

## Installation

To install the archetype locally:

```bash
mvn clean install
```

## Usage

### Spring Template

To generate a project using the Spring template archetype:

```bash
mvn archetype:generate \
  -DarchetypeGroupId=be.simpletom.app \
  -DarchetypeArtifactId=spring-template-archetype \
  -DarchetypeVersion=1.0-SNAPSHOT \
  -DgroupId=com.example \
  -DartifactId=my-spring-project \
  -Dversion=0.1-SNAPSHOT \
  -DinteractiveMode=false
```

### Quarkus Template

To generate a project using the Quarkus template archetype:

```bash
mvn archetype:generate \
  -DarchetypeGroupId=be.simpletom.app \
  -DarchetypeArtifactId=quarkus-template-archetype \
  -DarchetypeVersion=1.0-SNAPSHOT \
  -DgroupId=com.example \
  -DartifactId=my-quarkus-project \
  -Dversion=0.1-SNAPSHOT \
  -DinteractiveMode=false
```

Replace `com.example`, `my-spring-project`/`my-quarkus-project`, and `0.1-SNAPSHOT` with your desired values.

## Features

### Common Features

- Multi-module Maven project structure
- Separation of concerns:
  - App layer (application entry point)
  - Web layer (controllers, DTOs)
  - Service layer (business logic)
  - Persistence layer (repositories, entities)
- Minimal dependencies for maximum flexibility
- Comprehensive .gitignore file
- Detailed README.md with instructions

### Spring Template Features

- Ready for Spring Boot integration
- Structured for Spring's dependency injection

### Quarkus Template Features

- Ready for Quarkus integration
- Structured for Quarkus's fast startup and low memory footprint

## Customization

After generating the project, you can:

1. Add your own controllers, services, and repositories
2. Configure your preferred database in the persistence module
3. Add additional dependencies as needed
4. Customize the application configuration

## License

This project is licensed under the MIT License - see the LICENSE file for details.
