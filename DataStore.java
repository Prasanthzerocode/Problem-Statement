import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;

public class DataStore {
	private File data;
    private HashMap<String,JSONObject> hm;
    private String path;
    DataStore() throws IOException,ClassNotFoundException
    {
        path="Datastore.ser";
        data=new File(path);
        if (data.createNewFile()) {
            System.out.println("File created");
            hm=new HashMap<String,JSONObject>();
            
        } else {
            FileInputStream fileIn=new FileInputStream(path);;
            ObjectInputStream in= new ObjectInputStream(fileIn);
            hm=(HashMap<String,JSONObject>)in.readObject();
            in.close();
            fileIn.close();
        }
        
    }

    DataStore(String p) throws IOException,ClassNotFoundException
    {
        path=p+"\\Datastore.ser";
        data=new File(path);
        if (data.createNewFile()) {
            System.out.println("File created");
            hm=new HashMap<String,JSONObject>();
        } 
        else {
            FileInputStream fileIn=new FileInputStream(path);;
            ObjectInputStream in= new ObjectInputStream(fileIn);
            hm=(HashMap<String,JSONObject>)in.readObject();
            in.close();
            fileIn.close();
        }
    }

    void create(String key, JSONObject obj)
    {
        if(data.length() >= 1073741824)
        {
            System.out.println("File size reached 1GB");
            return;
        }
        if(hm.containsKey(key))
        {
            System.out.println("Key already exists");
            return;
        }
        hm.put(key,obj);
        try
    	{
    		FileOutputStream fileOut=new FileOutputStream(path);;
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(hm);
            out.close();
            fileOut.close();
    	}
        catch(Exception e) {}
    }

    JSONObject read(String key)
    {
        if(!hm.containsKey(key))
        {
            System.out.println("Key doesn't exist");
            return null;
        }
        return hm.get(key);
    }

    void delete(String key)
    {
        if(!hm.containsKey(key))
        {
            System.out.println("Key doesn't exist");
            return;
        }
        hm.remove(key);
    }

}
