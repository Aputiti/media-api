# Multimedia Management API

This project is a **Multimedia Management API** built with **Java Spring Boot**.

## Overview

The Multimedia Management API enables the organization and retrieval of different types of multimedia content such as films, music, and series. It provides features for managing metadata like title, category (e.g., movie, music), genre, and release year.

## Access the API

Access the API through the following interface to try its functionalities:

## [API Interface](http://media-api-dns.northeurope.azurecontainer.io:8080/swagger-ui/index.html)

## Development Steps

Set up a MongoDB Atlas cluster and configured it to store media items.

### App Structure

These classes were created:

- **Model** to define media item properties.
- **Repository** for database interactions.
- **Service** to handle business logic.
- **Controller** to define API endpoints.

### Additional Functionalities

Enhanced the API with these capabilities:

- **Search Filters**: Query multimedia based on attributes.
- **Sorting**: Order results by fields like release year or title.
- **Pagination**: Retrieve a manageable number of records per request.

### Testing

The API endpoints were tested using **Postman**, ensuring reliable performance and correct outputs.

![Sample Request - Filtering Multimedia](screenshots/sc1.jpeg)  
![Sample Request - Filtering Multimedia](screenshots/sc2.jpeg)  
![Sample Request - Sorting](screenshots/sc3.jpeg)  
![Sample Request - Post](screenshots/sc4.jpeg)

### API Documentation

Integrated **Swagger UI** for interactive API documentation. This interface details the endpoints and their usage.

![Swagger Overview](screenshots/sc5.png)

### Configuration

- Secured database credentials in configuration files.
- Enabled filter, sort, and pagination functionalities within the API.

### Deployment Process

Deployed the application to a cloud environment using containerization (Azure using Docker and Azure Container Instances (ACI)). Steps included:

1. Setting up a resource group and container registry in Azure.
2. Pushing a Docker image to the registry.
3. Deploying the container to Azure container for public access.
