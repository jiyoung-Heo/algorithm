import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if(num>=90 && num <= 100){
            System.out.println("A");
        }else if(num >= 80 && num < 90){
            System.out.println("B");
        }else if(num >= 70 && num < 80){
            System.out.println("C");
        }else if(num >= 60 && num < 70){
            System.out.println("D");
        }else{
            System.out.println("F");
        }
    }
}
