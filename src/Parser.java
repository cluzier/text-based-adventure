import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Parser
{

    private UserCommands commands;

    public Parser()
    {
        commands = new UserCommands();
    }

    public Command getCommand() {
        String inputLine = "";
        String word1;
        String word2;

        System.out.print("> ");

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("An error occurred: "
                    + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();
        else
            word2 = null;

        if(commands.isCommand(word1))
            return new Command(word1, word2);
        else
            return new Command(null, word2);
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
