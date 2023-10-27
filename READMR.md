# Anagram Java app

The Anagram java app is a Java program that allows you to input of texts and determine if they are anagrams of each other. It also lets you find anagrams of a given text.

## Features

- Input texts to compare to check for anagram.
- Find anagrams of a given text.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To run this program, you need:

- Java Development Kit (JDK) installed on your machine.

### Installation

1. Clone the repository to your local machine.

```
git clone https://github.com/mrgoraya/anagram-java.git
```

2. Navigate to the project directory.

```
cd anagram-java
```

### Usage
1. Run the program:

```
java Anagram
```

2Follow the prompts to input texts and find anagrams.

### Example
Here's a simple example of how the program works:
```
Enter the string: listen
Enter the next string: silent
These strings are anagrams!
Do you want to check more anagrams? (yes/no): yes
Enter the string: listen
Enter the next string: enlist
These strings are anagrams!
Do you want to check more anagrams? (yes/no): yes
Enter the string: listen
Enter the next string: apple
These strings are not anagrams!
Do you want to check more anagrams? (yes/no): no
Enter a text to find its anagrams: silent
Anagrams of 'silent': [enlist, listen]
Goodbye!
```