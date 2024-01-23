package com.behavioral.template_pattern.example1;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game= new Chess();
        game.play();
        System.out.println("======================================\n");
        game=new Soccer();
        game.play();
    }
}
