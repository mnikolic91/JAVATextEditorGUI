package commands;


public interface Command {
    void runCommand();
    void undoCommand();

}