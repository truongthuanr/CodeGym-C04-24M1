package model;

import java.time.LocalDateTime;

public class Service {
    private int deviceid;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    float unitprice;
    float totalprice;


    public String toCsvString(){
        return deviceid+","+starttime+","+endtime+','+unitprice+","+totalprice;

    }
}
