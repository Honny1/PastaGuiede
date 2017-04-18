package cz.god.is.hony.spagetyapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;



public class PDFactivity extends AppCompatActivity {
    PDFView pdfView;
    int Type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfactivity);
        pdfView= (PDFView)findViewById(R.id.pdfView);
        Bundle Bnd = getIntent().getExtras();
        Type = Bnd.getInt("Nazev");

        switch (Type){
            case 0:
                pdfView.fromAsset("Ebook.pdf").load();
                break;
            case 1:
                pdfView.fromAsset("Ebook1.pdf").load();
                break;
            case 2:
                pdfView.fromAsset("Ebook2.pdf").load();
                break;
        }
    }
}

