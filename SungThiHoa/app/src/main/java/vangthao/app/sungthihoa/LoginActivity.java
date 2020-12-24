package vangthao.app.sungthihoa;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmailLogin;
    private EditText edtPasswordLogin;
    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private Button btnLogin;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadViews();
        loadEventList();
    }

    private void loadEventList() {
        btnLogin.setOnClickListener(v -> {
            String email = edtEmailLogin.getText().toString();
            String password = edtPasswordLogin.getText().toString();
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Tài khoản hoặc Mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    private void loadViews() {
        btnLogin = findViewById(R.id.btnLogin);
        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
    }
}