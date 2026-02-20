### Organization

#### controller: 
- Intercepts api request. 
- Deserializes to *request_dto* with validation enabled.

#### request_dto:
- Java Object equivalent of the http request's JSON data.
- Validates user input, throws exception on failed validations.

#### error_dto:
- Response body for an error state.

#### response_dto:
- Filters only permitted entity fields via mapper.

#### mapper:
- Maps entity fields to *response_dto*

#### persistence_service:
- Converts the *request_dto* to persistence level request fields.
- This data could be full/partial entity depending on the HTTPRequest type.
- Talks directly to the persistence layer on behalf of the controller.

#### persistence_repository:
- Implements the low level CRUD using JPA

#### domain:
- Contains entities and their constraints and relationships

#### exception:
- Provides error_dto's data

##
### Build
#### powershell:
    .\mvnw clean package -DskipTests && docker compose up --build
#### bash:
    ./mvnw.cmd clean package -DskipTests && docker compose up --build