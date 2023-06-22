package com.example.mockupexam;

import java.util.ArrayList;

public class AnimalList {

    private ArrayList<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public Animal getAnimal (String name) {
        for (Animal a : animalList) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

}
