public class Zookeeper implements Staff {
    // Инкапсуляция - приватные поля
    private String name;
    private String specialization;
    private double salary;

    public Zookeeper(String name, String specialization, double salary) {
        this.name = name;
        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    public void work() {
        System.out.println("Смотритель " + name + " заботится о животных");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println("Смотритель " + name + " чистит вольер '" + enclosure.getName() + "'");
        System.out.println("  - Убирает отходы");
        System.out.println("  - Меняет воду");
        System.out.println("  - Проверяет безопасность");
    }

    // Метод кормитьЖивотныхВВольере - использует полиморфный метод feed()
    public void feedAnimalsInEnclosure(Enclosure enclosure) {
        System.out.println("Смотритель " + name + " кормит животных в вольере '" + enclosure.getName() + "':");

        // ПОЛИМОРФИЗМ: один метод для всех типов животных
        for (Animal animal : enclosure.getAnimals()) {
            animal.feed(); // Вызывается полиморфный метод feed()
        }
    }

    // Дополнительные методы смотрителя
    public void monitorAnimals(Enclosure enclosure) {
        System.out.println("Смотритель " + name + " наблюдает за животными в вольере '" + enclosure.getName() + "':");
        for (Animal animal : enclosure.getAnimals()) {
            System.out.println("  - " + ((Vertebrate)animal).getName() + " активен и в хорошем состоянии");
        }
    }

    // Инкапсуляция - геттеры
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public double getSalary() { return salary; }
}
