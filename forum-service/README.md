# CodeAdvisors Forum Service 📚

![CodeAdvisors Logo](http://167.172.78.79:8090/api/v1/files/preview?fileName=b5d01918-2824-48d7-83e0-fb557ce6bd73_2024-12-21T18-28-24.856529397.jpg)

## Overview 🌐
The **Forum Service** is a core component of the **CodeAdvisors** platform, designed to manage educational content and related tags. This service allows administrators and users to create, update, search, and manage content efficiently. Additionally, it integrates with the **Tag Service** to categorize and manage content using tags, helping to organize and filter content more effectively.

## Technologies Used ⚙️
- **Spring Boot**: Microservice framework for creating RESTful APIs.
- **MongoDB**: Database for storing content and tags.
- **Kafka**: For asynchronous communication (if integrated with other services).
- **JPA**: For handling relational data persistence.
- **Eureka**: Service discovery for seamless microservice interaction.
- **Config**: Centralized configuration management.

## forum Services 📝

### forum Management 📄
The Content Service handles the creation, retrieval, update, deletion, and search of content items. Key features include:

- **Create question**: create new question.
- **Publish question**: publish question that has been created.
- **archive question**: archive question that has been published.
- **unarchive question**: unarchive question that has been published.
- **Soft Delete question**: Soft delete question without removing it from the system.
- **find all question with Pagination**: Support for paginated question listings.
- **find all archive question with Pagination**: Support for paginated archive question listings.
- **find a question**: find a question .


#### Endpoints 🚀

- **POST /api/v1/questions**: Create new question.
- **POST /api/v1/questions/publish?questionUuid&userUuid**: publish question by question uuid and user uuid.
- **DELETE /api/v1/questions/{questionUuid}/soft-delete**: Soft delete content by ID.
- **GET /api/v1/questions?page={page}&size={size}**: Retrieve all question with pagination.
- **GET /api/v1/questions/archive?page={page}&size={size}**: Retrieve all archive question with pagination.
- **POST /api/v1/questions/{questionUuid}/archive**: Archive question by uuid
- **POST /api/v1/questions/{questionUuid}/unarchive**: unArchive question by uuid
- **GET /api/v1/questions/{questionUuid}: find question by Uuid


## Setup and Installation 🛠

### Prerequisites 📦
Before running the services, ensure the following are installed and configured:
- **JDK 21** (for building and running the application)
- **Postgres** (for content and tag storage)

### Steps to Run 🚶‍♂️

1. Clone the repository:
   ```bash
   git clone https://github.com/CodeAdvisor-ISTAD/forum-service.git
   cd forum-service
   ```

2. Build the project using Gradle:
   ```bash
   ./gradlew build
   ```

3. Run the services:
   ```bash
   ./gradlew bootRun
   ```

4. Ensure Postgres (if applicable) are running before starting the services.

## License 📜
This project is licensed under the MIT License - see the LICENSE file for details.

---
Built with ❤️ by the CodeAdvisors Team