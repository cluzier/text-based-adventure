class UserCommands
{
    // commands the user has available throughout the game

    private static final String validCmds[] = {
            "go", "take", "use", "quit", "help", "health", "inventory", "damage"
    };

    public UserCommands()
    {

    }

    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCmds.length; i++)
        {
            if(validCmds[i].equals(aString))
                return true;
        }
        return false;
    }

    public void showAll()
    {
        for(int i = 0; i < validCmds.length; i++)
        {
            System.out.print(validCmds[i] + "  ");
        }
        System.out.println();
    }
}
