import javax.xml.crypto.Data;
import java.security.MessageDigest;
import java.sql.SQLOutput;
import java.util.Objects;

public class Block {

    public String hash;



    public int data;
    public long time;
    public  String prevHash;




    public Block(int data,String prevHash) {
        this.data = data;
        this.time = System.currentTimeMillis();
      this.prevHash=prevHash;
        this.hash = calculateHash(data+prevHash);


    }
    public String calculateHash( String input){
//         return Integer.toHexString((data+time+prevHash).hashCode());
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
                String hex = Integer.toHexString(0xff & elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
   }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getHash() {
        return hash;
    }
    public String getPrevHash() {
        return prevHash;

    }

}

