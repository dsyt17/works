package com.example.lr5;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

@RequiresApi(api = Build.VERSION_CODES.N)
public class login extends AppCompatActivity {
    Button login_button, registration_button, drop_button;
    EditText login_edit_text, password_edit_text;
    TextView login_error_text,password_error_text;
    dbHelper db;

    private static final short MIN_COUNT = 2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Узнать, как прошла регистрация!!
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new dbHelper(login.this);
        login_button = findViewById(R.id.login_button);
        registration_button = findViewById(R.id.registration_button);
        drop_button = findViewById(R.id.drop_button);
        password_edit_text = findViewById(R.id.password_edit_text);
        login_edit_text = findViewById(R.id.login_edit_text);


        login_button.setOnClickListener(onLoginButtonClickListener);
        registration_button.setOnClickListener(onRegButtonClickListener);
        drop_button.setOnClickListener(onDropButtonClickListener);

        // Запрет на ввод пробелов для пароля
        for (EditText et : new EditText[]{password_edit_text})
            et.addTextChangedListener(new TextWatcher()
            {
                @Override public void beforeTextChanged(CharSequence s, int start, int count, int after){}
                @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (Pattern.compile("[\\p{Space}]").matcher(et.getText().toString()).find())
                    {
                        et.setText(et.getText().toString().substring(0,et.getText().toString().length() - 1));
                        et.setSelection(et.getText().toString().length());
                    }

                }
                @Override public void afterTextChanged(Editable s){}
            });

        // Запрет на ввод символов для логина
        for (EditText et : new EditText[]{login_edit_text})
            et.addTextChangedListener(new TextWatcher()
            {
                @Override public void beforeTextChanged(CharSequence s, int start, int count, int after){}
                @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (Pattern.compile("[[^a-zA-Z]]").matcher(et.getText().toString()).find())
                    {
                        et.setText(et.getText().toString().substring(0,et.getText().toString().length() - 1));
                        et.setSelection(et.getText().toString().length());
                    }
                }
                @Override public void afterTextChanged(Editable s){}
            });

        login_edit_text.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable editable) {
                String login_changed = login_edit_text.getText().toString().trim();
                if(login_changed.length()==0){
                    login_error_text.setTextColor(Color.parseColor("#FFAAAAAA"));
                }
                else{
                    if(ValidateLogin(login_edit_text)){
                        login_error_text.setTextColor(Color.parseColor("#F44336"));
                        login_error_text.setText(R.string.login_true_but_not_exist_message);
                    }
                    else{
                        login_error_text.setTextColor(Color.parseColor("#F44336"));
                        login_error_text.setText(R.string.login_error_message);
                    }
                }
                if(!login_changed.equals("") && GetUserFromDB(login_changed).equals(login_changed)){
                    login_error_text.setTextColor(Color.parseColor("#4BD327"));
                    login_error_text.setText(R.string.login_true_and_exist_message);
                }
            }
        });

        password_edit_text.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable editable) {
                if(password_edit_text.getText().toString().trim().length()==0){
                    password_error_text.setTextColor(Color.parseColor("#FFAAAAAA"));
                }
                else{
                    if(ValidatePassword(password_edit_text)){
                        password_error_text.setTextColor(Color.parseColor("#4BD327"));
                        password_error_text.setText(R.string.password_true_message);
                    }
                    else{
                        password_error_text.setTextColor(Color.parseColor("#F44336"));
                        password_error_text.setText(R.string.password_error_message);
                    }
                }
            }
        });

    }

    private boolean ValidatePassword(EditText password){
        String passwordInput = password.getText().toString();
        return isPasswordValid(passwordInput);
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 7;
    }

    private String GetUserFromDB(String user){
        Cursor cursor = db.searchUser(user);
        String user_from_db = "";
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()) {
                user_from_db = cursor.getString(0);
            }
        }
        return user_from_db;
    }

    private String GetPasswordByUserFromDB(String user){
        Cursor cursor = db.searchPassword(user);
        String password_from_db = "";
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()) {
                password_from_db = cursor.getString(0);
            }
        }
        return password_from_db;
    }

    private boolean ValidateLogin(EditText login){
        String loginInput = login.getText().toString();
        return isLoginValid(loginInput);
    }

    private boolean isLoginValid(String login) {
        return login != null && login.trim().length() > 5;
    }

    private String getLogin() {
        if (login_edit_text.getText().toString().length() == 0) return "";
        else return login_edit_text.getText().toString().trim();
    }

    private String getPassword() {
        if (password_edit_text.getText().toString().length() == 0) return "";
        else return password_edit_text.getText().toString().trim();
    }

    private final View.OnClickListener onLoginButtonClickListener = view ->{
        {
            if (!getLogin().equals("") && !getPassword().equals("")) {
                List<String> list = Arrays.asList(getLogin(), getPassword());
                if (list.stream().filter((p) -> !p.isEmpty()).count() >= MIN_COUNT) {
                    if(GetUserFromDB(list.get(0)).equals(list.get(0))){
                        CryptoUtil cryptoUtil = new CryptoUtil();
                        String secretKey = "liaten";
                        String hashed_password = GetPasswordByUserFromDB(getLogin());
                        //String hash_password = AES.decrypt(hashed_password, secretKey);
                        String hash_password= null;
                        try {
                            hash_password = cryptoUtil.decrypt(secretKey, hashed_password);
                        } catch (NoSuchAlgorithmException
                                | InvalidKeySpecException
                                | NoSuchPaddingException
                                | InvalidKeyException
                                | InvalidAlgorithmParameterException
                                | IllegalBlockSizeException
                                | BadPaddingException
                                | IOException e) {
                            e.printStackTrace();
                        }
                        assert hash_password != null;
                        if(hash_password.equals(list.get(1))){
                            Intent intent = new Intent(this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Успешный вход", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Введённый пароль не совпадает с паролем в базе", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(login.this, "Пользователя с таким логином не существует", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Не хватает данных для добавления", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this,"Не все поля заполнены",Toast.LENGTH_SHORT).show();
            }
        }
    };


    private final View.OnClickListener onRegButtonClickListener = view ->
    {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    };

    private final View.OnClickListener onDropButtonClickListener = view ->
    {
        password_edit_text.setText("");
        login_edit_text.setText("");
    };
}
