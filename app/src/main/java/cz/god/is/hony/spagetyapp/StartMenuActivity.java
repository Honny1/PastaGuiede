package cz.god.is.hony.spagetyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu_activity);
    }

    public void ukazSpagety(View view) {
        Bundle extras = new Bundle();

        switch(view.getId()){
            case R.id.button:
                extras.putInt("Nazev",0);
                startActivity(new Intent(getBaseContext(), PDFactivity.class).putExtras(extras));
                break;

            case R.id.button2:
                extras.putInt("Nazev",1);
                startActivity(new Intent(getBaseContext(), PDFactivity.class).putExtras(extras));
                break;

            case R.id.button3:
                extras.putInt("Nazev",2);
                startActivity(new Intent(getBaseContext(), PDFactivity.class).putExtras(extras));
                break;

            case R.id.button4:
                startActivity(new Intent(getBaseContext(), CalcActivity.class));
                break;

        }
    }
}


