package model;


public class Device {
    private int id;
    private String name;
    private deviceType type;
    private deviceStatus status;



    public enum deviceType{
        ECO(1), STANDARD(2), VIP(3), PREMIUM(4) ;

        public int value;
        deviceType(int value){
            this.value = value;
        }
        public static deviceType getDeviceType(int value){
            for(deviceType dt : deviceType.values()){
                if(dt.value == value){
                    return dt;
                }
            }
            return null;
        }
    }

    public enum deviceStatus{
        INIT(1), OFFLINE(2), ONLINE(3), OCCUPIED(4), MAINTENANCE(5);

        public int value;

        deviceStatus(int value) {
            this.value = value;
        }
        public static deviceStatus getDeviceStatus(int value){
            for(deviceStatus dt : deviceStatus.values()){
                if(dt.value == value){
                    return dt;
                }
            }
            return null;
        }
    }






    public Device(int id, String name ,deviceType type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = deviceStatus.INIT;


    }

    public Device(int id, String name , int type, int status) {
        this.id = id;
        this.name = name;
        this.type = deviceType.getDeviceType(type);
        this.status = deviceStatus.getDeviceStatus(status);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {return this.name;}

    public deviceType getType() {
        return this.type;
    }

    public void setType(deviceType type) {
        this.type = type;
    }

    public deviceStatus getStatus() {
        return this.status;
    }


    public void setStatus(deviceStatus status) {
        this.status = status;
    }

    public String toCsvString(){
        return id + "," + name + "," + type.value + "," + status.value;

    }

    @Override
    public String toString() {
//        return "Device [id=" + this.id + ", type=" + this.type + ", status=" + this.status + "]";
//        return "Device [id=" + id + ", name=" + name + ", type=" + type + ", status=" + status  + "]";
        return String.format("%2s | %20s | %10s | %10s", id, name, type, status);
    }

}
