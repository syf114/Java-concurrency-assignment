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
public class Clock extends Thread{
    private CurrentStatus cs;
    public Clock(CurrentStatus cs){
        this.cs = cs;
    }
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("Start: " + this.timeStamp2Date(String.valueOf(start/1000)));
        boolean flag = true;
        while (flag) {
            try {
                Thread.sleep(1000);
                long current = System.currentTimeMillis();
                long dif = current -start;
                if(dif>98000&&dif<100000){
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Warning !  Last order! ");
                    cs.setWarning(true);
                    Thread.sleep(10000);
                }
                if(dif>100000){
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Close time! System down");
                    flag = false;
                    cs.setFlag(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //时间戳转换
    public static String timeStamp2Date(String seconds) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }

    //获取当前时间接口
    public static interface Gettime{
        public String gettime();
    };

    //创建接口对象
    public Gettime gettime;
}

