package id.ac.poliban.mi.aulia.latihan11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 100;
    private TextView tvResult;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //uji apakah requestCode==REQUEST_CODE && resultCode=Activity.RESULT_OK && data.getExtras()!= null
        assert data != null;
        if(requestCode==REQUEST_CODE && resultCode == Activity.RESULT_OK && data.getExtras() != null)
            tvResult.setText(String.format("Hi %s!", data.getStringExtra("subactivity")));
    }

    //konfirmasi close
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("close confirmation")
                .setTitle("close app")
                .setIcon(android.R.drawable.btn_star_big_on)
                .setCancelable(true)
                .setPositiveButton("YES",((dialog, which) -> super.onBackPressed()))
                .setPositiveButton("NO",null)
                .show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        Button btSend = findViewById(R.id.btSend);

        btSend.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivityForResult(intent,REQUEST_CODE);
        });


    }
}
