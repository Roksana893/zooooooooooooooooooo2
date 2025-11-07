import java.util.*;
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
        Veterinarian vet = new Veterinarian("Доктор Иванов", "VET-12345", 75000, 8);
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