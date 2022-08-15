package Service;


import Model.MerchantStock;

import Model.Product;
import Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicMerchantStock {

    private static ArrayList<MerchantStock> merchantStockss = new ArrayList<MerchantStock>();

    private ServiceUser serviceUser;

    public static ArrayList<MerchantStock> getMerStock() {

        return merchantStockss;
    }

    public static void addMetStock(MerchantStock merchantStock) {

//

        merchantStockss.add(merchantStock);
//
    }

    public static void updatMerStock(int index, MerchantStock merchantStock) {
        merchantStockss.set(index, merchantStock);
    }

    public static void daleMerStock(int index) {
        merchantStockss.remove(index);
    }

//
    public  static  int Edit (String IdProduct,String Idmerchant,int IdmerchantStock){

        if (IdmerchantStock<0){
            return 2;
        }
        for (int i=0;i<merchantStockss.size();i++){
            if(merchantStockss.get(i).getProductid().equals(IdProduct)&&
                    merchantStockss.get(i).getMerchantid().equals(Idmerchant)){
               merchantStockss.get(i).setIdmerchantStock(merchantStockss.get(i).getIdmerchantStock() )+IdmerchantStock));
                      return 1;


            }
        }
return 3;
    }

    }

