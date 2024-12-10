import java.util.LinkedList;
import java.util.Scanner;

// Terminator class to store ID and priority
class TerminatorStorageSystem {
    private int terminatorId;
    private int terminatorPriority;

    public TerminatorStorageSystem(int terminatorId, int terminatorPriority) {
        this.terminatorId = terminatorId;
        this.terminatorPriority = terminatorPriority;
    }

    public int getTerminatorId() {
        return terminatorId;
    }

    public int getTerminatorPriority() {
        return terminatorPriority;
    }

    @Override
    public String toString() {
        return "Terminator{id=" + terminatorId + ", priority=" + terminatorPriority + "}";
    }
}

// Main class for managing the hangar system
public class TerminatorManagement {
    public static void main(String[] args) {
        LinkedList<TerminatorStorageSystem> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Terminator");
            System.out.println("2. Deploy Terminator");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Choose your option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Terminator
                    System.out.print("Terminator ID: ");
                    int terminatorId = scanner.nextInt();
                    System.out.print("Terminator Priority (0 for normal, >0 for high): ");
                    int terminatorPriority = scanner.nextInt();

                    TerminatorStorageSystem terminator = new TerminatorStorageSystem(terminatorId, terminatorPriority);
                    if (terminatorPriority > 0) {
                        queue.addFirst(terminator);
                        System.out.println("Priority Terminator " + terminatorId + " added to the front of the line.");
                    } else {
                        queue.addLast(terminator);
                        System.out.println("Terminator " + terminatorId + " added to the queue.");
                    }
                    break;

                case 2:
                    // Deploy Terminator
                    if (!queue.isEmpty()) {
                        TerminatorStorageSystem deployed = queue.removeFirst();
                        System.out.println("Deploying Terminator: " + deployed);
                    } else {
                        System.out.println("No Terminators available.");
                    }
                    break;

                case 3:
                    // Display Queue
                    if (!queue.isEmpty()) {
                        System.out.println("Current Queue: " + queue);
                    } else {
                        System.out.println("The queue is empty.");
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
