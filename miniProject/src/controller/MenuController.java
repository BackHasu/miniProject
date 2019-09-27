package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import model.vo.Food;

public class MenuController {
   private ArrayList<Food> susiList = new ArrayList<>();
   private ArrayList<Food> sideList = new ArrayList<>();
   private ArrayList<Food> sakeList = new ArrayList<>();
   private ArrayList<Food> drinkList = new ArrayList<>();
   Map<Food, Integer> orderMap = new HashMap<>();
   static final private MenuController MENU_CONTROLLER = new MenuController();
   
   private MenuController() {
      menuInit("./src/menuTextFiles/menu.txt",susiList);
      menuInit("./src/menuTextFiles/side.txt",sideList);
      menuInit("./src/menuTextFiles/sake.txt",sakeList);
      menuInit("./src/menuTextFiles/drink.txt",drinkList);
   }
   public void menuInit(String address,ArrayList<Food> arrayList) {
           //try with resource ��� ���
         try(BufferedReader menuBufferedReader 
              = new BufferedReader(new FileReader(new File(address)));){
            //������Ʈ�� BuffeReader ���
            
           // �ؽ�Ʈ���Ͽ� �Էµ� ������ �ӽ÷� ������ ���� ����
            String title;
            String image;
            String price;
            

            while ((title = menuBufferedReader.readLine()) != null) {
               String[] spt = title.split(",");
               title = spt[0];
               image = spt[1];
               price = spt[2];
               arrayList.add(new Food(title, image, Integer.parseInt(price)));
            }//','�� �������� split�ؼ� ������ title, image, price�� ����


         }catch (Exception e) {
            e.printStackTrace();
         }
      }

   //////////////////////�޴� ��̸���Ʈ get, �޴� �� �� �� ������(size), ������ ���ϰ� get�� �������//////////////////////
   public ArrayList<Food> getSusiList() {
      return susiList;
   }

   public ArrayList<Food> getSideList() {
      return sideList;
   }

   public ArrayList<Food> getSakeList() {
      return sakeList;
   }

   public ArrayList<Food> getDrinkList() {
      return drinkList;
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////////


   public Map<Food, Integer> getOrderMap() {
      return orderMap;
   }

   public void orderFood(Food food){
      if(orderMap.get(food)==null)orderMap.put(food, 1);
      else orderMap.put(food, orderMap.get(food)+1);
      System.out.println("size " + orderMap.size() + " " + orderMap.get(food));
   }
   public int calcOrder(){
      Iterator<Food> mapIter = orderMap.keySet().iterator();
      int result = 0;
      while(mapIter.hasNext()){
         Food food = mapIter.next();
         int count = orderMap.get(food);
         result += food.getPrice()*count;
      }
      return result;
   }
   public int sizeOrder(){
         Iterator<Food> mapIter = orderMap.keySet().iterator();
         int count = 0;
         while(mapIter.hasNext()){
            Food food = mapIter.next();
            count += orderMap.get(food);
         }
         
         return count;
         
      }
   public static MenuController getInstance(){
      return MENU_CONTROLLER;
   }
}