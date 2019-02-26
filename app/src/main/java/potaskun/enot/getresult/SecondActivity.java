package potaskun.enot.getresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //get data from first activity
        Bundle extras =getIntent().getExtras();

        if(extras != null){
            TextView strBox = findViewById(R.id.stringBox);
            String str = extras.getString(FirstActivity.STR_KEY);
            strBox.setText("String: " + str);
        }
    }

    public void onButton1Click(View view) {
        sendMessage("Доступ разрешен");
    }

    public void onButton2Click(View view) {
        sendMessage("Доступ запрещен");
    }

    public void onButton3Click(View view) {
        sendMessage("недопустимая строка");
    }

    public void onCancelClick(View view) {
        setResult(RESULT_CANCELED); //if is push button of canceled, return result 0
        finish(); // end finish this activity
    }

    private void sendMessage(String message) {
        Intent data = new Intent();
        data.putExtra(FirstActivity.ACCESS_MESSAGE, message);
        setResult(RESULT_OK, data); //Для возврата результата
        finish();//уничтожит текущую activity
    }
}
