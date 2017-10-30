package wm.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import wm.list.model.Animal;

import static android.R.attr.name;

public class AnimalDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        ImageView animalImg = (ImageView) findViewById(R.id.animalImage);
        TextView nameTxt = (TextView) findViewById(R.id.animalTxt);

        Intent in = getIntent();
        int position = in.getIntExtra("position",0);

        AnimalData animalData = AnimalData.getInstance();
        Animal animal = animalData.animalList.get(position);

        nameTxt.setText(animal.detail);
        animalImg.setImageResource(animal.pic);

        getSupportActionBar().setTitle(animal.thaiName+" ("+animal.name+")");
    }
}
