package wm.list;

import java.util.ArrayList;

import wm.list.model.Animal;

/**
 * Created by Administrator on 2017/10/29.
 */

public class AnimalData {

    private static AnimalData Instance;

    public ArrayList<Animal> animalList;

    public static AnimalData getInstance()
    {
        if(Instance==null)
        {
            Instance = new AnimalData();
        }
        return Instance;
    }
}
