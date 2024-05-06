package com.example.a05exercicio01;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbD4;
    private RadioButton rbD6;
    private RadioButton rbD8;
    private RadioButton rbD10;
    private RadioButton rbD12;
    private RadioButton rbD20;
    private RadioButton rbD100;
    private Spinner cbRolagem;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rbD4 = findViewById(R.id.rbD4);
        rbD6 = findViewById(R.id.rbD6);
        rbD8 = findViewById(R.id.rbD8);
        rbD10 = findViewById(R.id.rbD10);
        rbD12 = findViewById(R.id.rbD12);
        rbD20 = findViewById(R.id.rbD20);
        rbD100 = findViewById(R.id.rbD100);
        tvResultado = findViewById(R.id.tvResultado);
        cbRolagem = findViewById(R.id.cbRolagem);
        rbD20.setChecked(true);

        preencherQntdDados();;
        Button btnRolar = findViewById(R.id.btnRolar);
        btnRolar.setOnClickListener(op -> rolar());
    }

    private void rolar() {
        Integer qtd = (Integer) cbRolagem.getSelectedItem();
        List<Integer> resultados = new ArrayList<>();
        if(rbD4.isChecked()){
            resultados =  calculadDados(4,qtd);
        }
        if(rbD6.isChecked()){
            resultados = calculadDados(6,qtd);
        }
        if(rbD8.isChecked()){
            resultados = calculadDados(8,qtd);
        }
        if(rbD10.isChecked()){
            resultados = calculadDados(10,qtd);
        }
        if(rbD12.isChecked()){
            resultados = calculadDados(12,qtd);
        }
        if(rbD20.isChecked()){
            resultados = calculadDados(20,qtd);
        }
        if(rbD100.isChecked()){
            resultados = calculadDados(100,qtd);
        }
        StringBuffer sb = new StringBuffer();
        int soma = 0;
        int dado = 1;
        for(Integer i : resultados){
            sb.append(dado);
            sb.append("º = ");
            sb.append(i);
            sb.append("\n");
            soma += i;
            dado++;
        }
        if(dado > 2) {
            sb.append("Total :");
            sb.append(soma);
        }
        tvResultado.setText(sb.toString());

    }

    private List<Integer> calculadDados(Integer dado, Integer quantidade){
        List<Integer> resultados = new ArrayList<>();
        for( int i = 0; i < quantidade; i++){
            resultados.add((int)(Math.random()*dado+1 ) );
        }
        return resultados;
    }

    private void preencherQntdDados(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cbRolagem.setAdapter(adapter);
    }
}