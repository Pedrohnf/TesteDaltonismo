package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final int TESTE1 = 1;
    public static final int TESTE2 = 2;
    public static final int TESTE3 = 3;
    int aux = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.teste1);
        Button b2 = findViewById(R.id.teste2);
        Button b3 = findViewById(R.id.teste3);
        Button resposta = findViewById(R.id.verificar);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(),TesteActivity.class);

                Bundle params1 = new Bundle();

                TextView t1 = findViewById(R.id.T1);

                params1.putInt("imagem", 1);
                i1.putExtras(params1);

                startActivityForResult(i1, TESTE1);

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(),TesteActivity.class);

                Bundle params2 = new Bundle();

                TextView t2 = findViewById(R.id.T2);

                params2.putInt("imagem", 2);
                i2.putExtras(params2);

                startActivityForResult(i2, TESTE2);
            }

        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(),TesteActivity.class);

                Bundle params3 = new Bundle();

                TextView t3 = findViewById(R.id.T3);

                params3.putInt("imagem", 3);
                i3.putExtras(params3);

                startActivityForResult(i3, TESTE3);
            }
        });


        resposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView result = findViewById(R.id.resultado);

                if(aux == 3){
                    result.setText("Aprovado no Teste");
                }else{
                    result.setText("Reprovado no Teste");
                }

            }
        });



        @Override
        protected void onActivityResult(int requestCode,int resultCode, Intent data){

            Bundle bundle = data.getExtras();
            String res;

            if (bundle != null) {
                res = bundle.getString("resultado");
                if (requestCode == 1) {
                    TextView texto = findViewById(R.id.T1);
                    texto.setText(res);
                    if (res.equals("2")) {
                        aux++;
                    }
                } else if (requestCode == 2) {
                    TextView texto = findViewById(R.id.T2);
                    texto.setText(res);
                    if (res.equals("29")) {
                        aux++;
                    }
                } else {
                    TextView texto = findViewById(R.id.T3);
                    texto.setText(res);
                    if (res.equals("74")) {
                        aux++;
                    }
                }

            }
        }

        }
}
