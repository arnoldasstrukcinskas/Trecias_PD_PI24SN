# Practical Assessment
## Table of Contents
- [About](#about)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Downloading project](#downloading-project)
- [Launching](#launching)
- [Database Testing](#database-testing)
- [Overall Testing](#overall-testing)
## About

The system is designed as an electric vehicle analysis REST API.  
It allows users to search electric vehicles from an external API, generate AI-based analysis, save analysis results into an H2 database, update saved analysis records, delete them and navigate related resources using HATEOAS links.

The project uses RESTful principles, WADL description for SoapUI testing and OpenAPI JSON description generated from the WADL specification.


## Features
- Search electric vehicles from an external API
- Filter electric vehicles by make, model and total power
- Generate AI-based electric vehicle analysis
- Preview generated analysis before saving it
- Save analysis results into H2 database
- Get saved analysis by ID
- Update saved analysis
- Delete saved analysis
- Use HATEOAS links to navigate from analysis to related vehicles, battery and charger data
- Test REST endpoints using Swagger UI
- Test REST endpoints using SoapUI and WADL
- Provide OpenAPI JSON description
## Tech Stack
| Technology | Purpose |
|------------|---------|
| Spring Boot 4.0.6(Maven) | System Framework |
| Java 17 | Programming language |
| Swagger | API documentation + JavaDoc |
| H2 | Database |
| SOAPUI | REST API testing using WADL |
| APIMATIC | WADL to OpenAPI transformation |
| Spring HATEOAS | Hypermedia links in API responses |
| AI service | Electric vehicle analysis generation |

## Installation
To test the project, you need:

1. Java installed
2. Maven or Maven Wrapper
3. SoapUI for WADL testing  
   Download: https://www.soapui.org/downloads/soapui/
4. Ollama installed and running for AI analysis generation(I used llama3.2:3b)  
   Download: https://ollama.com/download


## Downloading project
To launch the project, you first need to download or clone it from the repository.
#### 1. Download
- Go to this repository: https://github.com/arnoldasstrukcinskas/Trecias_PD_PI24SN
- Then press green button Code and and Download Zip.
- Unpack zip file
- Move to [Launching](#launching)
#### 2. Clone(If you have git)
- Open Terminal and go to directory you want to clone project(add your own directory)
  ```bash
  cd D:\example
  ```
- In terminal use this command:
  ```bash
  git clone https://github.com/arnoldasstrukcinskas/Trecias_PD_PI24SN
  ```
- Move to [Launching](#launching)
#### 3. Launch
- For starting project via cmd you have to go to main directory of project „Trecias_PD_PI24SN"
## Launching (Bash)
If you do not have Maven installed into your computer you can launch it via powershell:
#### 1.Build project:
```bash
./mvnw clean package
```
#### 2. Launch project(with logs)
```bash
./mvnw.cmd spring-boot:run
```
#### 3. Stop project
```bash
ctrl + c
```

## Database Testing
(How to connect for testing)
#### 1. Open browser and go to:
```bash
http://localhost:8081/h2-console
```
#### 2. Connect to database
```bash
JDBC URL: jdbc:h2:mem:testdb
User name: sa
--------------------------------
Password: (Leave blank)
```

## Overall Testing
(How to connect for testing)
#### 1. Links for testing via front/back
```bash
  Go to: http://localhost:8081/swagger-ui/index.html
```
##### When you finish working, I suggest turning off Ollama via CMD, as it will not close automatically.
```bash
ollama list (For checking which lama version do you have)
ollama stop llama3.2:3b (enter version which is in the list)
```
#### 3. Last bot not least, Have Fun!!
