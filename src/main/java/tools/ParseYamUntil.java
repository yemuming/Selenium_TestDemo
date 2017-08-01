package tools;

import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

/**
 * Created by xmy on 2017/8/1.
 */
public class ParseYamUntil {
        public  static HashMap<String, HashMap<String,String>> results;
        public  static HashMap<String, HashMap<String,String>> settings;
        public  static HashMap<String, HashMap<String,String>> locators;
        public  static HashMap<String, HashMap<String,String>> parseLocatorFile(String FileName){
            File file=new File("src/main/resources/config/Setting.yaml");
            try {
                locators= Yaml.loadType(new FileInputStream(file.getAbsolutePath()),HashMap.class);
            }catch (Exception e){
                e.printStackTrace();
            }
            return locators;
        }
        public HashMap<String, HashMap<String,String>> parseSettingFile(String FileName) {
            File file = new File("src/main/resources/config/Setting.yaml");
            try {
                settings = Yaml.loadType(new FileInputStream(file.getAbsolutePath()), HashMap.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
                return settings;
        }
}
