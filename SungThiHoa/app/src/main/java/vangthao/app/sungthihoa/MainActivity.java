package vangthao.app.sungthihoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnClickHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadViews();
        loadEventList();
    }

    private void loadEventList() {
        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoelActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadViews() {
        btnClickHere = findViewById(R.id.btnClickHere);
    }
}