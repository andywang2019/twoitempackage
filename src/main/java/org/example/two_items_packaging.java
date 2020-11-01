package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class two_items_packaging{
    public static void main( String[] args )
    {
        double inputprivce=Double.parseDouble("150");
       List<Item> ret= findpair(inputprivce ,args[1]);
       //if(ret!=null&ret.size()==2&&(ret.get(0).getPrice()+ret.get(1).getPrice())<inputprivce)
        if(ret!=null&ret.size()==2)
        System.out.println(ret.get(0)+"\n"+ret.get(1));
       else{
           System.out.println("No solution");
       }

    }
    //Method1 :two point starting from  j=0 i=list.size()-1 =>j++ i-- =>comare sum(list[i]+list[j]) with budget
    public static List<Item> findpair(double inputprivce,String filepath){
      //  double inputprivce=Double.parseDouble(args[0]);
        BufferedReader bf=null;
        List<Item> list=new ArrayList();

        int i=0, j=0;
        try  {

            FileReader file=new FileReader(filepath);
            bf = new BufferedReader(file);
            String line=null;

            while((line=bf.readLine())!=null){
              //  System.out.println(line);
                String[] items= line.split(",");
                Item item=new Item();
                item.setName(items[0]);
                item.setPrice(Double.parseDouble(items[1]));
                list.add(item);

            }

            for( i=list.size()-1;i>=0;i--) {
                if (list.get(i).getPrice() < inputprivce) break;
            }
            double pre_diff=0;
            double diff=100000;
            for( j=0;j<i;) {
                diff = inputprivce - (list.get(i).getPrice() + list.get(j).getPrice());

                // if reaching to the minmium of the error ,then exit;
                if(Math.abs(diff)<Math.abs(pre_diff))
                    break;

                pre_diff = diff;
                 //  if sum of list[i]+list[j] <budget ,then i++ or j++
                if (diff >0) {
                    int length=list.size();
                    int indexi=(i +1)==length?i:( i+1);
                    int indexj=(j +1)==length?j:( j+1);
                    double tmp_diffi = inputprivce - (list.get(indexi).getPrice() + list.get(j).getPrice());
                    double tmp_diffj = inputprivce - (list.get(i).getPrice() + list.get(indexj).getPrice());
                    if (Math.abs(tmp_diffi) < Math.abs(tmp_diffj))
                        i++;
                    else
                        j++;
                }

                //  if sum of list[i]+list[j] >budget  then i-- or j--
                 else {

                    double tmp_diffi = inputprivce - (list.get((i - 1)==-1?i:(i - 1)).getPrice() + list.get(j).getPrice());
                    double tmp_diffj = inputprivce - (list.get(i).getPrice() + list.get((j - 1)==-1?j:(j - 1)).getPrice());
                    if (Math.abs(tmp_diffi) < Math.abs(tmp_diffj))
                        i--;
                    else
                        j--;
                }
            }

            bf.close();
        }catch(IOException ie){
            ie.printStackTrace();
        }finally {

        }
       // List ret=new ArrayList();
        //if(i<list.size()-1)
       // ret.add(list.get(++i));
      //  if(j>0)
      //  ret.add(list.get(--j));

        List ret=new ArrayList();
        if(i>=0&&i<list.size()-1)
        ret.add(list.get(i));
        if(j>=0&&j<list.size()-1&&j!=i)
        ret.add(list.get(j));
        return ret;
    }
}
