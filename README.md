# COMP2042_CW_hcyab2

Name: Abhinav George Basil

Student ID: 20205163

OWA: hcyab2

## Running the Game:
- This implementation of Frogger has been tested on 2 Windows devices on IntelliJ IDEA
  

- To run the game open up the project on IntelliJ IDEA
- Download the JavaFX library and place it on a folder
- Add the JavaFX library to Global Libraries (File -> Project Structure -> Global Libraries)
- Click the '+' button, select Java and direct to the lib folder of the JavFX library
- Add to FroggerTrial module and click apply
- Add the VM Arguments to Main by editing configurations: "--module-path **(JavaFX Library Path)** --add-modules=ALL-MODULE-PATH"
  

- Alternatively, import the project as a maven project and select javafx:run on the maven tab on the right side of in IntelliJ

## Key Changes Made for Maintenance and Extension

- Configured the file for Github to regularly push updated code to the respective repository for easier maintenance
  - Used .gitignore file to avoid clutter in the repository  
  - On request, users can be added as a collaborator to view the repository
- Added JavaDocs for easier understanding
- The classes have been repackaged to make it easier to understand
- Broke up classes into separate classes to give each class unique functionality and follow the single responsibility principle
    - Created the Game class which focuses on initializing the game itself from the Main class
    - Created the AddObjects class which focuses on adding objects to the game from the Main class
    - Created the FrogController class which focuses on the controls involved in moving the frog and placed it in the controller package
- Renamed classes for easier understanding
  - Changed the Animal class to Frog
  - Changed the Obstacle class to Vehicles
- Added new classes to provide new functionality
    - The Highscore class helps with the functionality of the newly added high score menu
    - The Mute class helps add the option to mute the game with the click of a button
    - The Pause class helps pause the game by adding a pause button to the game itself
    - The stop class helps stop the game by adding a stop button to the game itself
    - The RoundScore class helps gather the scores for each round to be shown in the round score menu
    - The Skeleton, Dragon and Minotaur class to add new characters to the game
    - The PowerUp class to add a power up orb to the game
    - The RoundScore class was made to help with the functionality of the newly created round score pop-up menu
    - The lives class shows the number of lives left for the frog in the game itself
    - The ActorFactory class is used to configure the factory design pattern for the AddObjects class
- Converted many blocks of code into their own methods to improve readability
- Improved encapsulation of data by making the majority of the data-types private while using required getters and setters to protect data
- Added a new background and adjusted it to make the game look nicer
- Created a fully functioning start menu, info menu, high score menu and high score (round score) pop-up using FXML, CSS and Scenebuilder
- The factory design pattern has been utilized to add actors to the AddObjects class to enhance maintainability by introducing the ActorFactory class
- The code has been organized to adhere to the MVC Pattern making the project cleaner and easier to understand
- Added a permanent high score list which stores data to Highscore.csv to be used in the High score menu created with FXML and Scenebuilder
- 10 levels with different characters, speed and arrangements have been created to make the game more interesting
- The music has been changed to add a little more **_funk_**
- Utilized JUnit 5 to test the functionality of different areas of the program
- Utilized Maven to handle dependencies
- Used IntelliJ to create a class diagram
- All resources used in this project are free to use for non-commercial applications


- Main Menu:

![Main Menu](img_3.png)


- Level 10 of the Game:

![Level 10](img_2.png)
  

- Class Diagram:

![img.png](img.png)


- Github:

![img_1.png](img_1.png)
![img_4.png](img_4.png)
![img_5.png](img_5.png)
![img_6.png](img_6.png)
![img_7.png](img_7.png)
![img_8.png](img_8.png)