# Code Challange

This code challenge is implemented as a CLI program.
The user can enter as many texts as wished.
The program will then find anagrams and print them.

## Build & Run

```bash
mvn clean compile exec:java
```

## Usage

This program has an interactive mode which will be the first decision to make.
Either type 'y' for interactive or 'n' for non-interactive mode (default is non-interactive mode).

The next step is to enter as much texts as wished. The input will be considered done when an empty text is given. The program will then look for anagrams.

The last step will print the anagrams either for all input texts (non-interactive mode) or for a given text (interactive mode). If in interactive mode an empty text will finish the execution of the program.
