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

## Implementation

The core of the implementation is the `AnagramCheck` interface which is implemented by 5 classes.
There is 3 different algorithms to check for anagrams which is `AnagramCheckSimple`, `AnagramCheckList` and `AnagramCheckMultiSet`.
`AnagramCheckCompose` is a way to use multiple implementations of `AnagramCheck` to compare the efficency of different implementations.
The second part/feature of this program is to give a list of anagrams for a given input text. The `AnagramCreator` is the interface to do so.
`AnagramCollector` is the only implementation of `AnagramCreator`.
The `Program` class has two dependencies and contains the program logic reading from the command line and making use of an `AnagramCheck` and an `AnagramCreator` (its two dependencies).
Since `AnagramCollector` implements both interfaces it is passed to `Program` as its dependencies and collects all anagrams for a certain text in a `HashMap` which is then used to lookup for anagrams (the second feature of this program).
