package android.lifeistech.com.testest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;

public class MemoAdapter extends ArrayAdapter<Memo> {

    public LayoutInflater layoutinflater;

    MemoAdapter(Context context, int textViewResourceId, List<Memo> objects){
        super(context,textViewResourceId,objects);
        layoutinflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        final Memo memo = getItem(position);
        if(convertView==null){
            convertView = layoutinflater.inflate(R.layout.layout_item_memo,null);
        }

        TextView titleText = (TextView)convertView.findViewById(R.id.titleText);
        CheckBox ch = convertView.findViewById(R.id.checkbox);
//        TextView contentText = (TextView)convertView.findViewById(R.id.contentText);
        titleText.setText(memo.title);
//        contentText.setText(memo.content);
        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //memo.check = isChecked;
            }
        });

        return convertView;

    }
}
