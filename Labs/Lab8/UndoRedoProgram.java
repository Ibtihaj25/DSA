import java.util.Scanner;
import java.util.Stack;

public class UndoRedoProgram {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    
    public void insert(String action) {
        undoStack.push(action);
        redoStack.clear();
        System.out.println("Inserted: " + action);
    }

  
    public void undo() {
        if (!undoStack.isEmpty()) {
            String action = undoStack.pop();
            redoStack.push(action);
            System.out.println("Undo: " + action);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

   
    public void redo() {
        if (!redoStack.isEmpty()) {
            String action = redoStack.pop();
            undoStack.push(action);
            System.out.println("Redo: " + action);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

   
    public void displayStack() {
        System.out.println("Current Stack (Undo operations): " + undoStack);
    }

   
    public static void main(String[] args) {
        UndoRedoProgram program = new UndoRedoProgram();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Please enter your choice: (1 for insert, 2 for undo, 3 for redo, 4 display stack, 0 to exit)");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter action to insert: ");
                    String action = scanner.nextLine();
                    program.insert(action);
                    break;
                case 2:
                    program.undo();
                    break;
                case 3:
                    program.redo();
                    break;
                case 4:
                    program.displayStack();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
