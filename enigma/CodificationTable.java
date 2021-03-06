public class CodificationTable
{
    private char[] originalChar;
    private char[] codedChar;
    
    private int getCharPosition(char desiredChar, char[] desiredArray)
    {
        int position = -1;
        int i = 0;
        
        while(position == -1 && i < desiredArray.length)
            if(desiredArray[i] == desiredChar)
                position = i;
            else
                i++;
        
        return position;
    }

    public CodificationTable()
    {
        this.originalChar = new char[]{ 'a', 'b', 'c', '?', '8', 'e', 't' };        //test vectors
        this.codedChar = new char[]{ '9', 'J', '=', 'a', 'D', '*', '#' };
    }
    
    public CodificationTable(char[] originalChar, char[] codedChar)
    {
        this.originalChar = originalChar;
        this.codedChar = codedChar;
    }
    
    /*
    public int getOriginalCharPositionOld(char desiredChar)
    {
        int position = -1;
        int i = 0;
        
        while(position == -1 && i < originalChar.length)
            if(originalChar[i] == desiredChar)
                position = i;
            else
                i++;
        
        return position;
    }
    
    public int getCodedCharPositionOld(char desiredChar)
    {
        int position = -1;
        int i = 0;
        
        while(position == -1 && i < codedChar.length)
            if(codedChar[i] == desiredChar)
                position = i;
            else
                i++;
                
        return position;
    }
    */
    
    public int getOriginalCharPosition(char character)
    {
        return getCharPosition(character, originalChar);
    }
    
    public int getCodedCharPosition(char character)
    {
        return getCharPosition(character, codedChar);
    }
    
    public char getOriginalCharValue(int position)
    {
        return originalChar[position];
    }
    
    public char getCodedCharValue(int position)
    {
        return codedChar[position];
    }
    
    public boolean testCodification()
    {
        boolean test = false;
        
        if(originalChar.length == codedChar.length)
        {
            int i = 0;
            int j = i + 1;
            int size = originalChar.length;
            int sizeDec = originalChar.length - 1;
            test = true;
            
            while(test == true && i < sizeDec)
            {
                while(test == true && j < size)
                    if(originalChar[i] == originalChar[j] || codedChar[i] == codedChar[j])
                        test = false;
                    else
                        j++;
                i++;
            }
        }
        
        return test;
    }
}
