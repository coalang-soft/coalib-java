package test;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.dynamic.DynamicObject;

import java.util.Random;

/**
 * Created by Matthias on 11.05.2017.
 */
public class LibTest {

    static double last;

    public static void main(String[] args){
        DynamicObject<Object> any = new DynamicObject<Object>( false );
        Func<Void,String> f = any.bool()._if("Wahr", "Falsch").str().act(new Func<String, String>() {
            @Override
            public String call(String s) {
                return s.toUpperCase();
            }
        });
        while(true){
            System.out.println(f.call(null));
        }
    }

}
