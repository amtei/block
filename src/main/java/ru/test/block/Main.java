package ru.test.block;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GenerateBlock generateBlock = new GenerateBlock();
        generateBlock.setBlocks();
        generateBlock.setBlocks(); // todo зачем два раза метод вызывается

        //todo цикл делай здесь а не в сервисе GenerateBlock
        // GenerateBlock должен соблюдать принцип одной ответственности (сгенерить один блок а не 5)
        // если завтра нужно будет делать 10, тогда снова менять код ?????

        System.out.println(generateBlock.compareAll());


    }

}
//d117c6bd0054c5a94c07d65d06823e1cfb003d907999820c0dbb82f7eec198e7
