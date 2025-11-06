import java.util.*;

// 1. ИНТЕРФЕЙС Animal (по требованию задания)
interface Animal {
    void makeSound();
    void feed();
}

// 2. АБСТРАКТНЫЙ КЛАСС Vertebrate (по требованию задания)
abstract class Позвоночный implements Animal {
    protected String name;
    protected int age;
    protected double weight;
    protected boolean isHealthy;

    public Позвоночный(String name, int age, double weight) {
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

// 3. АБСТРАКТНЫЙ КЛАСС Reptile (по требованию задания)
abstract class Reptile extends Позвоночный {
    public Reptile(String name, int age, double weight) {
        super(name, age, weight);
    }

    // Специфический метод для рептилий
    public void baskInSun() {
        System.out.println(name + " греется на солнце");
    }
}

// 4. КОНКРЕТНЫЕ КЛАССЫ ЖИВОТНЫХ
class Lion extends Позвоночный {
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

class Elephant extends Позвоночный {
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

class Snake extends Reptile {
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

// 5. ИНТЕРФЕЙС СОТРУДНИКА (по требованию задания)
interface Staff {
    void work();
    void cleanEnclosure(Enclosure enclosure);
}

// 6. КЛАСС ВЕТЕРИНАРА (Инкапсуляция & Полиморфизм)
class Ветеринар implements Staff {
    // Инкапсуляция - приватные поля
    private String name;
    private String licenseNumber;
    private double salary;
    private int yearsOfExperience;

    public Ветеринар(String name, String licenseNumber, double salary, int yearsOfExperience) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void work() {
        System.out.println("Ветеринар " + name + " проводит осмотр животных");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println("Ветеринар " + name + " помогает с уборкой вольера '" + enclosure.getName() + "'");
    }

    // Метод осмотретьЖивотное - демонстрирует полиморфизм
    public void examineAnimal(Animal animal) {
        System.out.println("Ветеринар " + name + " осматривает " + animal.getClass().getSimpleName() + " " + ((Позвоночный)animal).getName());

        // Полиморфное поведение - разный осмотр для разных животных
        if (animal instanceof Lion) {
            System.out.println("  - Проверяет зубы и гриву");
            System.out.println("  - Измеряет температуру");
        } else if (animal instanceof Elephant) {
            System.out.println("  - Проверяет бивни и хобот");
            System.out.println("  - Измеряет давление");
        } else if (animal instanceof Snake) {
            System.out.println("  - Проверяет кожу и глаза");
            System.out.println("  - Измеряет длину");
        }

        // Общая логика для всех животных
        ((Позвоночный)animal).setHealthy(true);
        System.out.println("  - Животное здорово!");
    }

    // Инкапсуляция - геттеры
    public String getName() { return name; }
    public String getLicenseNumber() { return licenseNumber; }
    public double getSalary() { return salary; }
    public int getYearsOfExperience() { return yearsOfExperience; }

    // Инкапсуляция - сеттеры с валидацией
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Ошибка: зарплата должна быть положительной");
        }
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience >= 0) {
            this.yearsOfExperience = yearsOfExperience;
        }
    }
}

// 7. КЛАСС СМОТРИТЕЛЯ (Полиморфизм)
class Zookeeper implements Staff {
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
            System.out.println("  - " + ((Позвоночный)animal).getName() + " активен и в хорошем состоянии");
        }
    }

    // Инкапсуляция - геттеры
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public double getSalary() { return salary; }
}

// 8. КЛАСС ENCLOSURE С ИНКАПСУЛЯЦИЕЙ
class Enclosure {
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
                ((Позвоночный)animal).getName() + " добавлен в вольер");
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        System.out.println(animal.getClass().getSimpleName() + " " +
                ((Позвоночный)animal).getName() + " удален из вольера");
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

// 9. КЛАСС ЗООПАРКА ДЛЯ УПРАВЛЕНИЯ
class Zoo {
    private List<Enclosure> enclosures;
    private List<Staff> staffMembers;

    public Zoo() {
        this.enclosures = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    public void addStaff(Staff staff) {
        staffMembers.add(staff);
    }

    public void demonstratePolymorphism() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА ПЕРСОНАЛА ===");

        // Полиморфизм: один интерфейс Staff - разные реализации
        for (Staff staff : staffMembers) {
            staff.work(); // Каждый сотрудник работает по-своему
        }
    }

    public List<Enclosure> getEnclosures() {
        return enclosures;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }
}

// ГЛАВНЫЙ КЛАСС
public class Main {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ЗООПАРКОМ ===\n");

        // Создание зоопарка
        Zoo zoo = new Zoo();

        // Создание вольеров
        Enclosure savanna = new Enclosure("Саванна", 500.0);
        Enclosure terrarium = new Enclosure("Террариум", 50.0);

        zoo.addEnclosure(savanna);
        zoo.addEnclosure(terrarium);

        // Создание и добавление животных (полиморфизм)
        Animal simba = new Lion("Симба", 5, 190.5);
        Animal dumbo = new Elephant("Дамбо", 10, 4500.0);
        Animal kaa = new Snake("Каа", 3, 15.5);

        savanna.addAnimal(simba);
        savanna.addAnimal(dumbo);
        terrarium.addAnimal(kaa);

        System.out.println();

        // Создание персонала
        Ветеринар vet = new Ветеринар("Доктор Иванов", "VET-12345", 75000, 8);
        Zookeeper keeper1 = new Zookeeper("Мария Петрова", "Хищники", 45000);
        Zookeeper keeper2 = new Zookeeper("Алексей Сидоров", "Рептилии", 42000);

        zoo.addStaff(vet);
        zoo.addStaff(keeper1);
        zoo.addStaff(keeper2);

        // Отображение информации о вольерах
        savanna.displayAnimals();
        System.out.println();
        terrarium.displayAnimals();

        System.out.println("\n4. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА ЖИВОТНЫХ:");
        System.out.println("Один и тот же код (animal.makeSound()) для разных животных:");
        simba.makeSound();
        dumbo.makeSound();
        kaa.makeSound();

        System.out.println();
        savanna.makeAllSounds();
        System.out.println();
        terrarium.makeAllSounds();

        System.out.println("\n5. КОРМЛЕНИЕ ЖИВОТНЫХ СМОТРИТЕЛЕМ:");
        keeper1.feedAnimalsInEnclosure(savanna);
        System.out.println();
        keeper2.feedAnimalsInEnclosure(terrarium);

        System.out.println("\n6. РАБОТА ВЕТЕРИНАРА:");
        vet.examineAnimal(simba);
        vet.examineAnimal(dumbo);
        vet.examineAnimal(kaa);

        System.out.println("\n7. УБОРКА ВОЛЬЕРОВ:");
        keeper1.cleanEnclosure(savanna);
        keeper2.cleanEnclosure(terrarium);
        vet.cleanEnclosure(savanna); // Ветеринар тоже может помочь с уборкой

        System.out.println("\n8. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА ПЕРСОНАЛА:");
        zoo.demonstratePolymorphism();

        System.out.println("\n9. НАБЛЮДЕНИЕ ЗА ЖИВОТНЫМИ:");
        keeper1.monitorAnimals(savanna);
        keeper2.monitorAnimals(terrarium);

        System.out.println("\n10. ИНКАПСУЛЯЦИЯ ДАННЫХ ПЕРСОНАЛА:");
        System.out.println("Ветеринар " + vet.getName() + ", лицензия: " + vet.getLicenseNumber());
        System.out.println("Смотритель " + keeper1.getName() + ", специализация: " + keeper1.getSpecialization());

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
    }
}