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
 *///获取当前时间
//get current time
 public class GetCurrentTime implements Clock.Gettime{

    @Override
    public String gettime() {
        return Clock.timeStamp2Date(String.valueOf(System.currentTimeMillis()/1000));
    }
}