# Chat Application
  ## Overview
  
* This chat application is a console-based program with a graphical user interface (GUI) developed using Java Swing.
* It uses Java socket programming for client-server communication and Java multithreading to handle multiple clients and events concurrently.
  
![chatAppScreen](https://github.com/user-attachments/assets/513c4719-276a-4dd0-a693-1a037c3fccd3)

## Features
* Graphical User Interface: User-friendly interface developed with Java Swing.
* Client-Server Communication: Utilizes Java socket programming for real-time chat between clients.
* Multiple Clients: Supports multiple clients connecting to the server simultaneously.
* Java Multithreading: To handle multiple clients and events concurrently.
* enabled to make chat from multiple computers
## Technologies Used
* Java: Programming language used for development.
* Java Swing: GUI toolkit for the graphical interface.
* Java Sockets: For client-server communication.
* Java Multithreading: To handle multiple clients and events concurrently.

##  Getting Started
 ### Prerequisites
* Java Development Kit (JDK): Version 8 or higher.
* IDE: Any Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse).

## Installation
### Clone the Repository:
  * git clone https://github.com/pawan047/ChatApplication.git
  * cd chat-application
### Compile the Source Code:
  * javac Main.java
### Run the Main Class:
  * java Main

##  Configuration
* Server Configuration: Default port is 7777. Modify Server.java to change settings.
* Client Configuration: Update the server address and port in Client.java
## Usage
* Start the Server: Launch the server application first. The server will wait for incoming client connections.
* Start the Client(s): Launch one or more instances of the client application. Clients can connect to the server and start sending messages.
* Send Messages from both the ends: Use the text input field in the client GUI to send messages. All connected clients will receive the message.
## Code Structure
*  src/main/java/org.example/Server.java: Contains the server-side code for handling client connections and broadcasting messagesand GUI
*  src/main/java/org.example/client.java: Contains the client-side code for sending and receiving messagesand GUI part
*  src/main/java/org.example/Main.java: Event handling using  multithreading


## Contributing
* Contributions are welcome! If you would like to contribute to this project, please fork the repository and submit a pull request with your proposed changes.

## License
* This project is licensed under the MIT License.

## Acknowledgments
* Java Documentation: For comprehensive details on Java libraries and tools used.
* Java Swing Tutorial: For guidance on creating the GUI components.
## Contact
* For any questions or suggestions, please contact me at saini.pawan1711@gmail.com.


  
