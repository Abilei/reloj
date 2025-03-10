
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Reloj12con24
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public Reloj12con24()
    {
        hours = new NumberDisplay(0,24);
        minutes = new NumberDisplay(1,60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public Reloj12con24(int hour, int minute)
    {
        hours = new NumberDisplay(0,24);
        minutes = new NumberDisplay(1,60);
        setTime(hour, minute);
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
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
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
     */
    private void updateDisplay()
    {
        if(hours.getValue() < 12){
            //casos am
            if(hours.getValue() == 0){
            displayString = "12" + ":" + 
                        minutes.getDisplayValue() + "am";
            }
            else{
                displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + "am";
            }
        }
        else{
            //casos pm
            if(hours.getValue()==12){
                displayString = "12" + ":" + 
                        minutes.getDisplayValue() + "pm";
            }
            else {
                int horaActual= hours.getValue()-12;
                if (horaActual < 10){
                    displayString = "0" + ":" + 
                        minutes.getDisplayValue() + "pm";
                }
                else {
                    displayString = horaActual + ":" + 
                        minutes.getDisplayValue() + "pm";
                }
            }
        }
    }
}
