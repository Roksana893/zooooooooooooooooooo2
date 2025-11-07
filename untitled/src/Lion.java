public class Lion extends Vertebrate {
    public Lion(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " рычит: РРРРРР!");
    }

    @Override
    public void feed() {
        System.out.println(name + " ест мясо");
    }

    // Специфический метод для львов
    public void hunt() {
        System.out.println(name + " охотится");
    }
}
