package UNIT2;

import java.util.*;


class Node{


    int d;
    Node l= null;
    Node ri= null;
    Node(int d)
    {
        this.d= d;
    }

}
class Main{

public
Scanner sc =new Scanner(System.in); 
static Node r = null;

    public static Node Insert(int item){

        Node temp=new Node(item);
    
        if (r == null)
         {r = temp;}
    
        Node prev, cur;
        prev=null;
        cur=r;
        while(cur!=null)            
        {
            prev=cur;
            if (item==cur.d && item!=0){
                System.out.println("Duplicates Not allowed");
                temp=null;
                return null;
            }
            else if (item<cur.d)
                    cur=cur.l;
                 else
                    cur=cur.ri;
        }
        if (item<prev.d)
            prev.l = temp;
        else
            prev.ri = temp;
        
        return temp;
    }
   public static boolean Search (int item){
        Node temp = r;
        while(temp != null)
        {
            if (temp.d == item)
                { return true;}
            else
            {
                if (item<temp.d)
                
                temp=temp.l;
                else{
                    temp=temp.ri; }
        }
       
    }
        return false;
}
    public static Node LCA(int x, int y)
    {
       
        if (r == null || !Search(x) || !Search(y)) {
            return null;
        }
 

        Node curr = r;
 
      
        while (curr != null)
        {
        
            if (curr.d > Integer.max(x, y)) {
                curr = curr.l;
            }
 
           
            else if (curr.d < Integer.min(x, y)) {
                curr = curr.ri;
            }
 
            else {
                return curr;
            }
        }
        return curr;
    }

    Node Create(int item){
        int x;
        Node temp=new Node(item);

        
        if (item>0)
        {
            if (r == null)
            {r = temp; }
       
            System.out.println("Enter next item after "+item+" ");
            x=sc.nextInt();
            Node v=Insert(x);
             if(v!=null){
                  
                Create(x);
             }
             else{
                  Create(item);
             }
            System.out.println("Enter next item after "+item+" ");
            x=sc.nextInt();
            v=Insert(x);
            if(v!=null){
                  
                Create(x);
             }
             else{
                  Create(item);
             }
            return null;    
        }
    return null;
  }



    void Createtree(){

        int item;
       
        System.out.println("Creating the Binary search tree , enter appropriate values: ");
        item =sc.nextInt();
        Create(item);
      }




}


