//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// *
// * @author Donglin Chen
// * !!!!!!!!!!!!!!!!
// * This procedure introduces the variable time on behalf of time
//*By default, all stars rotate counterclockwise. When time=0, all stars are on the X-axis to the right of the origin (the sun is on the origin).
//*The default output of the program is the acceleration between all stars when time=0. The acceleration of stars at different times can be obtained by modifying the variable time
//*本程序引入了代表时间的变量time
//*本程序默认所有星体逆时针方向旋转，在当time=0时，所有星体都位于原点右侧的x轴上（太阳在原点上，行星在太阳右侧，卫星在特定行星的右侧）
//*程序默认输出的是当time=0时的所有星体受到除自己以外所有星体的引力之和，可以通过修改变量time来获得星体在不同时间的加速度
//* 本程序所有的数据都使用国际标准单位
//* ！！！！！！！！！
// */
//public class Body {
//    private String name;
//    private String what_it_orbits;
//    private double mass;
//    private double diameter;
//    private double perihelion,aphelion;
//    private double orb_period;//单位s
//    private double mean_distance=(perihelion+aphelion)/2; //单位m
//    //private double volume=4.0/3.0*Math.PI*diameter*diameter*diameter;
//    private double orb_length=2*Math.PI*mean_distance;
//    private double time=0;//单位s
//    private Vec3d x=new Vec3d();//position 单位m
//    //private Vec3d v=new Vec3d();//velocity 单位m/s
//    private Vec3d a=new Vec3d();//acceleration 单位m/s^2
//
//    public Body(){
//        this(null,null,0,0,0,0,0);
//    }
//    public Body(String name,String what_it_orbits,double mass,double diameter,double perihelion,double aphelion,double orb_period){
//        this.name=name;
//        this.mass= mass;
//        this.diameter=diameter;
//        this.what_it_orbits=what_it_orbits;
//        this.perihelion=perihelion;
//        this.aphelion=aphelion;
//        this.orb_period=orb_period*24*60*60;
//        this.mean_distance=(this.perihelion+this.aphelion)/2;
//        //this.volume=4.0/3.0*Math.PI*diameter*diameter*diameter;
//        this.orb_length=2*Math.PI*mean_distance;
//        if(what_it_orbits.equals("Sun"))
//            x=new Vec3d(mean_distance*Math.cos(2*Math.PI*time/this.orb_period),mean_distance*Math.sin(2*Math.PI*time/this.orb_period),0);
//        else if(what_it_orbits.equals("Earth"))
//            x=new Vec3d(mean_distance*Math.cos(2*Math.PI*time/this.orb_period),mean_distance*Math.sin(2*Math.PI*time/this.orb_period),0).add(new Vec3d(1.496E11*Math.cos(2*Math.PI*time/this.orb_period),1.496E11*Math.sin(2*Math.PI*time/this.orb_period),0));
//        else if(what_it_orbits.equals("Jupiter"))
//            x=new Vec3d(mean_distance*Math.cos(2*Math.PI*time/this.orb_period),mean_distance*Math.sin(2*Math.PI*time/this.orb_period),0).add(new Vec3d(7.7855E11*Math.cos(2*Math.PI*time/this.orb_period),7.7855E11*Math.sin(2*Math.PI*time/this.orb_period),0));
//        else if(what_it_orbits.equals("Mars"))
//            x=new Vec3d(mean_distance*Math.cos(2*Math.PI*time/this.orb_period),mean_distance*Math.sin(2*Math.PI*time/this.orb_period),0).add(new Vec3d(2.279E11*Math.cos(2*Math.PI*time/this.orb_period),2.279E11*Math.sin(2*Math.PI*time/this.orb_period),0));
//        //if (orb_period==0)
//            //v=new Vec3d(0,0,0);
//        //else
//            //v=new Vec3d(0,orb_length/orb_period,0);//轨道长度/绕轨道一圈的时间=速度，单位m/s
//        //if (mean_distance==0)//太阳本身没有加速度
//             //a=new Vec3d(0,0,0);
//        //else
//            //a=new Vec3d(6.67e-11*1.9891e30/mean_distance/mean_distance,0,0);//a=GM/r^2
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getWhat_it_orbits() {
//        return what_it_orbits;
//    }
//    public void setWhat_it_orbits(String what_it_orbits) {
//        this.what_it_orbits = what_it_orbits;
//    }
//    public double getMass() {
//        return mass;
//    }
//    public void setMass(double mass) {
//        this.mass = mass;
//    }
//    public double getDiameter() {
//        return diameter;
//    }
//    public void setDiameter(double diameter) {
//        this.diameter = diameter;
//    }
//    public double getPerihelion() {
//        return perihelion;
//    }
//    public void setPerihelion(double perihelion) {
//        this.perihelion = perihelion;
//    }
//    public double getAphelion() {
//        return aphelion;
//    }
//    public void setAphelion(double aphelion) {
//        this.aphelion = aphelion;
//    }
//    public double getOrb_period() {
//        return orb_period;
//    }
//    public void setOrb_period(double orb_period) {
//        this.orb_period = orb_period;
//    }
//    public double getTime() {
//        return time;
//    }
//    public void setTime(double time) {
//        this.time = time;
//    }
//
//
//    public double getMean_distance() {
//        return mean_distance;
//    }
//    public double getOrb_length() {
//        return orb_length;
//    }
//    public Vec3d getX() {
//        if(what_it_orbits.equals("Sun"))
//            x=new Vec3d(mean_distance*Math.cos(2*Math.PI*time/this.orb_period),mean_distance*Math.sin(2*Math.PI*time/this.orb_period),0);
//        else if(what_it_orbits.equals("Earth"))
//            x=new Vec3d(mean_distance*Math.cos(2*Math.PI*time/this.orb_period),mean_distance*Math.sin(2*Math.PI*time/this.orb_period),0).add(new Vec3d(1.496E11*Math.cos(2*Math.PI*time/this.orb_period),1.496E11*Math.sin(2*Math.PI*time/this.orb_period),0));
//        else if(what_it_orbits.equals("Jupiter"))
//            x=new Vec3d(mean_distance*Math.cos(2*Math.PI*time/this.orb_period),mean_distance*Math.sin(2*Math.PI*time/this.orb_period),0).add(new Vec3d(7.7855E11*Math.cos(2*Math.PI*time/this.orb_period),7.7855E11*Math.sin(2*Math.PI*time/this.orb_period),0));
//        else if(what_it_orbits.equals("Mars"))
//            x=new Vec3d(mean_distance*Math.cos(2*Math.PI*time/this.orb_period),mean_distance*Math.sin(2*Math.PI*time/this.orb_period),0).add(new Vec3d(2.279E11*Math.cos(2*Math.PI*time/this.orb_period),2.279E11*Math.sin(2*Math.PI*time/this.orb_period),0));
//        return x;
//    }
//    public void setA(ArrayList<Body> al){
//        double xita;//θ,即两个星体的连线与x轴的夹角
//        double abstracta;//加速的膜
//        double d;//两个星体间的距离
//        for(Body b:al){
//            if(!b.getName().equals(this.getName())){
//                d=this.getX().distance(b.getX());
//                xita=this.getX().angle(b.getX());
//                abstracta=6.67e-11*b.getMass()/d/d;//万有引力公式
//                this.a=this.a.add(new Vec3d(abstracta*Math.cos(xita),abstracta*Math.sin(xita),0.0));//所有引力相加之和
//            }
//        }
//    }
//    public Vec3d getA() {
//        return a;
//    }
//
//    @Override
//    public String toString() {
//        return "{" + "name=" + name + ", what_it_orbits=" + what_it_orbits + ", mass=" + mass + ", diameter=" + diameter + ", perihelion=" + perihelion + ", aphelion=" + aphelion + ", orb_period=" + orb_period + ", mean_distance=" + mean_distance + ", orb_length=" + orb_length + ", x=" + x + ", a=" + a + '}';
//    }
//
//
//
//    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException{
//        Scanner sc=new Scanner(new FileReader("solarsystem.dat"));
//        sc.nextLine();
//        /*Body Sun=new Body(s2[0],s2[1],Double.parseDouble(s2[2]),Double.parseDouble(s2[3]),Double.parseDouble(s2[4]),Double.parseDouble(s2[5]),Double.parseDouble(s2[6]));
//        System.out.println(Sun);
//        s2=sc.nextLine().split("\\s+");
//        Body Mercury=new Body(s2[0],s2[1],Double.parseDouble(s2[2]),Double.parseDouble(s2[3]),Double.parseDouble(s2[4]),Double.parseDouble(s2[5]),Double.parseDouble(s2[6]));
//        System.out.println(Mercury);
//        s2=sc.nextLine().split("\\s+");
//        Body Venus=new Body(s2[0],s2[1],Double.parseDouble(s2[2]),Double.parseDouble(s2[3]),Double.parseDouble(s2[4]),Double.parseDouble(s2[5]),Double.parseDouble(s2[6]));
//        System.out.println(Venus);
//        s2=sc.nextLine().split("\\s+");
//        Body Earth=new Body(s2[0],s2[1],Double.parseDouble(s2[2]),Double.parseDouble(s2[3]),Double.parseDouble(s2[4]),Double.parseDouble(s2[5]),Double.parseDouble(s2[6]));
//        System.out.println(Earth);
//        s2=sc.nextLine().split("\\s+");
//        Body Moon=new Body(s2[0],s2[1],Double.parseDouble(s2[2]),Double.parseDouble(s2[3]),Double.parseDouble(s2[4]),Double.parseDouble(s2[5]),Double.parseDouble(s2[6]));
//        System.out.println(Moon);*/
//        ArrayList<Body> al=new ArrayList<>();
//        while(sc.hasNextLine()){
//            String[] s2=sc.nextLine().split("\\s+");
//            al.add(new Body(s2[0],s2[1],Double.parseDouble(s2[2]),Double.parseDouble(s2[3]),Double.parseDouble(s2[4]),Double.parseDouble(s2[5]),Double.parseDouble(s2[6])));
//        }
//        for(int i=0;i<al.size();i++)
//            al.get(i).setA(al);
//        for(Body b:al)
//            System.out.println(b);
//    }
//}
//class Vec3d {
//    private double x,y,z;
//    public Vec3d(double x,double y,double z){
//        this.x=x;
//        this.y=y;
//        this.z=z;
//    }
//    public Vec3d(){
//        this(0,0,0);
//    }
//    public static Vec3d add(Vec3d a,Vec3d b){
//        return new Vec3d(a.x+b.x,a.y+b.y,a.z+b.z);
//    }
//    public Vec3d add(Vec3d a){
//        return new Vec3d(this.x+a.x,this.y+a.y,this.z+a.z);
//    }
//    public static Vec3d sub(Vec3d a,Vec3d b){
//        return new Vec3d(a.x-b.x,a.y-b.y,a.z-b.z);
//    }
//    public Vec3d sub(Vec3d a){
//        return new Vec3d(this.x-a.x,this.y-a.y,this.z-a.z);
//    }
//    public static double dotmult(Vec3d a,Vec3d b){
//        return a.x*b.x+a.y*b.y+a.z*b.z;
//    }
//    public double dotmult(Vec3d a){
//        return a.x*this.x+a.y*this.y+a.z*this.z;
//    }
//    public double distance(Vec3d a){
//        return Math.sqrt((this.x-a.x)*(this.x-a.x)+(this.y-a.y)*(this.y-a.y)+(this.z-a.z)*(this.z-a.z));
//    }
//    public double angle(Vec3d a){
//        return Math.atan((this.y-a.y)/(this.x-a.x));
//    }
//    @Override
//    public String toString(){
//        return "("+x+","+y+","+z+")";
//    }
//}