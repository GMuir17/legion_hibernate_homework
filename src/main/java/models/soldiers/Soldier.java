package models.soldiers;

import javax.persistence.*;

@Entity
@Table(name = "soldiers")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "soldier_type")
public abstract class Soldier {

    private int id;
    private String name;
    private EquipmentType equipment;
    private int yearsOfService;

    public Soldier() {}

    public Soldier(String name, EquipmentType equipment, int yearsOfService) {
        this.name = name;
        this.equipment = equipment;
        this.yearsOfService = yearsOfService;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "equipment")
    public EquipmentType getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentType equipment) {
        this.equipment = equipment;
    }

    @Column(name = "years_of_service")
    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }
}
