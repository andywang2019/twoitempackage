package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
  //  @Test
 //   public void shouldAnswerWithTrue()
 //   {
 //       assertTrue( true );
  //  }
    @Test
    public void test150(){
        List<Item> ret=two_items_packaging.findpair(150, "src/items.txt");
        //if(ret!=null&ret.size()==2&&(ret.get(0).getPrice()+ret.get(1).getPrice())<inputprivce)
        if(ret!=null&ret.size()==2)
            System.out.println(ret.get(0)+"\n"+ret.get(1));
        else{
            System.out.println("No solution");
        }
        assertTrue( ret.size()==2 );
    }
 @Test
    public void test100(){
        List<Item> ret=two_items_packaging.findpair(100, "src/items.txt");
        //if(ret!=null&ret.size()==2&&(ret.get(0).getPrice()+ret.get(1).getPrice())<inputprivce)
        if(ret!=null&ret.size()==2)
            System.out.println(ret.get(0)+"\n"+ret.get(1));
        else{
            System.out.println("No solution");
        }
     assertTrue( ret.size()==2 );
    }
    @Test
    public void test30(){
        List<Item> ret=two_items_packaging.findpair(30, "src/items.txt");
        //if(ret!=null&ret.size()==2&&(ret.get(0).getPrice()+ret.get(1).getPrice())<inputprivce)
        if(ret!=null&ret.size()==2)
            System.out.println(ret.get(0)+"\n"+ret.get(1));
        else{
            System.out.println("No solution");
        }
        assertTrue( ret.size()<2 );
    }
}
