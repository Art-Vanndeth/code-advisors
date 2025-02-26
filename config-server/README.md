# CodeAdvisors Config Server ⚙️

![CodeAdvisors Logo](http://167.172.78.79:8090/api/v1/files/preview?fileName=b5d01918-2824-48d7-83e0-fb557ce6bd73_2024-12-21T18-28-24.856529397.jpg)

## Handle By ***Thoeng Mengseu***
## **The project is 100% complete**

## Overview 🌐

The **Config Server** is an essential part of the **CodeAdvisors** platform, providing centralized configuration management for microservices. It allows all services to retrieve their configuration properties from a single location, making it easier to manage and modify configurations across the entire platform.

With **Spring Cloud Config**, the Config Server can store configuration files in Git, allowing dynamic updates to the configuration without requiring a service restart.

### Features 🌟

- **Centralized Configuration**: Manage all microservices' configurations from a single location.
- **Git-Based Configuration**: Store configuration properties in Git repositories, making it easy to manage and version.
- **Dynamic Refresh**: Dynamically update configurations without restarting services (if using Spring Cloud Bus).
- **Environment Support**: Provide different configurations based on environments like development, testing, and production.

### Technologies Used ⚙️

- **Spring Boot**: Framework for building microservices and APIs.
- **Spring Cloud Config**: Manages external configurations for microservices.
- **Git**: Stores configuration properties in Git repositories.
- **Java**: Language used for developing the service.

### Config Server Setup 🚀

The Config Server serves as the central place where microservices retrieve their configuration properties. Once the Config Server is up and running, microservices can access configuration files stored in a Git repository.

#### Steps to Run Config Server:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/CodeAdvisor-ISTAD/config-server.git
   cd config-server
   ```

2. **Build the Project**:
   Make sure you have **JDK 21** installed. Then, build the project using Gradle:
   ```bash
   ./gradlew build
   ```

3. **Run the Config Server**:
   Run the Config Server using the following Gradle command:
   ```bash
   ./gradlew bootRun
   ```

4. **Access Config Server**:
   Once the server is running, it can be accessed by other microservices for configuration. The server’s URL is typically:
   ```url
   http://localhost:8888
   ```

   The Config Server will provide configurations stored in the configured Git repository.

### Configuring Microservices to Use Config Server 🛠️

Once the Config Server is up, configure other microservices to retrieve their configurations from it. In the service’s `application.yml` or `bootstrap.yml`, add the following:

```yaml
spring:
  cloud:
    config:
      uri: http://localhost:8888
```

The microservice will now retrieve its configuration properties from the Config Server at the specified URI.

### Git Configuration for the Config Server 🧑‍💻

The Config Server fetches configuration properties from a Git repository. Make sure to configure the repository location in the `application.yml` or `application.properties`:

```yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/your-repo/config-repository
          search-paths: '{application}'
          clone-on-start: true
```

### Configuration Reloading 🔄

You can enable automatic reloading of configurations without restarting services by using Spring Cloud Bus and messaging systems like **Kafka**. When a configuration change is detected, it is broadcasted to all services for a seamless update.

---

## License 📜

This project is licensed under the MIT License - see the LICENSE file for details.

---

**Built with ❤️ by the CodeAdvisors Team**

---
