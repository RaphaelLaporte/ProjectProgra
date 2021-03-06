package ch.epfl.imhof;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class AttributesTest {
   
   private static Map<String,String> testmap = new HashMap<>();
   static {
       testmap.put("Name", "Leman");
       testmap.put("Area","123");
   }
   
   @Test
   public void immuableMapTest() {
       Attributes attributes = new Attributes(testmap);
       testmap.clear();
       assertEquals("Leman",attributes.get("Name"));
       testmap.put("Name", "Leman");
       testmap.put("Area","123");
   }
   
   @Test
   public void secondGetTest() {
       Attributes attributes = new Attributes(testmap);

       assertEquals(0,attributes.get("Name", 0));
       assertEquals(123,attributes.get("Area", 0));
       assertEquals(0,attributes.get("Country", 0));
   }
   
   @Test
   public void keysToKeepTest() {
       Attributes attributes = new Attributes(testmap);
       Set<String> keys= new HashSet<String>();
       keys.add("Name");
       keys.add("prout");
       Attributes newOne=attributes.keepOnlyKeys(keys);
       assertEquals("Leman",newOne.get("Name","oups"));
       assertEquals("oups",newOne.get("Area", "oups"));
       assertFalse(newOne.contains("prout"));
   } 

}
