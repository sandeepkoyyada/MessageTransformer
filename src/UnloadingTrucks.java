import java.util.*;
import java.text.SimpleDateFormat;

public class UnloadingTrucks {
    public static Boolean canUnloadAll(Collection<UnloadingTime> unloadingTimes) {
        Boolean response = false;
        
		return response;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<UnloadingTime> unloadingTimes = new ArrayList<UnloadingTime>();
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 19:00"), sdf.parse("03/04/2019 20:30")));
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 22:10"), sdf.parse("03/04/2019 22:30")));
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 20:30"), sdf.parse("03/04/2019 22:00")));

        System.out.println(UnloadingTrucks.canUnloadAll(unloadingTimes));
    }
}

class UnloadingTime {
    private Date start, end;
    
    public UnloadingTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
}