# Advanced Text Editor with Design Patterns

## Introduction
This Advanced Text Editor is a sophisticated Java application designed to showcase the integration of several design patterns: Command, Decorator, and Strategy, combined to enhance functionality and user experience. Built with a Java Swing GUI, it offers a rich text editing environment with support for various text actions and encryption, alongside efficient saving and loading of documents.

## Features
- **Rich Text Editing**: Provides a comprehensive set of text editing features, including undo/redo, copy, paste, and more, implemented via the Command pattern for easy undoability and command logging.
- **Text Encryption**: Employs the Decorator pattern to add encryption capabilities to text, allowing users to secure their documents without altering the core text handling functionality.
- **Flexible Document Management**: Utilizes the Strategy pattern for saving and loading documents, enabling the support of different file formats and storage strategies seamlessly.
- **Java Swing GUI**: Features a user-friendly graphical user interface, designed with Java Swing, making text editing intuitive and accessible.

## Technologies
- **Programming Language**: Java
- **GUI Framework**: Java Swing
- **Design Patterns**:
  - **Command Pattern**: For implementing text editing commands and actions.
  - **Decorator Pattern**: For adding encryption capabilities to text.
  - **Strategy Pattern**: For flexible saving and loading mechanisms.

## Implementation Details
- **Command Pattern**: Centralizes text actions like undo, redo, copy, and paste, facilitating their management and extension.
- **Decorator Pattern**: Wraps text components to add encryption/decryption functionality dynamically, without changing the original text component's code.
- **Strategy Pattern**: Defines a family of algorithms for file operations (save/load), enabling the editor to support various file formats and encryption methods dynamically.

## Setup and Installation
1. **Prerequisites**: Java Development Kit (JDK) 8 or higher.
2. **Clone the Repository**: Execute `git clone [repository-url]` to download the project source code.
3. **Project Compilation**: Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse) and build the project to resolve dependencies.
4. **Run the Application**: Launch the application through your IDE or via the command line using `java -jar [compiled-jar-file-name]`.

## How to Use
- Launch the text editor from the GUI.
- Use the menu options or toolbar icons to perform text editing actions, encrypt text, and manage document files.
- Customize the text appearance through the provided settings options.
- Select the appropriate save/load strategy for your document from the options menu.

## Contribution
Contributions to enhance the Advanced Text Editor are warmly welcomed. Whether it's adding new features, improving existing functionalities, or fixing bugs, please feel free to fork the repository, make your changes, and submit a pull request for review.

