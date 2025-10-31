# Diagnostic Test Backend

A Spring Boot REST API application that provides Pokémon battle predictions using AI. The backend integrates with the PokeAPI to fetch Pokémon data and uses Google's Gemini AI model to generate battle predictions.

## Features

- 🎮 **Pokémon Data Retrieval**: Fetch Pokémon information from PokeAPI
- 🤖 **AI-Powered Predictions**: Generate battle predictions using Google Gemini AI
- 🌐 **RESTful API**: Clean and simple endpoints for Pokémon data and predictions
- 🔧 **Spring Boot 3.5.7**: Built with the latest Spring Boot features
- 🔗 **CORS Enabled**: Cross-origin requests supported for frontend integration

## Tech Stack

- **Java 25**
- **Spring Boot 3.5.7**
- **LangChain4j 1.3.0-beta9**: For AI service integration
- **Google Gemini AI**: For battle prediction model
- **RestTemplate**: For external API calls to PokeAPI

## Prerequisites

- Java 25 or higher
- Maven 3.6+ 
- Google Gemini API Key

## Configuration

### Environment Variables

Create a `.env` file or set the following environment variable:

```bash
GEMINI_API_KEY=your_gemini_api_key_here
```

### Application Properties

The application is configured in `src/main/resources/application.properties`:

```properties
spring.application.name=diagnostic-test-backend

langchain4j.google-ai-gemini.chat-model.api-key=${GEMINI_API_KEY}
langchain4j.google-ai-gemini.chat-model.model-name=gemini-2.5-flash
langchain4j.google-ai-gemini.chat-model.temperature=0.2
```

## Running the Application

### Using Maven Wrapper

**Windows:**
```bash
.\mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
./mvnw spring-boot:run
```

### Using Maven

```bash
mvn spring-boot:run
```

### Using IDE

Run the `DiagnosticTestBackendApplication.java` main class directly from your IDE.

The application will start on `http://localhost:8080` by default.

## API Endpoints

### Base URL
```
http://localhost:8080/api
```

### Get Pokémon Data
```http
GET /api/pokemon/{id}
```

Fetches Pokémon information by ID from PokeAPI.

**Path Parameters:**
- `id` (Long): Pokémon ID (1-1010+)

**Response:**
```json
{
  "name": "pikachu",
  "types": ["electric"],
  "sprite": "https://..."
}
```

**Example:**
```bash
curl http://localhost:8080/api/pokemon/25
```

### Predict Battle Winner
```http
GET /api/pokemon/predict/{pokemon1}/{pokemon2}
```

Generates an AI-powered prediction of which Pokémon would win in battle.

**Path Parameters:**
- `pokemon1` (String): First Pokémon name
- `pokemon2` (String): Second Pokémon name

**Response:**
```json
{
  "prediction": "Pikachu would likely emerge victorious..."
}
```

**Example:**
```bash
curl http://localhost:8080/api/pokemon/predict/pikachu/charizard
```

## Project Structure

```
src/
├── main/
│   ├── java/com/uce/jp/diagnostic_test_backend/
│   │   ├── config/
│   │   │   └── AppConfig.java          # Bean configuration for RestTemplate
│   │   ├── controller/
│   │   │   └── PokemonController.java  # REST API endpoints
│   │   ├── service/
│   │   │   ├── PokemonService.java     # Business logic and API calls
│   │   │   └── PokemonAiService.java   # AI service interface
│   │   └── DiagnosticTestBackendApplication.java
│   └── resources/
│       └── application.properties      # Application configuration
└── test/
    └── java/...                        # Test classes
```

## Dependencies

- **spring-boot-starter-web**: Web framework for REST APIs
- **spring-boot-devtools**: Development tools for hot reload
- **langchain4j-spring-boot-starter**: LangChain4j integration for AI
- **langchain4j-google-ai-gemini-spring-boot-starter**: Google Gemini AI support
- **spring-boot-starter-test**: Testing framework

## Development

### Building the Project

```bash
mvn clean install
```

### Running Tests

```bash
mvn test
```

### Building JAR

```bash
mvn clean package
```

The JAR file will be generated in `target/diagnostic-test-backend-0.0.1-SNAPSHOT.jar`

### Running JAR

```bash
java -jar target/diagnostic-test-backend-0.0.1-SNAPSHOT.jar
```

## External Services

- **PokeAPI**: https://pokeapi.co/api/v2/pokemon/
  - Used for fetching Pokémon data
  
- **Google Gemini AI**: https://ai.google.dev/
  - Used for generating battle predictions

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is part of a diagnostic test for Web Programming coursework.

## Author

Developed for UCE (Universidad Central del Ecuador)

