package br.com.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AppNovo extends Activity {

	private EditText text1, text2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		text1 = (EditText) findViewById(R.id.text);
		text2 = (EditText) findViewById(R.id.text2);

		Button botao = (Button) findViewById(R.id.button1);

		botao.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				text2.setText(text1.getText().toString());
				

			}
		});

	}
}