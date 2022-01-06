package entities;

public class Conversor {

    public static double IOF = 0.06;

    public static Double conversorDolar(double dolares, double cotacao){
        dolares += dolares*IOF;
        return dolares * cotacao;
    }
}
