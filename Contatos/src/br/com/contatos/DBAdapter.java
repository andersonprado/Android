package br.com.contatos;

import java.io.ByteArrayOutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

public class DBAdapter {
	private SQLiteDatabase database;
	private DBHelper dbHelper;
	private String[] allColumns = { DBHelper.ID, DBHelper.NOME, DBHelper.EMAIL,
			DBHelper.TELEFONE, DBHelper.FOTO };

	public DBAdapter(Context context) {
		dbHelper = new DBHelper(context);
	}

	public Contato createContato(String nome, String email, String telefone,
			Bitmap foto) {

		ContentValues values = new ContentValues();
		values.put(DB.NOME, nome);
		values.put(DB.EMAIL, email);
		values.put(DB.TELEFONE, nome);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		foto.compress(Bitmap.CompressFormat.PNG, 100, baos);
		byte[] phote = baos.toByteArray();
		values.put(DB, FOTO, photo);
		long insertID = database.insert(DB.TABLE_NAME, allColumns, DB.ID + "="
				+ insertID, null, null, null, null);
		cursor.moveToFirst();
		return cursorToContato(cursor);
	}

	public void EliminaContacto(int idContacto) {
		database.delete(DbHelper.TABLE_NAME, DbHelper.ID + " = " + idContacto,
				null);
	}

	private Contacto cursorToContacto(Cursor cursor) {
		byte[] blob = cursor.getBlob(cursor.getColumnIndex(DB.FOTO));
		Bitmap bmp = BitmapFactory.decodeByteArray(blob, 0, blob.length);
		Contacto contacto = new Contacto(cursor.getLong(0),
				cursor.getString(1), cursor.getString(2), cursor.getString(3),
				bmp);
		return contacto;
	}

	public Cursor getContactos() {
		Cursor cursor = database.rawQuery(
				"select _id, nome,telefone,foto from contactos2", null);
		return cursor;
	}

	public Contacto getContacto(int idContacto) {
		Cursor cursor = database.query(DB.TABLE_NAME, allColumns, DB.ID + " = "
				+ idContacto, null, null, null, null);
		cursor.moveToFirst();
		return cursorToContacto(cursor);
	}
}
