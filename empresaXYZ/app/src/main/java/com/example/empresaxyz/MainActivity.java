package com.example.empresaxyz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup_sexo;
    private RadioGroup radioGroup_tipo;
    private TextView valorNike, valorAdidas, valorPuma, resultado;
    private EditText cantidad_nike, cantidad_adidas, cantidad_puma;
    private LinearLayout lista;
    private int sele_sexo, sele_tipo;

    int clasificacion [][][] = new int[2][2][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llenar();
        radioGroup_sexo = findViewById(R.id.rgpSexo);
        radioGroup_tipo = findViewById(R.id.rgpTipos);
        lista = findViewById(R.id.llValores);
        valorNike = findViewById(R.id.lblNikeValor);
        valorAdidas = findViewById(R.id.lblAdidasValor);
        valorPuma = findViewById(R.id.lblPumasValor);
        cantidad_nike = findViewById(R.id.lblnNike);
        cantidad_adidas = findViewById(R.id.lblnAdidas);
        cantidad_puma = findViewById(R.id.lblnPuma);
        resultado = findViewById(R.id.lblResultado);
    }

    public void llenar(){
        clasificacion[0][0][0] = 120000;
        clasificacion[0][0][1] = 140000;
        clasificacion[0][0][2] = 130000;
        clasificacion[0][1][0] = 50000;
        clasificacion[0][1][1] = 80000;
        clasificacion[0][1][2] = 100000;

        clasificacion[1][0][0] = 100000;
        clasificacion[1][0][1] = 130000;
        clasificacion[1][0][2] = 110000;
        clasificacion[1][1][0] = 60000;
        clasificacion[1][1][1] = 70000;
        clasificacion[1][1][2] = 120000;
    }

    public void mostrar_tipos_h(View v){
        sele_sexo = 0;
        limpiar();
        if (radioGroup_tipo.getVisibility() != View.VISIBLE){
            radioGroup_tipo.setVisibility(View.VISIBLE);
        }else{
            imprimir_valores();
        }
    }

    public void mostrar_tipos_f(View v){
        sele_sexo = 1;
        limpiar();
        if (radioGroup_tipo.getVisibility() != View.VISIBLE){
            radioGroup_tipo.setVisibility(View.VISIBLE);
        }else{
            imprimir_valores();
        }
    }

    public void mostrar_valores_z(View v){
        sele_tipo = 0;
        limpiar();
        if (lista.getVisibility() != View.VISIBLE){
            lista.setVisibility(View.VISIBLE);
             imprimir_valores();
        }else{
             imprimir_valores();
        }
    }

    public void mostrar_valores_c(View v){
        sele_tipo = 1;
        limpiar();
        if (lista.getVisibility() != View.VISIBLE){
            lista.setVisibility(View.VISIBLE);
            imprimir_valores();
        }else{
            imprimir_valores();
        }
    }

    public void imprimir_valores(){
        int valor_n = clasificacion[sele_sexo][sele_tipo][0];
        int valor_a = clasificacion[sele_sexo][sele_tipo][1];
        int valor_p = clasificacion[sele_sexo][sele_tipo][2];
        valorNike.setText(""+valor_n);
        valorAdidas.setText(""+valor_a);
        valorPuma.setText(""+valor_p);
    }

    public void calcular_precio(View v){
        double monto_total = 0;
        if (!cantidad_nike.getText().toString().isEmpty()){
           double valor = Double.parseDouble(valorNike.getText().toString());
           double cantidad = Double.parseDouble(cantidad_nike.getText().toString());
           monto_total += valor*cantidad;
        }
        if (!cantidad_adidas.getText().toString().isEmpty()){
            double valor = Double.parseDouble(valorAdidas.getText().toString());
            double cantidad = Double.parseDouble(cantidad_adidas.getText().toString());
            monto_total += valor*cantidad;
        }
        if (!cantidad_puma.getText().toString().isEmpty()){
            double valor = Double.parseDouble(valorPuma.getText().toString());
            double cantidad = Double.parseDouble(cantidad_puma.getText().toString());
            monto_total += valor*cantidad;
        }
        resultado.setText(getString(R.string.resultado)+monto_total);
    }

    public void limpiar(){
        valorNike.setText("");
        valorAdidas.setText("");
        valorPuma.setText("");
        resultado.setText("");
        cantidad_nike.setText("");
        cantidad_adidas.setText("");
        cantidad_puma.setText("");

    }

}
