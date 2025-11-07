
public class Elephant extends Vertebrate {
        public Elephant(String name, int age, double weight) {
            super(name, age, weight);
        }

        @Override
        public void makeSound() {
            System.out.println(name + " трубит: ТУУУУУУ!");
        }

        @Override
        public void feed() {
            System.out.println(name + " ест фрукты и овощи");
        }

        // Специфический метод для слонов
        public void sprayWater() {
            System.out.println(name + " обливается водой");
        }
    }

