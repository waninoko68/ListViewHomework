package wm.list.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wm.list.R;
import wm.list.model.Animal;

/**
 * Created by Administrator on 2017/10/29.
 */

public class AnimalListAdapter extends ArrayAdapter<Animal>{

    private Context context;
    private ArrayList<Animal> animalList;
    private int layoutResId;

    public AnimalListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Animal> objects) {
        super(context, resource, objects);
        this.context = context;
        this.animalList = objects;
        this.layoutResId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(layoutResId,null);
        ImageView img = (ImageView) v.findViewById(R.id.image);
        TextView txt = (TextView) v.findViewById(R.id.text);
        TextView txtThai = (TextView) v.findViewById(R.id.textThai);

        Animal animal = animalList.get(position);
        img.setImageResource(animal.pic);
        txt.setText(" ("+animal.name+")");
        txtThai.setText(animal.thaiName);

        return v;
    }
}
