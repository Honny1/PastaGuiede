package cz.god.is.hony.spagetyapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class CalcActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    NumberPicker numberpicker;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        spinner=(Spinner) findViewById(R.id.Operace);
        numberpicker = (NumberPicker)findViewById(R.id.numberPicker1);
        textview = (TextView)findViewById(R.id.textView1);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.spinnerVyber, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        numberpicker.setMinValue(0);
        numberpicker.setMaxValue(100);
        numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textview.setText("Selected Value is : " + newVal);
            }
        });
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkbox_pasta:
                if (checked){

                    Toast.makeText(this, "YesPasta", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "NoPasta", Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:

                Toast.makeText(this, "Boloňská omáčka", Toast.LENGTH_SHORT).show();
                break;
            case 2:

                Toast.makeText(this, "Sýrová omáčka", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





}
