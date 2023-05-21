

# Mars Exploration - Map Generator #

### Description ###

_Note: This application was created as a learning project to practice Java development skills and is not intended for actual commercial use._

The Mars Exploration - Map Generator App is a simulation application designed to generate randomized maps of Mars. It serves as a vital component of the Mars exploration simulation, where a rover is placed on the generated maps.

The app's main goal is to create maps with various terrain elements, including mountains, pits, minerals, and pockets of water. These elements are generated with random shapes and placed on the map according to specific rules. The app ensures that resources, such as minerals and water, are strategically placed near their preferred terrain elements.

To facilitate customization, the app employs a configuration object where users can define the desired features of the map, including file name, map width, and parameters for terrain elements and resources, as well as the number of desired maps to be generated. The map generator produces a unique map each time it runs, adhering to the provided configuration.

### Installation ###

1. Clone the repository to your local machine.
2. Open the project in your preferred Integrated Development Environment IDE.
3. Navigate to the folder containing the `pom.xml` file in your project directory.
4. Build the project using the following command to package it into a JAR file:

```mvn package```
5. After the build is successful, navigate to the `\target` folder in your project directory:

```cd target```
6. Run the application using the `java -jar` command followed by the name of the JAR file. 

```java -jar mars-exploration-1-1.0-SNAPSHOT.jar```

7. The application will start executing, and you can interact with it based on the provided functionality.

Please ensure that you have `Maven` and `Java Development Kit (JDK)` installed on your machine and properly configured in your environment variables to execute Maven and Java commands.

_Note:_ Adjust the steps as necessary based on the specific setup and build process of your Java application.


### Usage & Features ###

Follow these instructions to effectively use the Mars Exploration - Map Generator App:

1. Run the application by following the installation instructions mentioned earlier.
2. Once the application starts, you will be prompted to provide various configuration parameters. These parameters are required to generate the randomized maps of Mars according to your specific requirements.
3. Provide the following input parameters in the command prompt, adhering to the specified limitations/constraints:

   * **File Name:** Enter a valid file name without spaces or special characters, using only letters (both uppercase and lowercase), numbers, dots, underscores, and dashes. This name will be used to save the generated maps.
   * **Mountain Areas(`^`):** Specify the number of mountain areas required.
   * **Mountain Areas Sizes:** Enter the number of symbols to be generated for each mountain area.
   * **Pit Areas(`#`):** Specify the number of water areas required.
   * **Pit Areas Sizes:** Enter the number of symbols to be generated for each water area.
   * **Mineral Resources(`*`):** Specify the number of mineral resources to be placed near the mountain areas.
   * **Water Resources(`~`):** Enter the number of water resources to be placed near the pit areas.
   * **Number of Maps:** Specify the number of maps to be generated.

4. Ensure that the width of the map falls between 10 and 100. Also, make sure that the coverage area of resources and shape symbols does not exceed 70% of the map.
5. Once you have provided all the required configuration parameters, the application will generate randomized maps based on your inputs and will save them in the `\resources` folder.
6. Re-run the application if you want to generate differently configured maps.

Feel free to experiment with different configuration parameters to generate various maps for your Mars exploration simulation.

_Note:_ The Mars Exploration - Map Generator App imposes certain limitations and constraints to ensure the validity and realism of the generated maps. If a certain shape cannot be randomly placed on the map after 10,000 tries, the application will reach its limit and provide feedback to the user. You may need to adjust your configuration parameters accordingly to achieve a successful placement. Please follow the instructions and input guidelines accordingly.


### Screenshots ###


#### User Input Configuration Parameters ####

![Configuration](https://i.imgur.com/ylTc7cp.png)

#### Printed Configuration ####

![Printed Configuration](https://i.imgur.com/03rrwC3.png)

#### Generated Map - 1 ####

![Generated Map - 1](https://i.imgur.com/47u6D6i.png)

#### Generated Map - 2 ####

![Generated Map - 2](https://i.imgur.com/DiPosyo.png)

#### Map Coverage Constraint ####

![Map Coverage Constraint](https://i.imgur.com/oJZ3OZZ.png)

#### Map Width Constraint ####

![Map Width Constraint](https://i.imgur.com/JyxhlVC.png)


### Technologies ###

Following technologies were used in developing this app:

1. **Java:** The core programming language used to develop the app, providing robust and efficient functionality.
2. **Maven:** The build automation tool and dependency management system used to streamline the project's build process and handle external libraries and dependencies.
3. **IntelliJ IDEA:** Integrated Development Environments (IDEs) that provide a comprehensive set of tools and features for Java development, including code editing, debugging, and project management.


### License

This project is licensed under the MIT License. See the LICENSE file for details.


### Contact ### 

Feel free to contact me at: [claudium.tudor@gmail.com](claudium.tudor@gmail.com)