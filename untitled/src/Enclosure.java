import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private String name;
    private double area;
    private List<Animal> animals; // Инкапсуляция - приватное поле
    private boolean needsCleaning;

    public Enclosure(String name, double area) {
        this.name = name;
        this.area = area;
        this.animals = new ArrayList<>();
        this.needsCleaning = false;
    }

    // Контролируемый доступ к списку животных (инкапсуляция)
    public void addAnimal(Animal animal) {
        animals.add(animal);
        needsCleaning = true;
        System.out.println(animal.getClass().getSimpleName() + " " +
                ((Vertebrate)animal).getName() + " добавлен в вольер");
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        System.out.println(animal.getClass().getSimpleName() + " " +
                ((Vertebrate)animal).getName() + " удален из вольера");
    }

    // Геттер для доступа к животным (инкапсуляция)
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals); // Возвращаем копию для защиты данных
    }

    public void displayAnimals() {
        System.out.println("Вольер '" + name + "' (площадь: " + area + " м²):");
        for (Animal animal : animals) {
            System.out.println("  - " + animal);
        }
    }

    public void makeAllSounds() {
        System.out.println("Все животные в вольере '" + name + "' издают звуки:");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    public void setNeedsCleaning(boolean needsCleaning) {
        this.needsCleaning = needsCleaning;
    }

    public boolean needsCleaning() {
        return needsCleaning;
    }

    // Геттеры
    public String getName() { return name; }
    public double getArea() { return area; }
}