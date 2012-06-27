package br.com.contatos;

import javax.sql.DataSource;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

public class ContatosActivity extends Activity {
	ListAdapter adapter;
	DBAdapter datasourse;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		datasource = new DBAdapter(this);
		datasource.open();
		Cursor cursor = datasource.getContactos();
		String[] columns = new String[] { "nome", "telefone" };
		int[] to = new int[] { R.id.nome, R.id.telefone };
		adapter = new SimpleCursorAdapter(this, R.layout.contacto_list_item,
				cursor, columns, to);
		this.setListAdapter(adapter);
		datasource.close();
		Button btNovoContacto = (Button) findViewById(R.id.btNovoContacto);
		btNovoContacto.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent novo = new Intent("mbaltazar.contactos.NovoContacto");
				startActivity(novo);
			}
		});
	}
}