package timus;

//Количество	Обозначение на русском языке	Обозначение на языке аниндилъяква
//от 1 до 4	несколько	few
//от 5 до 9	немного	several
//от 10 до 19	отряд	pack
//от 20 до 49	толпа	lots
//от 50 до 99	орда	horde
//от 100 до 249	множество	throng
//от 250 до 499	сонмище	swarm
//от 500 до 999	полчище	zounds
//от 1000	легион	legion

import java.io.PrintWriter;
import java.util.Scanner;

public class task_1785 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int number = in.nextInt();
        String word = "";

        if (number >= 1 && number <= 4){
            word = "few";
        } else if (number >= 5 && number <= 9) {
            word = "several";
        } else if (number >= 10 && number <= 19) {
            word = "pack";
        } else if (number >= 20 && number <= 49) {
            word = "lots";
        } else if (number >= 50 && number <= 99) {
            word = "horde";
        } else if (number >= 100 && number <= 249) {
            word = "throng";
        } else if (number >= 250 && number <= 499) {
            word = "swarm";
        } else if (number >= 500 && number <= 999) {
            word = "zounds";
        } else if (number >= 1000) {
            word = "legion";
        }

        out.println(word);
        out.flush();
    }
}
