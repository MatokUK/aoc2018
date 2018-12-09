package uk.matok.aoc2018;

import java.util.Date;

public class Day4Guard {
    private Boolean awake;
    private Integer id;
    private Date sleepFrom;
    private long sleepMinutes;
    private Integer sleepFromMinute;
    private Integer sleepToMinute;

    public Day4Guard(Integer id) {
        this.id = id;
        this.awake = true;
        this.sleepMinutes = 0;
    }

    public Integer getId()
    {
        return id;
    }

    public long getSleepMinutes()
    {
        return sleepMinutes;
    }

    public Integer getFrom()
    {
        return this.sleepFromMinute;
    }

    public Integer getTo()
    {
        return sleepToMinute;
    }

    public void asleep(Date date) {
        if (awake) {
            this.awake = false;
            this.sleepFrom = date;
            this.sleepFromMinute = this.sleepFrom.getMinutes();
        } else {
            System.out.println("Error! Already sleeping!");
        }
    }

    public void wakeUp(Date date) {
        if (!awake) {
            this.awake = true;
            this.sleepToMinute = date.getMinutes() - 1;
            this.sleepMinutes += (date.getTime() - this.sleepFrom.getTime())/60/1000;
        } else {
            System.out.println("Error! Not sleeping!");
        }
    }

    public String toString()
    {
        return "#" + id + " ---> " + sleepMinutes;
    }
}
