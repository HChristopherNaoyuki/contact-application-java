# Contact List Application

## Introduction

Welcome to the Contact List Application! This Java Swing app allows you to view and manage your contacts easily. It reads contact information from a text file and displays it in a simple, user-friendly interface designed to resemble Apple’s aesthetic.

## Features

- View a list of contacts from a text file.
- See detailed information for each contact, including mobile number, work number, and email.
- Clean and modern interface using the Nimbus look and feel.

## Requirements

To run this application, you will need:

- Java Development Kit (JDK) 8 or higher.
- A `contacts.txt` file formatted as follows:

  ```
  Name, Mobile Number, Work Number, Email
  ```

  For example:

  ```
  John Doe, 123-456-7890, 098-765-4321, john.doe@example.com
  Jane Smith, 987-654-3210, 012-345-6789, jane.smith@example.com
  ```

## Getting Started

Here’s how to get the application running:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/contact-list-app.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd contact-list-app
   ```

3. **Compile the Java files**:
   ```bash
   javac Solution/*.java
   ```

4. **Run the application**:
   ```bash
   java Solution.ContactApp
   ```

## How to Use

- Select a contact from the list on the left.
- Click the "Search" button to display the contact's details in the panel on the right.
