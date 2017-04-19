package cz.god.is.hony.spagetyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkbox_pasta:
                if (checked){
                    Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
                }
                // Put some meat on the sandwich
                else{
                    Toast.makeText(this, "No activity yet", Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }
}
