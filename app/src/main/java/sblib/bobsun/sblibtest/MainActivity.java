package sblib.bobsun.sblibtest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import sblib.bobsun.sblib.widgets.SBSelecor;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SBSelecor selecor = (SBSelecor) findViewById(R.id.id_selector);
        ArrayList<ArrayList> data = new ArrayList<ArrayList>();

        ArrayList data1 = new ArrayList();
        data1.add("sssss");
        data1.add("sssss");
        data1.add("sssss");
        data1.add("sssss");

        ArrayList data2 = new ArrayList();
        data2.add("sssss");
        data.add(data1);
        data.add(data2);

        selecor.setData(data);
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
