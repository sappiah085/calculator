package calculator.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    Calculator cal = new Calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.answer);
        text.setText("0");
    }

    public void input(View view) {
        Button button = (Button) findViewById(view.getId());
       cal.appendNumber(button.getText().toString());
        text.setText(cal.getResult());
    }
}