package bms_src;

import java.util.Scanner;

public class Menu {
    private final String header;
    private final Pair<String, Runnable>[] options;
    private Integer chosenOption;


    public Menu(String _header, Pair<String, Runnable>[] _options){
        header = _header;
        options = _options;
    }

    public Integer getChosenOption(){
        Scanner _option = new Scanner(System.in);
        String _chosenOption = _option.next();
        int a = 0;
        try {
            a = Integer.parseInt(_chosenOption);
        }catch (NumberFormatException e){
            return -2;
        }

        if(a > 0 && a <= options.length){
            return a;
        }
        else if( a == options.length + 1){
            return -1;
        }

        return -2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(header).append("\n");
        for(int i = 0 ; i < this.options.length; i++){
            sb.append(i + 1).append(". ").append(this.options[i]).append("\n");
        }
        sb.append(options.length + 1).append(". Exit");
        return sb.toString();
    }
}
