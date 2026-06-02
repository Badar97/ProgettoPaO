# Object-Oriented Programming Project - UNIVPM (2018/2019)

This repository contains a Java application developed as part of the **Object-Oriented Programming** course at Università Politecnica delle Marche (UNIVPM), academic year 2018/2019.  
The project is a Spring Boot REST API for importing, modeling, filtering, and analyzing Italian healthcare open data related to emergency-room access, waiting time, and patient stay indicators.

## Features

- Download and parse a public CSV dataset from a JSON metadata source
- Model healthcare data with object-oriented Java classes
- Expose REST endpoints for data, metadata, filters, and statistics
- Calculate basic statistics such as average, minimum, maximum, sum, count, and standard deviation
- Include UML diagrams for use cases, class structure, and sequence flows

## Technologies

- Java
- Spring Boot
- Maven
- REST APIs
- JSON / CSV parsing
- UML (Use Case, Class, Sequence Diagrams)

## Project Structure
 ```zsh
    ProgettoPaO/
    ├── ProgettoOOP/
    │   ├── src/main/java/    # Java source code
    │   ├── src/main/resources/
    │   └── pom.xml           # Maven configuration
    └── README.md             # Project documentation
```

## Dataset

The dataset used for this project refers to Italian healthcare structures and emergency-room indicators. It is available from:

**[Public Dataset – dati.gov.it](https://www.dati.gov.it/api/3/action/package_show?id=f9198f21-02b8-4479-bccc-eff18564fa8f)**

The CSV file can be downloaded via the URL provided in the JSON response.

## REST Endpoints

- `/data`: returns the parsed dataset
- `/metadata`: returns dataset metadata
- `/stats/{attribute}`: returns statistics for a selected attribute
- `/filter/{filter}`: returns filtered data

## Screenshots & Diagrams

> The following UML diagrams are included to illustrate the structure and behavior of the system:

### Use Case Diagram
Provides an overview of the main interactions between the user and the system.
   ![ProgettoOOP](https://user-images.githubusercontent.com/49913737/59968924-813ab800-9542-11e9-84ac-1b6e89cf17da.png)
   
### Class Diagram
Shows the main classes of the system and their relationships. 
   ![fine](https://user-images.githubusercontent.com/49913737/59964855-bd502780-9506-11e9-8a42-84bfdbd8de08.png)
   
### Sequence Diagrams
Illustrate the order of operations between objects during key interactions.

Part 1:
    ![progetto 1-1](https://user-images.githubusercontent.com/49913737/59969140-661e7700-9547-11e9-93a4-2971668a9553.png)

Part 2:
    ![progetto 1-2](https://user-images.githubusercontent.com/49913737/59969144-69196780-9547-11e9-9487-5dfa0f2c7ab0.png)

## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/Badar97/ProgettoPaO.git
   cd ProgettoPaO/ProgettoOOP
   ```

2. Run the application with Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Open the API in your browser or API client:
   ```text
   http://localhost:8080/data
   ```

> The project was originally developed as an academic Object-Oriented Programming assignment, so some setup details may depend on the original dataset and course environment.

## Authors
- [Ali Waqar Badar](https://github.com/Badar97)  
- Giacomo Pierigè
