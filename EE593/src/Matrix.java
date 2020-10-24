
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Donglin Chen
 */
public class Matrix {

    int n;
    double[][] m;
    double[]x;
    double[]v;
    double[][] mv;

    public Matrix(double[][] m,double[] v) {
        n = m.length;
        this.m = new double[n][n];
        this.v=new double[n];
        this.mv=new double[n][n+1];
        this.x=new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.m[i][j] = m[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            this.v[i]=v[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mv[i][j] = m[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            mv[i][n]=v[i];
        }
    }

    public void partialPivot2() {
        for(int k=1;k<n;k++){
            for(int i=k;i<n;i++){
                for(int j=n;j>=0;j--){
                    mv[i][j]=mv[i][j]-mv[i][k-1]/mv[k-1][k-1]*mv[k-1][j];
                }
            }
            for(int i=0;i<k-1;i++){
                for(int j=n;j>=0;j--){
                    mv[i][j]=mv[i][j]-mv[i][k-1]/mv[k-1][k-1]*mv[k-1][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j]=mv[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            v[i]=mv[i][n];
        }
    }

    public void rotate(){
        double[][]mr=new double[n][n];
        double[]vr=new double[n];
        double[][]mvr=new double[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                mr[i][j]=m[n-1-i][n-1-j];
            }
        }
        for (int i = 0; i < n; i++) {
            vr[i]=v[n-1-i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                mvr[i][j]=mr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            mvr[i][n]=vr[i];
        }
        m=mr;
        v=vr;
        mv=mvr;
    }

    public void printmv() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(mv[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public void printm(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public void printv(){
        for (int i = 0; i < n; i++) {
            System.out.println(v[i]);
        }
    }

    public void printx(){
        for (int i = 0; i < n; i++) {
            System.out.println("x["+i+"] = "+x[i]);
        }
    }

    public void getAnswer(){
        for (int i = 0; i < n; i++) {
            x[i]=v[i]/m[i][i];
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new FileReader("EE593\\mat.dat"));
        int n=sc.nextInt();
        double[][] b=new double[n][n];
        double[] b2=new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j]=sc.nextDouble();
            }
        }
        for (int i = 0; i < n; i++) {
            b2[i]=sc.nextDouble();
        }
        Matrix mb = new Matrix(b,b2);
        mb.partialPivot2();
        mb.printm();
        //mb.rotate();
        //mb.partialPivot2();
        //mb.rotate();
        //mb.getAnswer();
        //mb.printx();
    }

}
