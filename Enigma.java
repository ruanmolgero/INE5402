public class Enigma
{
    public String codeString(String string, CodificationTable ct)
    {
        String codedString;
        char[] stringArray = string.toCharArray();
        char[] codedStringArray = new char[stringArray.length];
        boolean ableToCode = true;
        
        int i = 0;
        int position;

        while(ableToCode == true && i < stringArray.length)
        {
            position = ct.getOriginalCharPosition(stringArray[i]);
            
            if(position == -1)
                ableToCode = false;
            else
            {
                codedStringArray[i] = ct.getCodedCharValue(position);
                i++;
            }
        }
        
        if(ableToCode == true)
            codedString = new String(codedStringArray);
        else
            codedString = null;
        
        return codedString;
    }
    
    public String decodString(String string, CodificationTable ct)
    {
        String decodedString;
        char[] stringArray = string.toCharArray();
        char[] decodedStringArray = new char[stringArray.length];
        boolean ableToDecode = true;
        
        int i = 0;
        int position;
        
        while(ableToDecode == true && i < stringArray.length)
        {
            position = ct.getCodedCharPosition(stringArray[i]);
            
            if(position == -1)
                ableToDecode = false;
            else
            {
                decodedStringArray[i] = ct.getOriginalCharValue(position);
                i++;
            }
        }
        
        if(ableToDecode)
            decodedString = new String(decodedStringArray);
        else
            decodedString = null;
        
        return decodedString;
    }
}
