package com.example.lr5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

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
public class register extends AppCompatActivity {
    EditText login_edit_text, email_edit_text, password_edit_text;
    TextView email_error_text, login_error_text, password_error_text;
    Button confirm_button, drop_button;
    dbHelper db;

    private static final short MIN_COUNT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login_edit_text = findViewById(R.id.login_edit_text);
        email_edit_text = findViewById(R.id.email_edit_text);
        password_edit_text = findViewById(R.id.password_edit_text);
        confirm_button = findViewById(R.id.confirm_button);
        drop_button = findViewById(R.id.drop_button);
        login_edit_text = findViewById(R.id.login_edit_text);


        db = new dbHelper(register.this);

        confirm_button.setOnClickListener(onConfirmButtonClickListener);
        drop_button.setOnClickListener(onDropButtonClickListener);

        // Запрет на ввод нерелевантных почтовому адресу символов
        for (EditText et : new EditText[]{email_edit_text})
            et.addTextChangedListener(new TextWatcher()
            {
                @Override public void beforeTextChanged(CharSequence s, int start, int count, int after){}
                @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (Pattern.compile("[[^a-zA-Z0-9@.]]").matcher(et.getText().toString()).find())
                    {
                        et.setText(et.getText().toString().substring(0,et.getText().toString().length() - 1));
                        et.setSelection(et.getText().toString().length());
                    }
                }
                @Override public void afterTextChanged(Editable s){}
            });

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
                        login_error_text.setTextColor(Color.parseColor("#4BD327"));
                        login_error_text.setText(R.string.login_true_message);
                    }
                    else{
                        login_error_text.setTextColor(Color.parseColor("#F44336"));
                        login_error_text.setText(R.string.login_error_message);
                    }
                }
                if(!login_changed.equals("") && GetUserFromDB(login_changed).equals(login_changed)){
                    login_error_text.setTextColor(Color.parseColor("#F44336"));
                    login_error_text.setText(R.string.login_exists_message);
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

        email_edit_text.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable editable) {
                if(email_edit_text.getText().toString().trim().length()==0){
                    email_error_text.setTextColor(Color.parseColor("#FFAAAAAA"));
                }
                else{
                    if(ValidateEmailAddress(email_edit_text)){
                        email_error_text.setTextColor(Color.parseColor("#4BD327"));
                        email_error_text.setText(R.string.email_true_message);
                    }
                    else{
                        email_error_text.setTextColor(Color.parseColor("#F44336"));
                        email_error_text.setText(R.string.email_error_message);
                    }
                }
            }
        });
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

    // Возвращает true, если email подходит

    private boolean ValidateEmailAddress(EditText email){
        String emailInput = email.getText().toString();
        return !emailInput.isEmpty()
                && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches();
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 7;
    }

    private boolean isLoginValid(String login) {
        return login != null && login.trim().length() > 5;
    }

    private boolean ValidatePassword(EditText password){
        String passwordInput = password.getText().toString();
        return isPasswordValid(passwordInput);
    }

    private boolean ValidateLogin(EditText login){
        String loginInput = login.getText().toString();
        return isLoginValid(loginInput);
    }

    private final View.OnClickListener onDropButtonClickListener = view ->
    {
        login_edit_text.setText("");
        email_edit_text.setText("");
        password_edit_text.setText("");
    };

    private final View.OnClickListener onConfirmButtonClickListener = view ->
    {
        if(
                login_edit_text.getText().toString().trim().equals("") ||
                        email_edit_text.getText().toString().trim().equals("") ||
                        password_edit_text.getText().toString().trim().equals("")
        ){
            Toast.makeText(this,"Не все поля заполнены",Toast.LENGTH_SHORT).show();
        }
        else {
            if(ValidateEmailAddress(email_edit_text)){

                email_error_text.setTextColor(Color.parseColor("#4BD327"));
                email_error_text.setText(R.string.email_true_message);
                List<String> list = Arrays.asList(getLogin(), getPassword(), getEmail());
                if (list.stream().filter((p) -> !p.isEmpty()).count() < MIN_COUNT)
                    Toast.makeText(getApplicationContext(), "Не хватает данных для добавления.", Toast.LENGTH_SHORT).show();
                else {
                    if(GetUserFromDB(list.get(0)).equals(list.get(0))){
                        Toast.makeText(register.this, "Пользователь с таким логином уже существует", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        CryptoUtil cryptoUtil = new CryptoUtil();
                        String secretKey = "liaten";
                        //String hash_password = AES.encrypt(list.get(1), secretKey);
                        String hash_password = null;
                        try {
                            hash_password = cryptoUtil.encrypt(secretKey, list.get(1));
                        } catch (NoSuchAlgorithmException
                                | InvalidKeySpecException
                                | UnsupportedEncodingException
                                | BadPaddingException
                                | InvalidKeyException
                                | InvalidAlgorithmParameterException
                                | NoSuchPaddingException
                                | IllegalBlockSizeException e) {
                            e.printStackTrace();
                        }
                        db.addUser(list.get(0), hash_password, list.get(2)); // 0 - логин, 1 - пароль, 2 - почта
                        senEmail();
                        Toast.makeText(register.this, "Проверьте ваш email", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
            else {
                email_error_text.setTextColor(Color.parseColor("#F44336"));
                email_error_text.setText(R.string.email_error_message);
            }

        }
    };

    private void senEmail() {
        String mEmail = email_edit_text.getText().toString();
        String mSubject = "Оповещение";
        String mMessage = "Ваш логин для входа в приложение: "
                + login_edit_text.getText().toString()
                + "\nВаш email для входа в приложение: " + email_edit_text.getText().toString()
                + "\nВаш пароль для входа в приложение: " + password_edit_text.getText().toString()
                + "\nИспользуйте только один вариант: логин в окне авторизации. Приятного пользования программой!";
        MailJava javaMailAPI = new MailJava(this, mEmail, mSubject, mMessage);
        javaMailAPI.execute();
    }

    private String getLogin() {
        if (login_edit_text.getText().toString().trim().length() == 0) return "";
        else return login_edit_text.getText().toString();
    }

    private String getPassword() {
        if (password_edit_text.getText().toString().trim().length() == 0) return "";
        else return password_edit_text.getText().toString();
    }

    private String getEmail() {
        if (email_edit_text.getText().toString().trim().length() == 0) return "";
        else return email_edit_text.getText().toString();
    }

}