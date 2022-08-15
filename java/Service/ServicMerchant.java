package Service;


import Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicMerchant {
    private static ArrayList<Merchant>merch=new ArrayList<>();


    public static ArrayList<Merchant> getMer() {
        return merch;
    }


    public static void addMer(Merchant merchant) {

//        ArrayList<Merchant>merchants=ServicMerchant.getMer();
//        for (int i=0;i<merchants.size();i++){
//            if(merchants.get(i).getIdmerchant()==merchant.getIdmerchant()){
        merch.add(merchant);
//                return  true;
//            }
//        }
//        return false;
    }

    public static void updateMer(int index, Merchant merchant) {

        merch.set(index,merchant);
    }

    public static void deletMer(int index) {
        merch.remove(index);
    }



}

