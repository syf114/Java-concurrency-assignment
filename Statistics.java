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
 *///记录总共服务顾客数量，已占座位数
public class Statistics{
    public int CustomerServedNum;
    public int Seats;
    public Statistics(int CustomerServedNum,int Seats){
        this.CustomerServedNum = CustomerServedNum;
        this.Seats = Seats;
    }
}
