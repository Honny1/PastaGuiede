package cz.god.is.hony.spagetyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CalcActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    NumberPicker numberpicker;
    TextView textview1, textview, textview2;
    int spagety, omacka;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        spinner=(Spinner) findViewById(R.id.Operace);
        numberpicker = (NumberPicker)findViewById(R.id.numberPicker1);
        textview1 = (TextView)findViewById(R.id.textView2);
        textview = (TextView)findViewById(R.id.textView3);
        textview2 = (TextView)findViewById(R.id.textView4);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.spinnerVyber, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        numberpicker.setMinValue(0);
        numberpicker.setMaxValue(100);
        numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if (spagety==1){
                    int porce=newVal*100;
                    textview.setText("�pagety: "+porce+"g");
                }
                else if(spagety==2){
                    int porce=0;
                    textview.setText("�pagety: "+porce+"g");
                }
                if (omacka==0){
                }
                if (omacka==2){
                    int mleko=newVal*1;
                    int taveny=newVal*1;
                    int eidam=newVal*1;
                    int sul=newVal*0.05;
                    int koreni=newVal*0.05;
                    int pepr=newVal*0.05;
                    textview2.setText("Ml�ko: "+mleko+"ml"+"\nTaven� s�r: "+taveny+"g"+"\nEidam: "+eidam+"g"+"\nS�l: "+sul+"g"+"\nKo�en�: "+koreni+"g"+"\n�ern� mlet� pepr: "+pepr+"q");
                }
                else if(omacka==1){
                    int maso=newVal*1;
                    int rajcata=newVal*0.75;
                    int cukr=newVal*0.1;
                    int sul=newVal*0.05;
                    int koreni=newVal*0.1;
                    int pepr=newVal*0.05;
                    int paprika=newVal*0.15;
                    int oregano=newVal*0.1;
                    int cenek=newVal*0.2;
                    int cibule=newVal*0.3;
                    textview2.setText("Maso: "+maso+"g"+"\nPep�: "+pepr+"g"+"\nKo�en� na �pagety: "+koreni+"g"+"\nS�l: "+sul+"g"+"\nRaj�ata: "+rajcata+"g"+"\nCukr: "+cukr+"g"+"\nMlet� paprika: "+paprika+"g"+"\nOregano: "+oregano+"g"+"\nCibule"+cibule+"g"+"\n�esnek"+cenek+"g");
                }
                textview1.setText("suroviny na: " + newVal+"porc�.");
            }
        });
    }
    public void onCheckboxClicked(View view) {
        spagety=0;
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkbox_pasta:
                if (checked){
                    spagety+=1;
                }
                else{
                    spagety+=2;
                    break;
                }
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        omacka=0;
        switch (position) {
            case 1:
                omacka+=1;
                Toast.makeText(this, "Bolo�sk� om��ka", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                omacka+=2;
                Toast.makeText(this, "S�rov� om��ka", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}