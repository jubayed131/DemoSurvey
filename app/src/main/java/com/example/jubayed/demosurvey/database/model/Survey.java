package com.example.jubayed.demosurvey.database.model;

public class Survey {

    public static final String TABLE_NAME = "demosurvey";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_FEEL = "feel";
    public static final String COLUMN_STRESS = "stress";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String name;
    private String feel;
    private String stress;
    private int level;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_FEEL + " TEXT,"
                    + COLUMN_STRESS + " TEXT,"
                    + COLUMN_LEVEL + " INTEGER,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Survey() {
    }

    public Survey(int id, String name, String timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    public Survey(String feel, String stress, int level) {
        this.feel = feel;
        this.stress = stress;
        this.level = level;
    }

    public Survey(int id, String name, String feel, String stress, int level, String timestamp) {
        this.id = id;
        this.name = name;
        this.feel = feel;
        this.stress = stress;
        this.level = level;
        this.timestamp = timestamp;
    }

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String note) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
