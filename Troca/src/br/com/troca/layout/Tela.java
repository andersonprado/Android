package br.com.troca.layout;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class Tela extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		carregaTelaPrincipal();

		Thread t = new Thread() {
			public void run() {
				CarregaTela2();
			}
		};
		t.start();

	}

	public void carregaTelaPrincipal() {
		setContentView(R.layout.layout1);

		Button bttela2 = (Button) findViewById(R.id.button1);
		bttela2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				CarregaTela2();
			}
		});

		Button bttela3 = (Button) findViewById(R.id.button4);
		bttela3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				CarregaTela3();
			}
		});

		Button bttela6 = (Button) findViewById(R.id.button6);
		bttela6.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				CarregaTela2();
			}
		});

	}

	public void CarregaTela2() {
		setContentView(R.layout.layout2);
		Button btTelaPrincipal = (Button) findViewById(R.id.button2);
		btTelaPrincipal.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				carregaTelaPrincipal();
			}
		});
	}

	public void CarregaTela3() {
		setContentView(R.layout.layout3);
		Button btTelaPrincipal = (Button) findViewById(R.id.button3);
		btTelaPrincipal.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				carregaTelaPrincipal();
			}
		});
	}

	public void CarregaTela4() {
		setContentView(R.layout.layout4);
		Button btTelaPrincipal = (Button) findViewById(R.id.button5);
		btTelaPrincipal.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				carregaTelaPrincipal();
			}
		});
	}

}
