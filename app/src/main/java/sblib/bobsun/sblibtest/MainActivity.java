package sblib.bobsun.sblibtest;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;

import sblib.bobsun.sblib.net.ConnectionBuilder;
import sblib.bobsun.sblib.net.NetworkOperation;
import sblib.bobsun.sblib.net.OnFinishHandler;
import sblib.bobsun.sblib.net.OperationResult;
import sblib.bobsun.sblib.views.Injection;
import sblib.bobsun.sblib.views.annotations.InjectClickListener;
import sblib.bobsun.sblib.views.annotations.InjectView;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.id_textview)
    public TextView textView;

    @InjectClickListener(R.id.id_button)
    public void OnClick(View v){
        textView.setText("Fry is an idiot!");
        //Unit test for network utilities.
        new NetworkOperation(new OnFinishHandler() {
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(MainActivity.this,""+msg.what,Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            public OperationResult doNetworkOperation() {
                OperationResult ret = new OperationResult();
                try {
                    String result = new ConnectionBuilder().setUrl("http://it-ebooks-api.info/v1/search/android/")
                            .getResponseFromConnection();
                    Log.e("result",result);
                    ret.setSuccess(true);
                    ret.setResultCode(1);
                } catch (IOException e) {
                    e.printStackTrace();
                    ret.setSuccess(false);
                    ret.setResultCode(-1);
                }
                return ret;
            }
        }.run();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injection.init(this, findViewById(R.id.id_linearlayout));
        textView.setText("Gooooood news everyone!");
        getSupportFragmentManager().beginTransaction().add(R.id.id_fragment_container,new TextFragment()).commit();
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
