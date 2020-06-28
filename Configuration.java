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
//system setting
public class Configuration{
    public int ChocolateMakeTime;//热巧
    public int CappuccinoMakeTime;//卡布奇诺
    public int FruitjuiceMakeTime;//果汁
    public int CustomerEnteringNum;//初始顾客入座数量
    public int DrinkTime;//喝茶时间
    public int DrinkNumAtTable;//每桌杯子数
    public ArrayList<String> Drinktype = new ArrayList<String>();
    public ArrayList<String> namelist = new ArrayList<String>();
    public Configuration(int ChocolateMakeTime,int CappuccinoMakeTime, int FruitjuiceMakeTime, int CustomerEnteringNum,int DrinkTime,int DrinkNumAtTable){
        this.CappuccinoMakeTime = CappuccinoMakeTime;//5
        this.ChocolateMakeTime = ChocolateMakeTime;//4
        this.FruitjuiceMakeTime = FruitjuiceMakeTime;//3
        this.CustomerEnteringNum = CustomerEnteringNum;//8
        this.DrinkNumAtTable = DrinkNumAtTable;//10
        this.DrinkTime = DrinkTime;//3
        /*   饮品    */
        Drinktype.add("Chocolate");
        Drinktype.add("Cappuccino");
        Drinktype.add("Fruit Juice");
        /*  客户名字   */
        namelist.add("Jordan");
        namelist.add("Cristina");
        namelist.add("Joseph");
        namelist.add("Gabriel");
        namelist.add("Micheal");
        namelist.add("Erin");
        namelist.add("Henry");
        namelist.add("Sophie");
        namelist.add("Steve");
        namelist.add("Selina");
    }
}