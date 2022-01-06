package entities;

public class Retangulo {

    public double altura;
    public double largura;


    public double area(){
        return altura * largura;
    }

    public double perimetro(){
        return altura*2+largura*2;
    }

    public double diagonal(){
        return Math.sqrt((altura*altura)+(largura*largura));
    }
}
