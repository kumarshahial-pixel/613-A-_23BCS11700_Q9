import java.util.*;

class Entity {
    int id;
    String name;
    Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class HibernateSimulation {
    private Map<Integer, Entity> table = new HashMap<>();

    public void save(Entity e) {
        table.put(e.id, e);
        System.out.println("Saved: " + e.name);
    }

    public Entity read(int id) {
        return table.get(id);
    }

    public void update(int id, String newName) {
        Entity e = table.get(id);
        if (e != null) {
            e.name = newName;
            System.out.println("Updated: " + newName);
        }
    }

    public void delete(int id) {
        table.remove(id);
        System.out.println("Deleted record with ID: " + id);
    }

    public void showAll() {
        for (Entity e : table.values()) {
            System.out.println(e.id + " -> " + e.name);
        }
    }
}

public class PartB_HibernateCRUD {
    public static void main(String[] args) {
        HibernateSimulation h = new HibernateSimulation();
        h.save(new Entity(1, "Sumit"));
        h.save(new Entity(2, "Arpit"));
        h.update(2, "Arpit Jha");
        System.out.println("Reading ID 1: " + h.read(1).name);
        h.delete(1);
        h.showAll();
    }
}
