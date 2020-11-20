/**
 * Write a description of class cd here.
 * 
 * @author Luis Fernando Posada Cano Juan Pablo Giraldo
 * @version (a version number or a date)
 */
public class Bees
{
    private double latitude;
    private double longitude;
    private double altitude;
     public Bees(double latitude, double longitude, double altitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.altitude=altitude;
    }
     public double getLatitude(){
        return latitude;
    }
     public double getLongitude(){
        return longitude;
    }
     public double getAltitude(){
        return altitude;
    }
}
