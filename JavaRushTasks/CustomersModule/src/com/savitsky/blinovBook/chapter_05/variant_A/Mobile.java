package com.savitsky.blinovBook.chapter_05.variant_A;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esavitski on 17.04.2017.
 */
public class Mobile {
    private String manufacturer;
    private Model model;
    private List<Model> models = new ArrayList<>();

    public Mobile(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public final void addModel(String modelName, float screenSize, int ram, int storage){
        model = new Model(modelName, screenSize, ram, storage);
        models.add(model);
    }

    public void showAllMobiles(){
        if(models.size()>0){
            models.stream().forEach(m -> { System.out.println(m);});
        }
        else{
            System.out.println(String.format("No %s's models", manufacturer) );
        }
    }

    private class Model{
        private String modelName;
        private float screenSize;
        private int ram;
        private int storage;

        public Model(String modelName, float screenSize, int ram, int storage) {
            this.modelName = modelName;
            this.screenSize = screenSize;
            this.ram = ram;
            this.storage = storage;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "modelName='" + modelName + '\'' +
                    ", screenSize=" + screenSize +
                    ", ram=" + ram +
                    ", storage=" + storage +
                    '}';
        }

        @Override
        public int hashCode() {
            return 31 * ram + 17 * storage + (int)(100*screenSize) + (modelName!=null ? modelName.hashCode() : 0);
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(obj == null)
                return false;
            if(this.getClass() != obj.getClass())
                return false;
            Model model = (Model) obj;
            if(!this.modelName.equals(model.modelName))
                return false;
            if(this.screenSize != model.screenSize)
                return false;
            if(this.storage != model.storage)
                return false;
            if(this.ram != model.ram)
                return false;

            return true;
        }
    }
}
