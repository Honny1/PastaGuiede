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

import java.text.DecimalFormat;

public class CalcActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    NumberPicker numberpicker;
    TextView textview1, textview, textview2;
    int spagety, omacka;
    double val;
    String output;
    double[] omackaB, omackaS;
    String[] surB, surS;

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
            case 0:
                setIngedience(val);
                break;
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
             double porce=newVal*200;
             customFormat("###", porce);
             textview.setText("Špagety: "+output+"g");
         }
         else if(spagety==2){
             textview.setText("Špagety: N/A");
         }
         if (omacka==0){
             textview2.setText("Omacka: N/A");
         }
         if (omacka==2){
             double mleko=newVal*100;
             double taveny=newVal*100;
             double eidam=newVal*100;
             double sul=newVal*0.05;
             double koreni=newVal*0.05;
             double pepr=newVal*0.05;
             omackaS = new double[]{mleko, taveny, eidam, sul, koreni, pepr};
             customFormat2("#.##");

         }
         else {
             if (omacka == 1) {
                 double maso = newVal*100;
                 double rajcata = newVal * 0.75;
                 double cukr = newVal * 0.1;
                 double sul = newVal * 0.05;
                 double koreni = newVal * 0.1;
                 double pepr = newVal * 0.05;
                 double paprika = newVal * 0.15;
                 double oregano = newVal * 0.1;
                 double cenek = newVal * 0.2;
                 double cibule = newVal * 0.3;
                 omackaB = new double[]{maso, rajcata, cukr, sul, koreni, pepr, paprika, oregano, cenek, cibule};
                 customFormat1("#.##");
             }
         }
         customFormat("###", newVal);
         textview1.setText("suroviny na: " + output +" porcí.");
     }
     public void customFormat(String pattern, double value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output1 = myFormatter.format(value);
        output = output1;

    }
    public void customFormat1(String pattern) {
        int lenpole=omackaB.length;
        surB = new String[lenpole];
        for (int i = 0; i < lenpole; i++) {
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            String output1 = myFormatter.format(omackaB[i]);
            surB[i] = output1;
        }
        seTText();
    }
    public void seTText(){
        textview2.setText("Maso: " + surB[0] + "g" + "\nPepř: " + surB[1] + "g" + "\nKoření na špagety: " + surB[2] + "g" + "\nSůl: " + surB[3] + "g" + "\nRajčata: " + surB[4] + "g" + "\nCukr: " + surB[5] + "g" + "\nMletá paprika: " + surB[6] + "g" + "\nOregano: " + surB[7] + "g" + "\nCibule: " + surB[8] + "g" + "\nČesnek: " + surB[9] + "g");
    }
    public void customFormat2(String pattern) {
        int lenpole=omackaS.length;
        surS = new String[lenpole];
        for (int i = 0; i < lenpole; i++) {
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            String output1 = myFormatter.format(omackaS[i]);
            surS[i] = output1;
        }
        seTText1();
    }
    public void seTText1(){
        textview2.setText("Mléko: "+surS[0]+"ml"+"\nTavený sýr: "+surS[1]+"g"+"\nEidam: "+surS[2]+"g"+"\nSůl: "+surS[3]+"g"+"\nKoření: "+surS[4]+"g"+"\nČerný mletý pepr: "+surS[5]+"g");

    }


}