import java.util.HashMap;

public class ExoM12 {
    public static void main(String[] args) {
            HashMap<String, Integer> Infos = new HashMap<>();
            
            Infos.put("DIALLO", 23);
            
            int Info = Infos.get("DIALLO");
            
            System.out.println(Info);
        }

}
