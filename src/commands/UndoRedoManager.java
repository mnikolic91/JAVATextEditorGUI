package commands;

import java.util.Stack;

public class UndoRedoManager {

    private Command command;

    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void execute(Command command) {
        command.runCommand();
        undoStack.push(command);
        System.out.println("Undo Stack Size after execute: " + undoStack.size());
        redoStack.clear();
    }

    public void undo() {
        System.out.println("Undo operation triggered");
        if (!undoStack.isEmpty()) {
            command = undoStack.pop();
            command.undoCommand();
            redoStack.push(command);
            System.out.println("Command undone: " + command);
        } else {
            System.out.println("Undo stack is empty");
        }
        printStacksState();
    }

    private void printStacksState() {
        System.out.println("Undo Stack: " + stackToString(undoStack, "Undo Stack"));
        System.out.println("Redo Stack: " + stackToString(redoStack, "Redo Stack"));
    }


    public void redo() {
        if (!redoStack.isEmpty()) {
            command = redoStack.pop();
            command.runCommand();
            undoStack.push(command);
            System.out.println(printUndoStack());
        }
    }


    public String printUndoStack() {
        return stackToString(undoStack, "Undo Stack");
    }

    public String printRedoStack() {
        return stackToString(redoStack, "Redo Stack");
    }

    private String stackToString(Stack<Command> stack, String stackName) {
        System.out.println("Entering stackToString for " + stackName);
        StringBuilder sb = new StringBuilder(stackName + ": ");
        if (stack.isEmpty()) {
            sb.append("Empty");
        } else {
            for (Command command : stack) {
                sb.append("\n - ").append(command.toString());
            }
        }
        System.out.println("Stack contents: " + sb.toString());
        return sb.toString();
    }

}
