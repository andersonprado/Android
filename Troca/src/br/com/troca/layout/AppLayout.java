package br.com.troca.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class AppLayout extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);

		Thread t = new Thread() {
			public void run() {
				try {
					sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				} finally {
					Intent janelaInicial = new Intent(
							"br.com.troca.layout.Tela");
					startActivity(janelaInicial);
				}
			}
		};
		t.start();

	}

}
