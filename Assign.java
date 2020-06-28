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
public class Assign{
    public static void main(String[] args){
        //线程池 未使用
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        Future<getStop> future = executor.submit(c, gs);
        CurrentStatus cs = new CurrentStatus();
        GetCurrentTime gt = new GetCurrentTime();
        Statistics st = new Statistics(0,10);
        Clock c = new Clock(cs);
        //这里配置
        /**
         *     public int ChocolateMakeTime;//热巧
         *     public int CappuccinoMakeTime;//卡布奇诺
         *     public int FruitjuiceMakeTime;//果汁
         *     public int CustomerEnteringNum;//初始顾客入座数量
         *     public int DrinkTime;//喝茶时间
         *     public int DrinkNumAtTable;//每桌杯子数
         */
        Configuration cg = new Configuration(5,4,3,7,10,3);
        //线程开始
        WaiterOrOwner wt = new WaiterOrOwner("waiter", cs, cg, gt, st);
        WaiterOrOwner ow = new WaiterOrOwner("owner", cs, cg, gt, st);
        Customer cu = new Customer("customer",cs, cg,gt);
        c.start();
        cu.start();
        wt.start();
        ow.start();
    }
}
