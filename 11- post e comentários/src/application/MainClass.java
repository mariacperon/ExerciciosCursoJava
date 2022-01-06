package application;

import entities.Comment;
import entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice time!");
        Comment c2 = new Comment("Wow that's awesome!");
        Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand",
                    "I'm going to visit this wonderful country", 12);
        p1.adicionarComentario(c1);
        p1.adicionarComentario(c2);

        Comment c3 = new Comment("Good night.");
        Comment c4 = new Comment("May the force be with you.");
        Post p2 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand",
                "I'm going to visit this wonderful country", 12);
        p2.adicionarComentario(c3);
        p2.adicionarComentario(c4);

        System.out.println(p1.toString());
        System.out.println();
        System.out.println(p2.toString());

    }
}
