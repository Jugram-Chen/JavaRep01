import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Donglin Chen
 */
public class OpenFile2 {
    public static void main(String[] arg) throws FileNotFoundException{
        String sun_name = "Sun",venus_name = "Venus",earth_name = "Earth",moon_name = "Moon";
        double sun_mass = 0.0,venus_mass = 0.0,earth_mass = 0.0,moon_mass = 0.0;
        double sun_diameter=0.0,venus_diameter=0.0,earth_diameter=0.0,moon_diameter=0.0;
        String sun_orbit=null,venus_orbit=null,earth_orbit=null,moon_orbit=null;
        double sun_perihelion=0.0,venus_perihelion=0.0,earth_perihelion=0.0,moon_perihelion=0.0;
        double sun_aphelion=0.0,venus_aphelion=0.0,earth_aphelion=0.0,moon_aphelion=0.0;
        double sun_ave_orbit = 0.0,venus_ave_orbit = 0.0,earth_ave_orbit = 0.0,moon_ave_orbit = 0.0;
        Scanner s=new Scanner(new FileReader("solarsystem.dat"));
        
        while(s.hasNext() ){
            String temp=s.next();
            if(temp.equals(sun_name)){
                sun_orbit=s.next();
                sun_mass=s.nextDouble();
                sun_diameter=s.nextDouble();
                sun_perihelion=s.nextDouble();
                sun_aphelion=s.nextDouble();
                break;
            }
        }
        while (s.hasNext()){
            String temp=s.next();
            if(temp.equals(venus_name)){
                venus_orbit=s.next();
                venus_mass=s.nextDouble();
                venus_diameter=s.nextDouble();
                venus_perihelion=s.nextDouble();
                venus_aphelion=s.nextDouble();
                break;
            }
        }
        while (s.hasNext()){
            String temp=s.next();
            if(temp.equals(earth_name)){
                earth_orbit=s.next();
                earth_mass=s.nextDouble();
                earth_diameter=s.nextDouble();
                earth_perihelion=s.nextDouble();
                earth_aphelion=s.nextDouble();
                break;
            }
        }
        while (s.hasNext()){
            String temp=s.next();
            if(temp.equals(moon_name)){
                moon_orbit=s.next();
                moon_mass=s.nextDouble();
                moon_diameter=s.nextDouble();
                moon_perihelion=s.nextDouble();
                moon_aphelion=s.nextDouble();
                break;
            }
        }
        
        Body sun=new Body(sun_name,sun_mass,sun_diameter,sun_orbit,sun_perihelion,sun_aphelion);
        Body venus=new Body(venus_name,venus_mass,venus_diameter,venus_orbit,venus_perihelion,venus_aphelion);
        Body earth=new Body(earth_name,earth_mass,earth_diameter,earth_orbit,earth_perihelion,earth_aphelion);
        Body moon=new Body(moon_name,moon_mass,moon_diameter,moon_orbit,moon_perihelion,moon_aphelion);
        System.out.println(sun);
        System.out.println(venus);
        System.out.println(earth);
        System.out.println(moon);
    } 
}
class Body {
    String name;
    double mass;
    double diameter;
    String what_it_orbits;
    double perihelion,aphelion;
    double mean_distance=(perihelion+aphelion)/2; 
    double vel=4/3*Math.PI*diameter*diameter*diameter;
    
    public Body(String name,double mass,double diameter,String what_it_orbits,double perihelion,double aphelion){
        this.name=name;
        this.mass= mass;
        this.diameter=diameter;
        this.what_it_orbits=what_it_orbits;
        this.perihelion=perihelion;
        this.aphelion=aphelion;
        this.mean_distance=(this.perihelion+this.aphelion)/2; 
        double vel=4/3*Math.PI*diameter*diameter*diameter;
    }
        public String toString(){
        return name+" "+mass+" "+diameter+" "+what_it_orbits+" "+mean_distance;
    }
}
    
