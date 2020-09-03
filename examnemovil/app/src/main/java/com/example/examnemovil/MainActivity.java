package com.example.examnemovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupMaterial, radioGroupDije, radioGroupTipo;
    private TextView valorunitario, valortotal;
    private EditText cantidad;
    private LinearLayout llDije, lltipo, llValor, llResultado;
    private Button btnCalcular;
    private Switch moneda;
    private int sele_material, sele_dije, sele_tipo, valor_final;

    private int precios [][][] = new int[2][2][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llenar();
        radioGroupMaterial = findViewById(R.id.rgpMaterial);
        radioGroupDije = findViewById(R.id.rgpDije);
        radioGroupTipo = findViewById(R.id.rgpTipo);
        llDije = findViewById(R.id.llDije);
        lltipo = findViewById(R.id.llTipo);
        llValor = findViewById(R.id.llValor);
        llResultado = findViewById(R.id.llResultado);
        valorunitario = findViewById(R.id.lblValorUnitario);
        valortotal = findViewById(R.id.lblTotal);
        cantidad = findViewById(R.id.lblnCantidad);
        btnCalcular = findViewById(R.id.btnCalcular);
        moneda = findViewById(R.id.swtMoneda);
    }

    public void llenar(){
        precios[0][0][0] = 100;
        precios[0][0][1] = 100;
        precios[0][0][2] = 80;
        precios[0][0][3] = 70;
        precios[0][1][0] = 120;
        precios[0][1][1] = 120;
        precios[0][1][2] = 100;
        precios[0][1][3] = 90;
        precios[1][0][0] = 90;
        precios[1][0][1] = 90;
        precios[1][0][2] = 70;
        precios[1][0][3] = 50;
        precios[1][1][0] = 110;
        precios[1][1][1] = 110;
        precios[1][1][2] = 90;
        precios[1][1][3] = 80;
    }

    public void mostrar_dije_cuero(View v){
        sele_material = 0;
        if (llDije.getVisibility() != View.VISIBLE){
            llDije.setVisibility(View.VISIBLE);
        }else{
            limpiar();
            valor_unitario();
        }
    }

    public void mostrar_dije_cuerda(View v){
        sele_material = 1;
        if (llDije.getVisibility() != View.VISIBLE){
            llDije.setVisibility(View.VISIBLE);
        }else{
            limpiar();
            valor_unitario();
        }
    }

    public void mostrar_tipo_martillo(View v){
        sele_dije = 0;
        if (lltipo.getVisibility() != View.VISIBLE){
            lltipo.setVisibility(View.VISIBLE);
        }else{
            limpiar();
            valor_unitario();
        }
    }

    public void mostrar_tipo_ancla(View v){
        sele_dije = 1;
        if (lltipo.getVisibility() != View.VISIBLE){
            lltipo.setVisibility(View.VISIBLE);
        }else{
            limpiar();
            valor_unitario();
        }
    }

    public void mostrar_valor_oro(View v){
        sele_tipo = 0;
        limpiar();
        valor_unitario();
        if (llValor.getVisibility() != View.VISIBLE){
            llValor.setVisibility(View.VISIBLE);
        }
    }

    public void mostrar_valor_oro_rosado(View v){
        sele_tipo = 1;
        limpiar();
        valor_unitario();
        if (llValor.getVisibility() != View.VISIBLE){
            llValor.setVisibility(View.VISIBLE);
        }
    }

    public void mostrar_valor_plata(View v){
        sele_tipo = 2;
        limpiar();
        valor_unitario();
        if (llValor.getVisibility() != View.VISIBLE){
            llValor.setVisibility(View.VISIBLE);
        }
    }

    public void mostrar_valor_niquel(View v){
        sele_tipo = 3;
        limpiar();
        valor_unitario();
        if (llValor.getVisibility() != View.VISIBLE){
            llValor.setVisibility(View.VISIBLE);
        }
    }

    public void limpiar(){
        cantidad.setText("");
        valorunitario.setText("");
        valortotal.setText("");
        moneda.setChecked(false);
        moneda.setText(getString(R.string.dolares));
    }

    public void valor_unitario(){
        int valorunit = precios[sele_material][sele_dije][sele_tipo];
        valorunitario.setText(getString(R.string.valor_unitario)+valorunit);
    }

    public void valor_total(View v){
        if (!cantidad.getText().toString().isEmpty()){
            if (llResultado.getVisibility() != View.VISIBLE){
                llResultado.setVisibility(View.VISIBLE);
            }
            int cantidad_ingresada = Integer.parseInt(cantidad.getText().toString());
            valor_final = cantidad_ingresada * precios[sele_material][sele_dije][sele_tipo];
            valortotal.setText(""+valor_final);
        }else{
            cantidad.setError(getString(R.string.msnError));
        }
    }

    public void moneda_cambio(View v){
        if (moneda.isChecked()){
            moneda.setText(getString(R.string.pesos));
            int cambio_pesos = valor_final * 3200;
            valortotal.setText(""+cambio_pesos);
        }else{
            moneda.setText(getString(R.string.dolares));
            valortotal.setText(""+valor_final);
        }
    }

}