package org.poolc.poolc1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button loginButton = (Button) findViewById(R.id.button_login);
        final EditText idEditText = (EditText) findViewById(R.id.edittext_login_id);
        final EditText pwEditText = (EditText) findViewById(R.id.edittext_login_password);

        assert loginButton != null;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String password = pwEditText.getText().toString();

                if (id.equals("test") && password.equals("makkapakka")) {
                    Intent intent = new Intent(LoginActivity.this, BoardActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "아이디나 비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
