/*
 * 
 */
public class Clock
{
    int hours;
    int minutes;
    int seconds;
    
    public Clock()
    {
    }
    
    public Clock(int hours)
    {
        this.hours = hours;
    }
    
    public Clock(int hours, int minutes)
    {
        this.hours = hours;
        this.minutes = minutes;
        
        if(this.minutes == 60)
            {
                this.minutes = 0;
                this.hours = this.hours + 1;
            }
    }
    
    public Clock(int hours, int minutes, int seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        
        if(this.seconds == 60)
        {
            this.seconds = 0;
            this.minutes = this.minutes + 1;
            
            if(this.minutes == 60)
            {
                this.minutes = 0;
                this.hours = this.hours + 1;
            }
        }
    }
    
    public void setHours(int hours)
    {
        this.hours = hours;
    }
    
    public void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }
    
    public void setSeconds(int seconds)
    {
        this.seconds = seconds;
    }
    
    public int getHours()
    {
        return hours;
    }
    
    public int getMinutes()
    {
        return minutes;
    }
    
    public int getSeconds()
    {
        return seconds;
    }
    
    public void increaseSecondsByOne()
    {
        seconds = seconds + 1;
        
        if(seconds == 60)
        {
            seconds = 0;
            minutes = minutes + 1;
            
            if(minutes == 60)
            {
                minutes = 0;
                hours = hours + 1;
                
                if(hours == 24)
                    hours = 0;
            }
        }
    }
    
    public int compareClocks(Clock anotherClock)
    {
        int result = 0, thisTime = 0, anotherClockTime = 0;

        final int LATE = -1;        
        final int EQUAL = 0;
        final int AHEAD = 1;
        
        thisTime = this.getHours() * 3600 + this.getMinutes() * 60 + this.getSeconds();
        anotherClockTime = anotherClock.getHours() * 3600 + anotherClock.getMinutes() * 60 + anotherClock.getSeconds();        
        
        if(thisTime < anotherClockTime)
            result = LATE;
        else if(thisTime == anotherClockTime)
            result = EQUAL;
        else if(thisTime > anotherClockTime)
            result = AHEAD;
        
        return result;
    }
    
    /* TEACHER ANSWERS */
}
