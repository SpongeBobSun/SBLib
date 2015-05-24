package sblib.bobsun.sblib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import sblib.bobsun.sblib.R;

/**
 * Created by bobsun on 15-5-24.
 */
public class SBSelecor extends LinearLayout {

    private OnSelectListener onSelectListener;
    private LinearLayout.LayoutParams layoutParams;

    public SBSelecor(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(HORIZONTAL);
        layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.onSelectListener = onSelectListener;
    }

    public void setData(ArrayList<ArrayList> list){
        ListView addView;
        SBSelectorAdapter adapter;
        for (int i = 0; i < list.size(); i++){
            addView = new ListView(getContext());
            adapter = new SBSelectorAdapter(getContext(),android.R.layout.simple_list_item_1,list.get(i));
            addView.setAdapter(adapter);
            this.addView(addView,i,layoutParams);
        }

    }

    public interface OnSelectListener{
        void onSelect();
    }

    public class SBSelectorAdapter extends ArrayAdapter{

        public SBSelectorAdapter(Context context, int resource, ArrayList objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View ret = null;
            ret = LayoutInflater.from(getContext()).inflate(R.layout.sbselector_item,null);
            return ret;
        }
    }

    private class ViewHolder{

    }
}
