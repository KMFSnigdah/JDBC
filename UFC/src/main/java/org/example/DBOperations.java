package org.example;
import org.example.Utils.*;

import java.sql.*;

public class DBOperations {

    Connection conn;

    //DB Connection
    public void doConnectionDB(){
        try {
            conn = DriverManager.getConnection(DatabaseUtils.connectionString, DatabaseUtils.userName, DatabaseUtils.password);
            System.out.println("DB Connection is successful!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Fetch All Data From Fighter Table
    public void fetchFightersData() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + FightersUtils.TABLE_NAME);

            System.out.println();
            System.out.println("Fighter Details");
            System.out.println();

            while (rs.next()) {
                int id = rs.getInt(FightersUtils.COLUMN_ID);
                String playerName = rs.getString(FightersUtils.COLUMN_PLAYER_NAME);
                int rank = rs.getInt(FightersUtils.COLUMN_RANK);
                String weightCategory = rs.getString(FightersUtils.COLUMN_WEIGHT_CATEGORY);
                int winNumber = rs.getInt(FightersUtils.COLUMN_WIN_NUMBER);
                int loseNumber = rs.getInt(FightersUtils.COLUMN_LOSE_NUMBER);
                int drawNumber = rs.getInt(FightersUtils.COLUMN_DRAW_NUMBER);
                String upcomingFightDate = rs.getString(FightersUtils.COLUMN_UPCOMING_FIGHT_DATE);

                // Print fighter details
                System.out.println("ID: " + id +
                        " | Player Name: " + playerName +
                        " | Rank: " + rank +
                        " | Weight Category: " + weightCategory +
                        " | Wins: " + winNumber +
                        " | Losses: " + loseNumber +
                        " | Draws: " + drawNumber +
                        " | Upcoming Fight Date: " + upcomingFightDate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Fetch All Data From Event Table
    public void fetchEventsData() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + EventsUtils.TABLE_NAME);

            System.out.println();
            System.out.println("Event Details");
            System.out.println();

            while (rs.next()) {
                int id = rs.getInt(EventsUtils.COLUMN_ID);
                String eventName = rs.getString(EventsUtils.COLUMN_EVENT_NAME);
                String eventCategory = rs.getString(EventsUtils.COLUMN_EVENT_CATEGORY);
                String eventDate = rs.getString(EventsUtils.COLUMN_EVENT_DATE);
                String stadiumName = rs.getString(EventsUtils.COLUMN_STADIUM_NAME);
                String location = rs.getString(EventsUtils.COLUMN_LOCATION);

                // Print fighter details
                System.out.println("ID: " + id +
                        " | Event Name: " + eventName +
                        " | Category: " + eventCategory +
                        " | Event Date: " + eventDate +
                        " | Stadium Name: " + stadiumName +
                        " | Location: " + location);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Fetch Only Lightweight Player
    public void fetchLightweightPlayers() {
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM " + FightersUtils.TABLE_NAME + " WHERE " +
                    FightersUtils.COLUMN_WEIGHT_CATEGORY + " = 'lightweight'";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println();
            System.out.println("Lightweight Fighters");
            System.out.println();

            while (rs.next()) {
                int id = rs.getInt(FightersUtils.COLUMN_ID);
                String playerName = rs.getString(FightersUtils.COLUMN_PLAYER_NAME);
                int rank = rs.getInt(FightersUtils.COLUMN_RANK);
                int winNumber = rs.getInt(FightersUtils.COLUMN_WIN_NUMBER);
                int loseNumber = rs.getInt(FightersUtils.COLUMN_LOSE_NUMBER);
                int drawNumber = rs.getInt(FightersUtils.COLUMN_DRAW_NUMBER);
                String upcomingFightDate = rs.getString(FightersUtils.COLUMN_UPCOMING_FIGHT_DATE);

                // Print lightweight fighter details
                System.out.println("ID: " + id +
                        " | Player Name: " + playerName +
                        " | Rank: " + rank +
                        " | Wins: " + winNumber +
                        " | Losses: " + loseNumber +
                        " | Draws: " + drawNumber +
                        " | Upcoming Fight Date: " + upcomingFightDate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Fetches and displays the details of heavyweight fighters and their corresponding event details.
     * Uses a LEFT JOIN to match heavyweight fighters with events of the same category.
     */
    public void fetchHeavyweightFightersWithEvents() {
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT f.player_name, f.rank, f.upcoming_fight_date, " +
                    "e.stadium_name, e.location, e.event_date " +
                    "FROM " + FightersUtils.TABLE_NAME + " f " +
                    "LEFT JOIN " + EventsUtils.TABLE_NAME + " e " +
                    "ON f.weight_category = 'heavyweight' " +
                    "AND e.event_category = 'heavyweight'";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println();
            System.out.println("Heavyweight Fighters and Event Details");
            System.out.println();

            while (rs.next()) {
                String playerName = rs.getString("player_name");
                int rank = rs.getInt("rank");
                String upcomingFightDate = rs.getString("upcoming_fight_date");
                String stadiumName = rs.getString("stadium_name");
                String location = rs.getString("location");
                String eventDate = rs.getString("event_date");

                // Print heavyweight fighter and event details
                System.out.println("Player Name: " + playerName +
                        " | Rank: " + rank +
                        " | Upcoming Fight Date: " + upcomingFightDate +
                        " | Stadium Name: " + stadiumName +
                        " | Location: " + location +
                        " | Event Date: " + eventDate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



