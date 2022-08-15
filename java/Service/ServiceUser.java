package Service;


import Model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceUser {
    private static ArrayList<User>userss=new ArrayList<>();
    public static ArrayList<Process>Userss=new ArrayList<>();
    public static ArrayList<User> getuseer() {
      return userss;
    }


    public static void addUse(User user) {
        userss.add(user);

    }


    public static void updatuser(int index, User user) {

        userss.set(index,user);

    }

    public static void deletUserr(int index) {

        userss.remove(index);


    }

    }

//




