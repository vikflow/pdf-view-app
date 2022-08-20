package com.example.spsstutorial;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.pdfview.PDFView;

public class PdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        PDFView pdfView = findViewById(R.id.pdfview);

        Intent intent = getIntent();

        if (intent.hasExtra("PName")) {
            String PName = intent.getStringExtra("PName") + ".pdf";
            pdfView.fromAsset(PName).show();
        } else {
            pdfView.fromAsset("SPSSChapter1.pdf").show();
        }


    }
}