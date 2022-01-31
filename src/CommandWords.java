class CommandWords
{
    private static final String validCmds[] = {
        "go", "quit", "help", "health", "inventory"
    };

    public CommandWords() {

    }

    public boolean isCommand(String aString) {
        for(int i = 0; i < validCmds.length; i++)
        {
            if(validCmds[i].equals(aString))
                return true;
        }
        return false;
    }

    public void showAll() {
        for(int i = 0; i < validCmds.length; i++)
        {
            System.out.print(validCmds[i] + "  ");
        }
        System.out.println();
    }
}
