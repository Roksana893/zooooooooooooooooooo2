public class Snake extends Reptile {
    public Snake(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " шипит: Шшшшшш!");
    }

    @Override
    public void feed() {
        System.out.println(name + " ест грызунов");
    }

    // Специфический метод для змей
    public void shedSkin() {
        System.out.println(name + " сбрасывает кожу");
    }
}