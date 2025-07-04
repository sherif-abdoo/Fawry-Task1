import java.util.List;

public class ShippingService {
    public static int send(List<ShippableItem> shippableItems) {
        System.out.println("**Shipment notice**");
        double totalWeight = 0;
        for (ShippableItem shippableItem : shippableItems) {
            System.out.println(shippableItem.getName());
            totalWeight += shippableItem.getWeight();
        }
        String output = "Total package weight ";
        int shippingPrice = 30;
        /*converts total weight to kg if weight is more than 1000g*/
        if(totalWeight >= 1000){
            totalWeight/=1000;
            //every kg costs 30 eg at shipping
            shippingPrice = (int) totalWeight*30;
            output+=totalWeight+" kg";
        }
        else{
            output+=totalWeight+" g";
        }
        System.out.println(output);
        return shippingPrice;
    }
}
