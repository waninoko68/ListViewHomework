package wm.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import wm.list.adapter.AnimalListAdapter;
import wm.list.model.Animal;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    //private ArrayList<Animal> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list_view);

        final AnimalData animalData = AnimalData.getInstance();
        animalData.animalList = new ArrayList<>();

        animalData.animalList.add(new Animal("Cat",R.drawable.animals_cat,"แมว",getString(R.string.details_cat)));
        animalData.animalList.add(new Animal("Dog",R.drawable.animals_dog,"หมา",getString(R.string.details_dog)));
        animalData.animalList.add(new Animal("Dolphin",R.drawable.animals_dolphin,"โลมา",getString(R.string.details_dolphin)));
        animalData.animalList.add(new Animal("Koala",R.drawable.animals_koala,"โคอาล่า",getString(R.string.details_koala)));
        animalData.animalList.add(new Animal("Lion",R.drawable.animals_lion,"สิงโต",getString(R.string.details_lion)));
        animalData.animalList.add(new Animal("Owl",R.drawable.animals_owl,"นกฮูก",getString(R.string.details_owl)));
        animalData.animalList.add(new Animal("Penguin",R.drawable.animals_penguin,"เพนกวิน",getString(R.string.details_penguin)));
        animalData.animalList.add(new Animal("Pig",R.drawable.animals_pig,"หมู",getString(R.string.details_pig)));
        animalData.animalList.add(new Animal("Rabbit",R.drawable.animals_rabbit,"กระต่าย",getString(R.string.details_rabbit)));
        animalData.animalList.add(new Animal("Tiger",R.drawable.animals_tiger,"เสือ",getString(R.string.details_tiger)));

        AnimalListAdapter adapter = new AnimalListAdapter(this, R.layout.item, animalData.animalList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = animalData.animalList.get(i);
                Toast.makeText(MainActivity.this,animal.thaiName+" ("+animal.name+")",Toast.LENGTH_SHORT).show();
                Intent in = new Intent(MainActivity.this,AnimalDetailsActivity.class);
                //in.putExtra("name",animal.name);
                //in.putExtra("pic",animal.pic);
                in.putExtra("position",i);
                startActivity(in);
            }
        });


    }
}
