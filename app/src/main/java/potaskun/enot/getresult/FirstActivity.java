package potaskun.enot.getresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    static final String STR_KEY = "STR";
    static final String ACCESS_MESSAGE = "ACCESS_MESSAGE";
    private static final int REQUEST_ACCESS_TYPE=1;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textView = findViewById(R.id.textResult);
    }

    public void onClick(View view) {
        //Получаем возврат
        EditText stringBox = findViewById(R.id.stringBox);
        String str = stringBox.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(STR_KEY, str);
        startActivityForResult(intent, REQUEST_ACCESS_TYPE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data ){
        if(requestCode == REQUEST_ACCESS_TYPE){
            if(resultCode == RESULT_OK){
                String accessMessage = data.getStringExtra(ACCESS_MESSAGE);
                textView.setText(accessMessage);
            }else{
                textView.setText("Ошибка доступа");
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
