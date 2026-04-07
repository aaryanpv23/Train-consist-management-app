import java.util.*;

public class TrainApp {

    // Coach structure (using static inner class to keep single file)
    static class Coach {
        String coachId;
        String type;

        Coach(String coachId, String type) {
            this.coachId = coachId;
            this.type = type;
        }

        public String toString() {
            return coachId + " (" + type + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Coach> coaches = new LinkedList<>();
        HashSet<String> coachIds = new HashSet<>();

        while (true) {
            System.out.println("\n===== Train Consist Management =====");
            System.out.println("1. Add Coach");
            System.out.println("2. Add Coach at Position");
            System.out.println("3. Remove Coach");
            System.out.println("4. Move Coach");
            System.out.println("5. Display Train");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // Add coach at end
                case 1:
                    System.out.print("Enter Coach ID: ");
                    String id = sc.next();
                    System.out.print("Enter Type: ");
                    String type = sc.next();

                    if (coachIds.contains(id)) {
                        System.out.println("❌ Duplicate coach not allowed!");
                        break;
                    }

                    coaches.add(new Coach(id, type));
                    coachIds.add(id);
                    System.out.println("✅ Coach added");
                    break;

                // Add coach at position
                case 2:
                    System.out.print("Enter Coach ID: ");
                    id = sc.next();
                    System.out.print("Enter Type: ");
                    type = sc.next();
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();

                    if (coachIds.contains(id)) {
                        System.out.println("❌ Duplicate coach not allowed!");
                        break;
                    }

                    if (pos < 0 || pos > coaches.size()) {
                        System.out.println("❌ Invalid position!");
                        break;
                    }

                    coaches.add(pos, new Coach(id, type));
                    coachIds.add(id);
                    System.out.println("✅ Coach inserted");
                    break;

                // Remove coach
                case 3:
                    System.out.print("Enter Coach ID to remove: ");
                    id = sc.next();

                    boolean removed = false;
                    Iterator<Coach> it = coaches.iterator();

                    while (it.hasNext()) {
                        Coach c = it.next();
                        if (c.coachId.equals(id)) {
                            it.remove();
                            coachIds.remove(id);
                            removed = true;
                            System.out.println("🗑 Coach removed");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("❌ Coach not found!");
                    }
                    break;

                // Move coach
                case 4:
                    System.out.print("Enter Coach ID: ");
                    id = sc.next();
                    System.out.print("Enter New Position: ");
                    pos = sc.nextInt();

                    Coach target = null;

                    for (Coach c : coaches) {
                        if (c.coachId.equals(id)) {
                            target = c;
                            break;
                        }
                    }

                    if (target == null) {
                        System.out.println("❌ Coach not found!");
                        break;
                    }

                    if (pos < 0 || pos >= coaches.size()) {
                        System.out.println("❌ Invalid position!");
                        break;
                    }

                    coaches.remove(target);
                    coaches.add(pos, target);

                    System.out.println("🔄 Coach moved");
                    break;

                // Display train
                case 5:
                    if (coaches.isEmpty()) {
                        System.out.println("🚫 Train is empty");
                    } else {
                        System.out.println("\n🚆 Train Composition:");
                        for (int i = 0; i < coaches.size(); i++) {
                            System.out.println(i + " -> " + coaches.get(i));
                        }
                    }
                    break;

                case 6:
                    System.out.println("👋 Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}