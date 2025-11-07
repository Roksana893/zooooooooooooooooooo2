import java.util.ArrayList;
import java.util.List;

public class Zoo {
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