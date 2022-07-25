import java.util.*;
import java.lang.String;
import javax.swing.*;
import java.awt.*;



/**
 * Main Class for the newParse
 */
public class Main extends JFrame{
    Button comp = new Button();
    GridBagConstraints gbc = new GridBagConstraints();
//     public Main(){
//         setLayout(new GridBagLayout());

//         gbc.gridx = 0;
//         gbc.gridy = 0;
//         add(comp, gbc);
//     }
    /**
     * Main method
     * @param args Arguments passed through
     */

    public static void main(String[] args){
        Main m = new Main();
        String l = "67-33.07   0 8";
        ArrayList<String> p = new ArrayList<>(listBuilder(l));
        System.out.print("Total: ");
        System.out.println(m.listCompiler(p));



    }





        /**
         * Compiler class
         * @param s ArrayList fo Strings
         * @return a double that represents the added up total
         */
    public Double listCompiler(ArrayList<String> s){
        Double total = 0.0;
        ArrayList<Double> doubles = new ArrayList<>();
        for(int i=0; i<s.size(); i++){
            doubles.add(Double.parseDouble(s.get(i)));
        }
        for(int i=0; i<s.size(); i++){
            total += doubles.get(i);
        }

        return total;

    }

    /**
     * Assembles a list of doubles by cutting away random characters and spaces that are not numbers
     * @param l the string passed in
     * @return Returns an ArrayList of Strings
     */
    public static ArrayList<String> listBuilder(String l){
        boolean dStart = false;
        String str = l;
        ArrayList<String> dList = new ArrayList<String>();
        int count = 0;
        String soutput = "";

        for(int i = 0; i< str.length(); i++){

            int endNum = 0;
            if(str.substring(i+1) == null ){
                endNum = i;
            }
            if(str.substring(i,i+1).matches("\\d") || (str.substring(i,i+1).equals("."))){
                dStart = true;
                if(dStart == true){

                    count++;
                    if(str.substring(i,i+1).equals(".")){
                        soutput += ".";

                    }
                    if(str.substring(i,i+1).matches("\\d")){
                        soutput += str.substring(i,i+1);
                    }

                }

            }else if (str.substring(i).equals(null)){
                if(soutput != ""){
                    dList.add(soutput);
                }
//                dList.add(soutput);
                soutput = "";
                dStart = false;
            }else{
                if(soutput != ""){
                    dList.add(soutput);
                }
                soutput = "";
                dStart = false;
            }

        }
        if(soutput != ""){
            dList.add(soutput);
        }

        return dList;
    }

}
