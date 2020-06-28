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

    //主人and服务生线程
public class WaiterOrOwner extends Thread{
    private String name;
    private CurrentStatus cs;
    private Configuration cg;
    private GetCurrentTime gt;
    private Statistics st;
    private boolean flag = true;
    public WaiterOrOwner(String name , CurrentStatus cs, Configuration cg, GetCurrentTime gt, Statistics st){
        this.name = name;
        this.cs = cs;
        this.cg = cg;
        this.gt = gt;
        this.st = st;
    }
    static Object sa= "ServingArea";//服务区设置为对象锁

    public void run() {
        Random r = new Random(1);
        while (flag) {
            try {
                int drinkType;
                String drinkName;
                //系统关闭
                if(cs.getflag()==true){
                    if(this.name.equals("waiter")){
                        System.out.println(gt.gettime() + ">>>" + this.name + " is leaving");
                    }else{
                        System.out.println(gt.gettime() + ">>>" + this.name + " finish working");
                        System.out.println(gt.gettime() + ">>>" + "total serverd customer number : " + st.CustomerServedNum);
                        System.out.println(gt.gettime() + ">>>" + this.name + " cleaning all seats");
                        System.out.println(gt.gettime() + ">>>" + " now Seats :  " + 0);
                    }
                    flag=false;
                    break;
                }
                //系统警告
                if(cs.getWarning()==true){
                    if(this.name.equals("owner")){
                        System.out.println(gt.gettime() + ">>>" + "the owner WARNING it is last order!");
                        Thread.sleep(5000);
                        continue;
                    }
                }
                synchronized (sa) {
                    if(cs.getflag()==false&&cs.getWarning()==false){

                        //客户点单
                        //随机产生饮品
                        Thread.sleep(3000);
                        drinkType = r.nextInt(3);
                        drinkName = cg.Drinktype.get(drinkType);
                        String Cutomername = cs.getCustomerName();
                        System.out.println(gt.gettime() + ">>>" + Cutomername + " is going to order " + drinkName);

                        System.out.println(gt.gettime() + ">>>" + this.name + " is making " + drinkName);
                        //处理饮品 0 热巧 1 卡布奇诺 2 果汁
                        if(drinkType==0){
                            System.out.println(gt.gettime() + ">>>" + this.name + " obtain a glass, then Obtain the juice fountain tap ");
                            Thread.sleep(cg.ChocolateMakeTime*500);
                            System.out.println(gt.gettime() + ">>>" + this.name + " fill the glass and finish making " + drinkName);
                            //喝
                            Thread.sleep(cg.DrinkTime*500);
                            System.out.println(gt.gettime() + ">>>" + Cutomername + " finish drinking  " + drinkName + " and leave the shop");
                            st.CustomerServedNum++;
                            cg.CustomerEnteringNum-=1;
                        }
                        if(drinkType==1){
                            System.out.println(gt.gettime() + ">>>" + this.name + " obtain a glass, then Obtain each ingredients coffee and milk ");
                            Thread.sleep(cg.CappuccinoMakeTime*500);
                            System.out.println(gt.gettime() + ">>>" + this.name + " mix the drink and finish making " + drinkName);
                            //喝
                            Thread.sleep(cg.DrinkTime*500);
                            System.out.println(gt.gettime() + ">>>" + Cutomername + " finish drinking  " + drinkName + " and leave the shop");
                            st.CustomerServedNum++;
                            cg.CustomerEnteringNum-=1;
                        }
                        if(drinkType==2){
                            System.out.println(gt.gettime() + ">>>" + this.name + " obtain a glass, then Obtain ingredients chocolate and milk ");
                            Thread.sleep(cg.FruitjuiceMakeTime*500);
                            System.out.println(gt.gettime() + ">>>" + this.name + " finish making " + drinkName);
                            //喝
                            Thread.sleep(cg.DrinkTime*500);
                            System.out.println(gt.gettime() + ">>>" + Cutomername + " finish drinking  " + drinkName + " and leave the shop");
                            st.CustomerServedNum++;
                            cg.CustomerEnteringNum-=1;
                        }
                        System.out.println(gt.gettime() + ">>>" + " now Seats :  " + cg.CustomerEnteringNum);
                    }
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

