package sblib.bobsun.sblibtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sblib.bobsun.sblib.views.Injection;
import sblib.bobsun.sblib.views.annotations.InjectClickListener;
import sblib.bobsun.sblib.views.annotations.InjectView;

/**
 * Created by bobsun on 15-7-7.
 */
public class TextFragment extends Fragment {
    @InjectView(R.id.id_textview_fragment_test)
    public TextView textView;
    @InjectClickListener(R.id.id_textview_fragment_test)
    public void onClick(View view){
        textView.setText("Why not Zoidberg?");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstantSate){
        View ret = inflater.inflate(R.layout.fragment_test,parent,false);
        Injection.init(this,ret);
        textView.setText("Need a friend?");
        return ret;
    }
}
