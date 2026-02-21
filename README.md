### Organization

#### controller: 
- Intercepts API requests. 
- Deserializes request body to *request_dto* with validations checks.
- Passes the valid *request_dto* to the service layer for processing.

#### request_dto:
- Data Request record used to receive deserialized client data.
- Defines validation constraints which can throw MethodArgumentNotValidException.

#### response_dto:
- Data Response record stores mapped entity fields.
- This record would be serialized and returned to client.
- It is filtered by the mapper to contain specific *entity* fields.

#### error_dto:
- Error Response record stores the error message from exceptions.
- This record would be serialized and returned to client.

#### mapper:
- Maps specific *entity* fields into the *response_dto*
- This ensures clients only sees what server wants them to see.

#### entity:
- Defines an entity, its integrity constraints and relationships.

#### persistence_service:
- Derives required *entity* fields from the *request_dto*.
- Talks directly to the persistence layer on behalf of the controller.

#### persistence_repository:
- Implements the persistence layer using JPA, HQL, SQL.

#### exception:
- Handles exceptions from validations and requests.
- Sets error_dto's error message.

##
### Build
#### powershell:
    .\mvnw clean package -DskipTests && docker compose up --build
#### bash:
    ./mvnw.cmd clean package -DskipTests && docker compose up --build