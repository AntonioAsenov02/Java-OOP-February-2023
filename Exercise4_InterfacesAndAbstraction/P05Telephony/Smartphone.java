package Exercise4_InterfacesAndAbstraction.P05Telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers,List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {

        StringBuilder builder = new StringBuilder();

        for (String url : urls) {
            if (containsDigit(url)){
                builder.append("Invalid URL!").append(System.lineSeparator());
            }else {
                builder.append(String.format("Browsing: %s!%n",url));
            }
        }
        return builder.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();

        for (String number : numbers) {
            if (containsOnlyDigit(number)){
                builder.append(String.format("Calling... %s%n",number));
            }else {
                builder.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
    public boolean containsDigit(String text){

        for (char symbol : text.toCharArray()) {
            if (Character.isDigit(symbol)){
                return true;
            }
        }
        return false;
    }
    public boolean containsOnlyDigit(String text){

        for (char symbol : text.toCharArray()) {
            if (!Character.isDigit(symbol)){
                return false;
            }
        }
        return true;
    }
}
