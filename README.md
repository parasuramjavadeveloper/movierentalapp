# MovieRentalsApp

MovieRentalsApp creates an information slip about movie rentals.

# Technologies/Tools Used 

1) Java 11 
2) Intellij Idea for Development
3) Maven Build Tool
4) Lombok Libraries

## To run the test:

```
javac src/*.java
java -cp src com.etraveli.movierentalsapp.MovieRentalsApp
```
# Refactoring Items

1) Converted into Maven Project and Build the code
2) Changed the Data Models of the Application according to the Business Requirements and Written the JUnit Tests
3) Main Business Logic is to find the MovieRentals based on MovieTypes.
4) Packaging and Refactoring done in all the classes but still its open for Refactoring and Improvements.
   a) Might add several junit tests to test all edge cases 
   b) Can use JDK 17 and its features to replace if conditions using Optional.ofNullable().ifPresentOrElse() etc
   c) Can Introduce InMemory/Persistent DB to add Customers,Movies,RentalInformation and CustomerMovieRentalsTotalRentDetails
   d) Unique ID can be added for Customer and Movie  for Unique Identification.

# Future Code Improvements

1) Can be developed as SpringBoot REST API which will give you the Given Customers and Its total Movie Rentals.
2)  Expose the endpoint with swagger documentation and Relational Database required to maintain the relationships between the tables.
