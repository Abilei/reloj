
/**
 * Write a description of class ClockDisplayV12h here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplayV12h
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString; 
    private String mañanaOtarde;
    private boolean amOpm;
    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplayV12h()
    {
        hours = new NumberDisplay(0,13);
        minutes = new NumberDisplay(0,60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     * 
     */
    public ClockDisplayV12h(int hour, int minute, String  pm)
    {
        hours = new NumberDisplay(1,13);
        minutes = new NumberDisplay(0,60);
        setTime(hour, minute,pm);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        if ((hours.getValue()==12) && (minutes.getValue() == 00)){
            if(amOpm==false){
                amOpm=true;
                mañanaOtarde="am";
             }
            else{
                amOpm=false;
                mañanaOtarde="pm";
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     * pm boolean 
     * 1 a 12 
     * min 0 a 59 
     */
    public void setTime(int hour, int minute, String formato)//modificar
    {
        assert(formato=="am" || formato=="pm"); 
        assert(hour > 0 && hour <13);
        assert(minute >= 0 && minute < 60);
        hours.setValue(hour);
        minutes.setValue(minute);
        if(formato=="am"){
            amOpm=true;
        } else if(formato=="pm"){
            amOpm=false;
        }
        mañanaOtarde= formato;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    
    /**
     * Update the internal string that represents the display.
     * de 24 a 12
     */
    private void updateDisplay()//modificar
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue()+":"+ mañanaOtarde;
    }
}

