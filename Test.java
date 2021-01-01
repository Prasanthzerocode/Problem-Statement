import org.json.simple.JSONObject;

public class Test {
   public static void main(String args[])
   {
       try
       {
        DataStore ds=new DataStore();
        JSONObject obj=new JSONObject();
        obj.put("Name","Prasanth");
        obj.put("Age","21");
        ds.create("17i232", obj);
        System.out.println(ds.read("17i232"));
        System.out.println(ds.read("17i233"));
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   } 
}
