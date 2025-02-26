# Content Discovery Service

Welcome to the **Content Discovery Service**! This Spring-powered application leverages Elasticsearch for a blazing-fast, scalable, and flexible content retrieval experience.

## 🚀 Features

### 🌟 Trending Posts
- **What it does**: Retrieves posts based on the number of views.
- **Why it matters**: Keeps users updated on what's hot and popular.

### ✨ Featured Articles
- **What it does**: Highlights articles marked with a `featured` flag.
- **Why it matters**: Showcases the best content to attract user attention.

### 🏷️ Tag-based Navigation
- **What it does**: Fetches content by specific tags.
- **Why it matters**: Allows users to explore topics they're passionate about.

### 🆕 Latest Posts
- **What it does**: Retrieves posts based on their creation date.
- **Why it matters**: Ensures users can access the freshest content.

### 🤝 Recommended Posts
- **What it does**: Uses tags to suggest posts tailored to user interests.
- **Why it matters**: Enhances user engagement with personalized content.

## 🛠️ Tech Stack
- **Spring Boot**: For building a robust and scalable backend.
- **Elasticsearch**: For storing and querying all the content data.
- **Java**: The primary programming language.

## 📂 Project Structure
```
content-discovery/
├── src/main/java/
│   ├── com.example.contentdiscovery/  # Core logic
│   ├── controller/                    # REST controllers
│   ├── service/                       # Business services
│   ├── repository/                    # Elasticsearch interactions
│   └── model/                         # Data models
├── src/main/resources/
│   ├── application.yml                # Configurations for Elasticsearch and Spring Boot
│   └── static/                        # Static assets (if any)
└── README.md                          # Project documentation
```

## ⚙️ Setup and Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/CodeAdvisor-ISTAD/content-discovery.git
   cd content-discovery
   ``

2. **Set up Elasticsearch**
    - Install Elasticsearch using Docker:
      ```bash
      docker pull elasticsearch:latest
      docker run -d -p 9200:9200 -e "discovery.type=single-node" elasticsearch:latest
      ```

3. **Configure the application**
    - Update `application.yml` with your Elasticsearch connection details.


4. **Access the API**
    - Base URL: `http://localhost:8082`

## 📄 API Endpoints

### 1. **Get Trending Posts**
- **GET** `/api/content/trending`
- **Description**: Retrieves posts sorted by views.

### 2. **Get Featured Articles**
- **GET** `/api/content/featured`
- **Description**: Fetches posts marked as featured.

### 3. **Get Posts by Tag**
- **GET** `/api/content/tags/{tag}`
- **Description**: Retrieves posts matching the given tag.

### 4. **Get Latest Posts**
- **GET** `/api/content/latest`
- **Description**: Retrieves posts by creation date.

### 5. **Get Recommended Posts**
- **GET** `/api/content/recommended?tags=tag1,tag2`
- **Description**: Fetches personalized recommendations based on user tags.

## 🛡️ Security
- Use Spring Security (optional) to protect endpoints if needed.
- Implement API rate limiting to prevent abuse.


## 🤝 Contribution
We welcome contributions! Please follow these steps:
1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Open a pull request.

## 📝 License
This project is licensed under the MIT License.

## 💬 Contact
For any questions, reach out at:
- **Email**: chansamangrathana@gmail.com
- **GitHub**: [chansamangrathana](https://github.com/chansamangrathana)

---
### 🔥 Start discovering content today with the Content Discovery Service! 🔥

