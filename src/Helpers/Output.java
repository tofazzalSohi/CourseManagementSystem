package Helpers;

public class Output {
    
    protected static boolean print = false;
    private static String spacer = " ";
    private static String bar = "_";

    public static void show(String title, Object detail) {
        
        if(!print) return;
        
        title = title.toUpperCase();
        String[] titles = title.toUpperCase().split("\n");
        String[] details = detail.toString().split("\n");
        int longest = 0;
        
        for (String t : titles) {
            longest = Math.max(t.length(), longest);
        }
        for (String d : details) {
            longest = Math.max(d.length(), longest);
        }
        
        for(int i=0; i<titles.length; i++){
            titles[i] = fixLength(titles[i], longest, true);
        }
        for (int i = 0; i<details.length; i++) {
            details[i] = fixLength(details[i], longest, false);
        }
        System.out.print("_");
        for(int i=0; i<longest; i++){
            System.out.print(bar);
        }
        System.out.println("_");
        for(String t: titles){
            System.out.println("|"+t+"|");
        }
        for(String d: details){
            System.out.println("|"+d+"|");
        }
        System.out.print("|");
        for(int i=0; i<longest; i++){
            System.out.print(bar);
        }
        System.out.println("|");
    }

    private static String fixLength(String s, int size, boolean both) {
        if (both) {
            int balance = (size - s.length()) / 2;
            while (balance-- > 0) {
                s = spacer + s;
            }
        }
        while (s.length() < size) {
            s = s + spacer;
        }
        return s;
    }
}
