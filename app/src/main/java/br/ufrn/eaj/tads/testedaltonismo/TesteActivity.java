package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TesteActivity extends AppCompatActivity {

    public static final int TESTE1 = 1;
    public static final int TESTE2 = 2;
    public static final int TESTE3 = 3;
    int imagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);


        ImageView im = findViewById(R.id.im1);
        Button Cancelar = findViewById(R.id.cancelar);
        Button OK = findViewById(R.id.ok);


        Bundle params = getIntent().getExtras();
        imagem = params.getInt("imagem");



        if(imagem == 1){

            im.setImageResource(R.drawable.teste1);

        }else if(imagem == 2){

            im.setImageResource(R.drawable.teste2);

        } else if(imagem == 3){

            im.setImageResource(R.drawable.teste3);

        }




        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText t = findViewById(R.id.texto);

                if(t.getText().toString().equals("")){

                    Toast.makeText(TesteActivity.this,"Campo vazio" , Toast.LENGTH_SHORT).show();

                }else{

                    Intent intent = new Intent();
                    Bundle data = new Bundle();

                    data.putString("resposta",t.getText().toString());
                    intent.putExtras(data);

                    setResult(imagem,intent);
                    finish();
                }

            }
        });



    }
}
