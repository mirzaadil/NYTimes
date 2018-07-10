# The New York Times

# Libraries Used

- Retrofit - For the network calls.
- RxJava - For making Async Retrofit calls at the same time their responses.
- Frescolib  - Fresco is a powerful system for displaying images in Android applications..
- Unit Testing.

# Project Structure

- mirzaadil.nytimes.view.activities -Contains all the activities.
- mirzaadil.nytimes.view.adapters -Contains all the adapter. In this project only the Recycler Adapters.
- mirzaadil.nytimes.model - Contains the model classes of the entities in the project.
- mirzaadil.nytimes.controllers.network - Contains everything about network implementation.
- mirzaadil.nytimes.controllers.utils - Contains all helpers supporting code.

# Model View Controller (MVC)

MVC design pattern divides an application into three major aspects: Model, View, and Controller.

# Model

Model means data that is required to display in the view. Model represents a collection of classes that describes the business logic (business model and the data model). It also defines the business rules for data means as how the data can be changed and manipulated.

# View

The View represents UI components like XML, HTML etc. View displays the data that is received from the controller as the outcome. In MVC pattern View monitors the model for any state change and displays updated model. Model and View interact with each other using the Observer pattern.

# Controller

The Controller is responsible to process incoming requests. It processes the user’s data through the Model and passing back the results to View. It normally acts as a mediator between the View and the Model.

# Authors
- Mirza Adil
