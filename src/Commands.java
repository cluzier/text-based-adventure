class Command
{
    // searches for first command word and second command word
    // example: go west

    private String firstWord;
    private String secondWord;

    public Command(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getFirstWord()
    {
        return firstWord;
    }
    public String getSecondWord()
    {
        return secondWord;
    }

    //if the command is unknown, return firstWord == null
    public boolean isUnknown()
    {
        return (firstWord == null);
    }
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

