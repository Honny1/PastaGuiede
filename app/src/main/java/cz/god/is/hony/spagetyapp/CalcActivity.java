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

public class CalcActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    NumberPicker numberpicker;
    TextView textview1, textview, textview2;
    int spagety, omacka;
    double val;

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
                val=newVal;
                setIngedience(val);
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
                    setIngedience(val);
                    break;
                }
                else{
                    spagety+=2;
                    setIngedience(val);
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
                setIngedience(val);
                break;
            case 2:
                omacka+=2;
                setIngedience(val);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
     public void setIngedience(double newVal){
         if (spagety==1){
             double porce=newVal*100;
             textview.setText("Špagety: "+porce+"g");
         }
         else if(spagety==2){
             textview.setText("Špagety: N/A");
         }
         if (omacka==0){
             textview2.setText("Omacka: N/A");
         }
         if (omacka==2){
             double mleko=newVal;
             double taveny=newVal;
             double eidam=newVal;
             double sul=newVal*0.05;
             double koreni=newVal*0.05;
             double pepr=newVal*0.05;
             textview2.setText("Mléko: "+mleko+"ml"+"\nTavený sýr: "+taveny+"g"+"\nEidam: "+eidam+"g"+"\nSůl: "+sul+"g"+"\nKoření: "+koreni+"g"+"\nČerný mletý pepr: "+pepr+"q");
         }
         else if(omacka==1){
             double maso=newVal;
             double rajcata=newVal*0.75;
             double cukr=newVal*0.1;
             double sul=newVal*0.05;
             double koreni=newVal*0.1;
             double pepr=newVal*0.05;
             double paprika=newVal*0.15;
             double oregano=newVal*0.1;
             double cenek=newVal*0.2;
             double cibule=newVal*0.3;
             textview2.setText("Maso: "+maso+"g"+"\nPepř: "+pepr+"g"+"\nKoření na špagety: "+koreni+"g"+"\nSůl: "+sul+"g"+"\nRajčata: "+rajcata+"g"+"\nCukr: "+cukr+"g"+"\nMletá paprika: "+paprika+"g"+"\nOregano: "+oregano+"g"+"\nCibule"+cibule+"g"+"\nČesnek"+cenek+"g");
         }
         textview1.setText("suroviny na: " + newVal+"porcí.");
     }
}