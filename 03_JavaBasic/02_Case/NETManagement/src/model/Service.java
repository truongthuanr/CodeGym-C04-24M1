package model;

import data.ServiceConfigIO;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Service {
    private int deviceid;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    float unitprice;
    float totalprice;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public Service(int deviceid,
                   LocalDateTime starttime,
                   LocalDateTime endtime,
                   float unitprice,
                   float totalprice) {
        this.deviceid = deviceid;
        this.starttime = starttime;
        this.endtime = endtime;
        this.unitprice = unitprice;
        this.totalprice = totalprice;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    public int getDeviceid() {
        return this.deviceid;
    }

    public void calTotalPrice() {
        int timeused = (int) (Duration.between(this.starttime, this.endtime).getSeconds()/60);
        totalprice = this.unitprice * timeused;
        System.out.println("Thời gian sử dụng: "+ timeused + "phút, Thành tiền: " + totalprice + "k VND");
    }


    public String toCsvString(){
        String starttimeString = starttime.format(formatter);
        String endtimeString = null;
        if (endtime != null) {
            endtimeString = endtime.format(formatter);
        }

        return deviceid+","+starttimeString+","+endtimeString+','+unitprice+","+totalprice;
    }
}
