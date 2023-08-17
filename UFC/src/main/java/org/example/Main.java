package org.example;

public class Main {
    public static void main(String[] args) {

        // Create an instance of DBOperations to perform database operations
        DBOperations dbObj = new DBOperations();

        // Establish a database connection
        dbObj.doConnectionDB();

        // Fetch and display event data
        dbObj.fetchEventsData();

        // Fetch and display fighter data
        dbObj.fetchFightersData();

        // Fetch and display lightweight player data
        dbObj.fetchLightweightPlayers();

        // Fetch and display heavyweight fighters and their corresponding event details
        dbObj.fetchHeavyweightFightersWithEvents();
    }
}