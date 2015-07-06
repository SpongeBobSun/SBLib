package sblib.bobsun.sblibtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import sblib.bobsun.sblib.views.Injection;
import sblib.bobsun.sblib.views.annotations.InjectClickListener;
import sblib.bobsun.sblib.views.annotations.InjectView;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.id_textview)
    public TextView textView;

    @InjectClickListener(R.id.id_button)
    public void OnClick(View v){
        textView.setText("Fry is an idiot!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injection.init(this);
        textView.setText("Gooooood news everyone!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
