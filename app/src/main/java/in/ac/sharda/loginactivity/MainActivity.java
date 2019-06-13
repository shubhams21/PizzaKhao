package in.ac.sharda.loginactivity;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import in.ac.sharda.productlistactivity.ProductListActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUserName, textPassword;
    private Button btnSubmit;
    private TextView info;
    private int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = (EditText)findViewById(R.id.editTextUserName);
        textPassword = (EditText)findViewById(R.id.editTextUserPassword);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        info=(TextView) findViewById(R.id.info);

        info.setText("No. of attempts remaining : 5");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(editTextUserName.getText().toString(),textPassword.getText().toString());
            }
        });

    }
    public void openProductListActivity() {
        Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
        startActivity(intent);
    }
    public void validate(String userName, String userPassword) {
        if ((userName.equals("Shubham")) && (userPassword.equals("1234"))) {
            openProductListActivity();
        }
        else {
            counter --;

            info.setText("No. of attempta remaining: "+ counter);
        }
    }
}