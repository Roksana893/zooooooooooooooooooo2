public class Veterinarian implements Staff {
// Инкапсуляция - приватные поля
private String name;
private String licenseNumber;
private double salary;
private int yearsOfExperience;

public Veterinarian(String name, String licenseNumber, double salary, int yearsOfExperience) {
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
        System.out.println("Ветеринар " + name + " осматривает " + animal.getClass().getSimpleName() + " " + ((Vertebrate)animal).getName());

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
        ((Vertebrate)animal).setHealthy(true);
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
