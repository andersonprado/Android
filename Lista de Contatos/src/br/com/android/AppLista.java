package br.com.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AppLista extends Activity {
	public ListView lista;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contatos);
		lista = (ListView) findViewById(R.id.lstcontatos);
		lista.setAdapter(adapter);

		lista.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View arg1, View arg2,
					long arg3) {
				if (lista.getSelectedItem() != null) {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							AppLista.this);
					dialogo.setTitle("Contato selecionado");
					dialogo.setMessage(lista.getSelectedItem().toString());
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				}

			}

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}

		});

	}

	static final String[] contatos = new String[] { "Alline", "Lucas",
			"Rafael", "Gabriela", "Silvana", "Romario", "Messi", "Rivaldo", "Pato" };
}