package br.com.contatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "contatos.db";
	public static final String TABLE_NAME = "contatos";
	public static final int DATABASE_VERSION = 1;
	public static final String ID = "_id";
	public static final String NOME = "nome";
	public static final String EMAIL = "email";
	public static final String TELEFONE = "telefone";
	public static final String FOTO = "foto";
	public static final String DATABASE_CREATE = "create table" + TABLE_NAME
			+ "(" + ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + EMAIL
			+ "TEXT NOT NULL" + TELEFONE + "TEXT NOT NULL" + FOTO + "blob);";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DBHelper.class.getName(), "Upgrading database from version"
				+ oldVersion + "to" + newVersion
				+ ", which will destroy all old data");
		db.execSQL("Drop TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);

	}

}
