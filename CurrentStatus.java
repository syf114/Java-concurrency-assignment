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
 * 
 *///获取当前状态，判断是否到90秒 系统警告， 100秒系统关闭， 储存点单顾客名字
public class CurrentStatus{
    private boolean StopFlag;
    private boolean warning;
    private String CustomerName;

    public void setFlag(boolean StopFlag) {
        this.StopFlag = StopFlag;
    }

    public boolean getflag() {
        return StopFlag;
    }

    public void setWarning(boolean warning) {
        this.warning = warning;
    }

    public boolean getWarning() {
        return warning;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
}