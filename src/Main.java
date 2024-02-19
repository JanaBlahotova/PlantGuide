import com.engeto.ja.Plant;

public class Main {


    public static void main(String[] args) throws Plant.PlantException {
        Plant plant1 = new Plant("kaktus");
        System.out.println(plant1.getWateringInfo());
    }


}

