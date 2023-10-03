package com.example.deep10.Classes;

import static com.example.deep10.DataCollector.TablesString.SaleTable.*;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.List;

public class Sales implements SqlInterface{
    //region Attributes
    private int salesid;
    private int prodid;
    private String userid;
   //endregion

    //region Constructors
    public Sales(int salesid, int salesprod, String salesuser) {
        this.salesid = salesid;
        this.prodid = salesprod;
        this.userid = salesuser;
    }
    //endregion

    //region Add,Delete,Update,Select Sql
    @Override
    public long Add(SQLiteDatabase db) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(COLUMN_SALE_PROD_ID, prodid);
        values.put(COLUMN_SALE_USER_ID, userid);

// Insert the new row, returning the primary key value of the new row
        return db.insert(TABLE_SALE, null, values);
    }

    @Override
    public int Delete(SQLiteDatabase db, int id) {
        String selection = BaseColumns._ID + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = {id+""};
// Issue SQL statement.
        return db.delete(TABLE_SALE, selection, selectionArgs);
    }

    @Override
    public int Update(SQLiteDatabase db, int id) {
        // New value for one column
        ContentValues values = new ContentValues();
        values.put(COLUMN_SALE_PROD_ID, prodid);
        values.put(COLUMN_SALE_USER_ID, userid);

// Which row to update, based on the title
        String selection = BaseColumns._ID + " LIKE ?";
        String[] selectionArgs = { id+"" };

        return  db.update(
                TABLE_SALE,
                values,
                selection,
                selectionArgs);
    }

    @Override
    public Cursor Select(SQLiteDatabase db) {
        String[] projection = {
                BaseColumns._ID,
                COLUMN_SALE_PROD_ID,
                COLUMN_SALE_USER_ID
        };
// How you want the results sorted in the resulting Cursor
        String sortOrder =
                BaseColumns._ID + " DESC";
        Cursor c = db.query(TABLE_SALE,
                projection,
                null,
                null,
                null,
                null,
                sortOrder);
        return c;
    }

    //endregion

    //region Getter and Setter
    public int getSalesid() {
        return salesid;
    }

    public void setSalesid(int salesid) {
        this.salesid = salesid;
    }

    public int getSalesprod() {
        return prodid;
    }

    public void setSalesprod(int salesprod) {
        this.prodid = salesprod;
    }

    public String getSalesuser() {
        return userid;
    }

    public void setSalesuser(String salesuser) {
        this.userid = salesuser;
    }
    //endregion
}
