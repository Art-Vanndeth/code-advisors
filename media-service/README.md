# CodeAdvisors Media Service 🖼️

![CodeAdvisors Logo](http://167.172.78.79:8090/api/v1/files/preview?fileName=b5d01918-2824-48d7-83e0-fb557ce6bd73_2024-12-21T18-28-24.856529397.jpg)

## Handle By ***Thoeng Mengseu***
## **The project is 100% complete**

## Overview 🌐
The **Media Service** is a crucial component of the **CodeAdvisors** platform, designed to handle media file management, including file uploads, retrieval, and deletion. It supports handling multiple file uploads at once and provides a way to preview images, stream content, and manage file storage.

The service interacts with **MinIO** for file storage and uses **PostgresSQL** for persisting metadata.

## Technologies Used ⚙️
- **Spring Boot**: Microservice framework for building RESTful APIs.
- **MinIO**: Object storage service for storing files.
- **PostgreSQL**: Database for storing metadata.
- **JPA**: For handling relational data persistence.
- **Eureka**: Service discovery for seamless microservice interaction.
- **Config**: Centralized configuration management.

## Media Services 🖼️

### File Upload & Management 📂
The Media Service handles file uploads, retrieval, deletion, and preview. Key features include:

- **Upload Files**: Upload single or multiple files to the server.
- **Get All Files**: Retrieve all uploaded files.
- **Get File by Name**: Get specific files by name.
- **Preview Files**: Preview image files directly in the browser.
- **Delete Files**: Delete files from storage.

#### Endpoints 🚀

- **POST /api/v1/files/upload**: Upload a single file.
- **POST /api/v1/files/upload-multiple**: Upload multiple files.
- **GET /api/v1/files/all**: Retrieve all files.
- **GET /api/v1/files/{fileName}**: Retrieve a specific file by name.
- **GET /api/v1/files/preview**: Preview a file (mainly images).
- **DELETE /api/v1/files/delete**: Delete a specific file.

## Setup and Installation 🛠️

### Prerequisites 📦
Before running the services, ensure the following are installed and configured:
- **JDK 21** (for building and running the application)
- **PostgreSQL** (for metadata storage)
- **MinIO** (for file storage)
- **Kafka** (if used for inter-service communication)

### Steps to Run 🚶‍♂️

1. Clone the repository:
   ```bash
   git clone https://github.com/CodeAdvisor-ISTAD/media-service.git
   cd media-service
   ```

2. Build the project using Gradle:
   ```bash
   ./gradlew build
   ```

3. Run the services:
   ```bash
   ./gradlew bootRun
   ```

4. Ensure MinIO and PostgreSQL (or equivalent configurations) are running before starting the services.

## License 📜
This project is licensed under the MIT License - see the LICENSE file for details.

---
Built with ❤️ by the CodeAdvisors Team

---

