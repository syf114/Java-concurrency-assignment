/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author suyifan
 */
    //顾客线程
public class Customer extends Thread{
    private String name;
    private CurrentStatus cs;
    private Configuration cg;
    private GetCurrentTime gt;
    private boolean flag = true;
    public Customer(String name , CurrentStatus cs, Configuration cg, GetCurrentTime gt){
        this.name = name;
        this.cs = cs;
        this.cg = cg;
        this.gt = gt;
    }
    static Object cu= "customer";//顾客设置为对象锁

    public void run() {
        Random r = new Random(1);
        while (flag) {
            try {
                String Customername;
                if(cs.getflag()==true){
                    flag=false;
                    break;
                }
                if(cs.getWarning()==true){
                    Thread.sleep(5000);
                    continue;
                }
                synchronized(cu){
                    //随机生成顾客
                    Customername = cg.namelist.get(r.nextInt(10));
                    //客户进入
                    System.out.println(gt.gettime() + ">>>" + Customername + " entering the Cafe!");
                    Thread.sleep(2000);
                    if(cg.CustomerEnteringNum>9){
                        System.out.println(gt.gettime() + ">>>" + Customername + " is blocked in case of there are no more seats !");
                    }else{
                        cg.CustomerEnteringNum++;
                        cs.setCustomerName(Customername);
                    }
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

