package com.example.jubayed.demosurvey.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import com.example.jubayed.demosurvey.database.model.Survey;

public class DatabaseHelper extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "demosurvey_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Survey.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Survey.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertSurvey(Integer survey_id, String name, String feel, String stress, Integer level) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Survey.COLUMN_ID,survey_id);
        values.put(Survey.COLUMN_NAME, name);
        values.put(Survey.COLUMN_FEEL,feel);
        values.put(Survey.COLUMN_STRESS,stress);
        values.put(Survey.COLUMN_LEVEL,level);

        // insert row
        long id = db.insert(Survey.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long insertFeel(String feel) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Survey.COLUMN_FEEL, feel);

        // insert row
        long id = db.insert(Survey.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long insertStress(int stress) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Survey.COLUMN_STRESS, stress);

        // insert row
        long id = db.insert(Survey.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }
    public long insertLevel(int level) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Survey.COLUMN_LEVEL, level);

        // insert row
        long id = db.insert(Survey.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }


    public Survey getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Survey.TABLE_NAME,
                new String[]{Survey.COLUMN_ID, Survey.COLUMN_NAME, Survey.COLUMN_TIMESTAMP},
                Survey.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Survey note = new Survey(
                cursor.getInt(cursor.getColumnIndex(Survey.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Survey.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(Survey.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }

    public List<Survey> getAllNotes() {
        List<Survey> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Survey.TABLE_NAME + " ORDER BY " +
                Survey.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Survey note = new Survey();
                note.setId(cursor.getInt(cursor.getColumnIndex(Survey.COLUMN_ID)));
                note.setName(cursor.getString(cursor.getColumnIndex(Survey.COLUMN_NAME)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Survey.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }


    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Survey.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }


    public int updateNote(Survey survey) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Survey.COLUMN_NAME, survey.getName());

        // updating row
        return db.update(Survey.TABLE_NAME, values, Survey.COLUMN_ID + " = ?",
                new String[]{String.valueOf(survey.getId())});
    }

    public void deleteNote(Survey note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Survey.TABLE_NAME, Survey.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }


}
