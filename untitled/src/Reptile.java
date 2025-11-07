abstract class Reptile extends Vertebrate {
    public Reptile(String name, int age, double weight) {
        super(name, age, weight);
    }

    // Специфический метод для рептилий
    public void baskInSun() {
        System.out.println(name + " греется на солнце");
    }
}