package clock;

/**
 *
 * @author Denmar Ermitano
 */
public class Clock {
    private int hr;
    private int mi;
    private int se;

    /**
     * Default constructor
     */
    public Clock() {
        this.hr = 0;
        this.mi = 0;
        this.se = 0;
    }
    
    /**
     * Constructor with all data members
     * @param hr the hour of the time
     * @param mi the minute of the time
     * @param se the second of the time
     */
    public Clock(int hr, int mi, int se) {
        this.hr = hr;
        this.mi = mi;
        this.se = se;
    }
    
    /**
     * Copy constructor
     * @param clock 
     */
    public Clock(Clock clock) {
        this.hr = clock.hr;
        this.mi = clock.mi;
        this.se = clock.se;
    }
    
    /**
     * To increase the seconds counter by one (1)
     */
    public void increaseSe() {
        se++;
        if (se == 60) {
            se = 0;
            increaseMi();
        }
    }
    
    /**
     * To increase the minutes counter by one (1)
     */
    public void increaseMi() {
        mi++;
        if (mi == 60) {
            mi = 0;
            increaseHr();
        }
    }
    
    /**
     * To increase the hours counter by one (1)
     */
    public void increaseHr() {
        hr = (hr + 1) % 24; 
    }
    
    /**
     * To compare two clocks
     * @param clock the clock to compare
     * @return true if the clocks are the same, false if they are different
     */
    public boolean equals(Clock clock) {
        return this.hr == clock.hr &&
                this.mi == clock.mi &&
                this.se == clock.se;
    }
    
    /**
     * To generate a string representing a clock
     * @return the string representing a clock
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d\n", hr, mi, se);
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getMi() {
        return mi;
    }

    public void setMi(int mi) {
        this.mi = mi;
    }

    public int getSe() {
        return se;
    }

    public void setSe(int se) {
        this.se = se;
    }
}
