package ru.job4j.aquarium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Class Aquarium.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.10.2017
 */
public class Aquarium {

    /**
     * This field contains all fishes.
     */
    private Map<Integer, Fish> aquarium = new HashMap();

    /**
     * The id of the fish.
     */
    private int id = 3;

    /**
     * The count male fish.
     */
    private int countMaleFish = 1;

    /**
     * The count female fish.
     */
    private int countFemaleFish = 1;

    /**
     * Init.
     */
    public void init() {
        addFirsTwoFish();
        while (true) {
            addNewFish();
            meetingFish();
            deleteFish();
            System.out.println(String.format("Популяция аквариума на момент %s составляет %s особей.",
                    new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(new Date()),
                    this.aquarium.size()));
        }
    }

    /**
     * This method adds firs two fishes.
     */
    private void addFirsTwoFish() {
        Fish fish1 = new Fish((String.format("%s", 1)));
        boolean sign = false;
        Fish fish2 = new Fish((String.format("%s", 2)));
        while (!sign) {
            if (fish1.getGender() != fish2.getGender()) {
                sign = true;
            } else {
                fish2 = new Fish((String.format("%s", 2)));
            }
        }
        this.aquarium.put(1, fish1);
        this.aquarium.put(2, fish2);
    }

    /**
     * This method adds the new fish.
     */
    private void addNewFish() {
        this.aquarium.put(this.id, new Fish(String.format("%s", this.id)));
        System.out.println(String.format("Родилась рыбка №%s", this.id));
        if (this.aquarium.get(this.id).getGender() == Fish.Gender.MALE) {
            this.countMaleFish++;
        } else {
            this.countFemaleFish++;
        }
        this.id++;
    }

    /**
     * This method removes the new fish.
     */
    private void deleteFish() {
        Iterator<Integer> iterator = this.aquarium.keySet().iterator();
        Integer next = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (this.aquarium.get(next).getLifeCycle() <= System.currentTimeMillis() / 1000) {
                System.out.println(String.format("Умерла рыбка №%s", next));
                if (this.aquarium.get(next).getGender() == Fish.Gender.MALE) {
                    this.countMaleFish--;
                } else {
                    this.countFemaleFish--;
                }
                iterator.remove();
            }
        }
    }

    /**
     * This method descriptions the meting two fishes.
     */
    private void meetingFish() {
        if (this.countFemaleFish != 0 && this.countMaleFish != 0) {
            Fish fish1 = this.aquarium.get(new Random().nextInt(this.id) + 1);
            Fish fish2 = this.aquarium.get(new Random().nextInt(this.id) + 1);
            boolean sign = false;
            while (!sign) {
                if (fish1 != null && fish2 != null && fish1.meet(fish2)) {
                    sign = true;
                } else {
                    fish1 = this.aquarium.get(new Random().nextInt(this.id) + 1);
                    fish2 = this.aquarium.get(new Random().nextInt(this.id) + 1);
                }
            }
            System.out.println(String.format("Встретились рыбки №%s и  №%s", fish1.getName(), fish2.getName()));
        }
    }
}