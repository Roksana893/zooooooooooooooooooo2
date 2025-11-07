
public abstract class Vertebrate implements Animal {
        protected String name;
        protected int age;
        protected double weight;
        protected boolean isHealthy;

        public Vertebrate (String name, int age, double weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.isHealthy = true;
        }

        // Общие методы для всех позвоночных
        public void sleep() {
            System.out.println(name + " спит");
        }

        public void move() {
            System.out.println(name + " двигается");
        }

        // Геттеры и сеттеры (инкапсуляция)
        public String getName() { return name; }
        public int getAge() { return age; }
        public double getWeight() { return weight; }
        public boolean isHealthy() { return isHealthy; }
        public void setHealthy(boolean healthy) { isHealthy = healthy; }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "{name='" + name + "', age=" + age + ", weight=" + weight + "}";
        }
    }

