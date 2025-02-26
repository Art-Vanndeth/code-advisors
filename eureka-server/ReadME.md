# CodeAdvisors Eureka Server 🌍

![CodeAdvisors Logo](http://167.172.78.79:8090/api/v1/files/preview?fileName=b5d01918-2824-48d7-83e0-fb557ce6bd73_2024-12-21T18-28-24.856529397.jpg)

## Handle By ***Thoeng Mengseu***
## **The project is 100% complete**

## Overview 🌐

The **Eureka Server** is a central component of the **CodeAdvisors** platform, providing service discovery for microservices. It enables microservices to register themselves and discover other services dynamically. This eliminates the need for hardcoded URLs and facilitates seamless communication between services.

### Features 🌟

- **Service Registration**: Microservices automatically register with the Eureka Server.
- **Service Discovery**: Other services can discover registered services dynamically.
- **Client-Side Load Balancing**: Services can be accessed by their logical names with load balancing, using **Netflix Ribbon**.
- **Health Monitoring**: Eureka monitors the health of services and removes unhealthy services from the registry.

### Technologies Used ⚙️

- **Spring Boot**: Framework for building microservices and APIs.
- **Spring Cloud Netflix Eureka**: Implements the Eureka service registry.
- **Java**: Language used for developing the service.
- **Netflix Ribbon**: Client-side load balancing.

### Eureka Server Setup 🚀

The Eureka Server allows other microservices to register and discover each other dynamically. Once the Eureka Server is up and running, other services can register themselves with it.

#### Steps to Run Eureka Server:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/CodeAdvisor-ISTAD/eureka-server.git
   cd eureka-server
   ```

2. **Build the Project**:
   Make sure you have **JDK 21** installed. Then, build the project using Gradle:
   ```bash
   ./gradlew build
   ```

3. **Run the Eureka Server**:
   Run the Eureka Server using the following Gradle command:
   ```bash
   ./gradlew bootRun
   ```

4. **Access Eureka Dashboard**:
   Once the server is running, you can access the Eureka dashboard in your browser:
   ```url
   http://localhost:8761
   ```
   The dashboard displays all registered services and their status.

### Configuring Services to Use Eureka 🛠️

Once the Eureka Server is up, other microservices can register themselves by adding the Eureka client configuration:

```yaml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

The services will automatically register with the Eureka Server when they are started.

---

## License 📜

This project is licensed under the MIT License - see the LICENSE file for details.

---

**Built with ❤️ by the CodeAdvisors Team**

---
