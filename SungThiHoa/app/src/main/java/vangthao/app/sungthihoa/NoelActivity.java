package vangthao.app.sungthihoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NoelActivity extends AppCompatActivity {

    private Button btnSendWish;
    private EditText editWish;
    private TextView txtBye;
    private final DatabaseReference myDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://sungthihoa-1a35c-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noel);

        loadViews();
        loadEventList();
    }

    private void loadEventList() {
        btnSendWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wish = editWish.getText().toString();
                myDatabase.child("WISH").child("yourwish").push().setValue(wish, (error, ref) -> {
                    if (error == null) {
                        Toast.makeText(NoelActivity.this, "Gửi điều ước thành công!", Toast.LENGTH_SHORT).show();
                        txtBye.setText("Chúc điều ước của em sớm thành hiện thực nhé cô gái!");
                    } else {
                        Toast.makeText(NoelActivity.this, "Lỗi gửi điều ước!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void loadViews() {
        btnSendWish = findViewById(R.id.btnSendWish);
        editWish = findViewById(R.id.edtWish);
        txtBye = findViewById(R.id.txtBye);
    }
}