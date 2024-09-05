package ru.test.block;

import java.util.ArrayList;
import java.util.Objects;

public class GenerateBlock {

    // todo также нужно сделать поля private - свойство инкапсуляции
    ArrayList<Block> blocks = new ArrayList<>();

    //todo соблюдай порядок: 1. статические переменные 2. простые переменный 3. статические методы 4. переопределяемый методы 5. простые методы
    //todo не нужно делать кашу из методов и переменных
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public String s = "0";

    //todo в задании описано что, должно быть два метода
    // 1. генерирует новый блок в блокчейне (генерит один блок а не 5 сразу)
    // 2. проверяет блокчейн и возвращает true, если блокчейн действителен


    public void setBlocks() { //todo название в методе set подразумевает, что что то будет передано в параметры метода
        //todo изменить название метода

        for (int i = 0; blocks.size() < 5; i++) {

            blocks.add(new Block(1092024, s));
            s = blocks.get(i).getHash();

        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenerateBlock that)) return false; //todo что за that
        return Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

    /***
     * Функция проверки должна вызываться каждый раз при вставки блока
     * например:
     * блок из 100 элементов, злоумышленник подменил 50 блок вся цепочка теперь не валидна
     * в этом случае новый блок вставлять нельзя потому что цепочку подменили
     *
     */

    public boolean compareAll() { //todo херь какая то, зачем проверять 1 блок со всеми, а потом 2 блок со всеми потом 3 блок со свсеми и т.д.
        //todo нужно проверить только prevHash блока N(3) c hash блока N-1(2), потом делать  prevHash блока N(2) c  hash блока N-1(1) и т.д.
        for (int i = 1; i < blocks.size(); i++) {
            for (int j = 0; j < blocks.size(); j++) {
                if (blocks.get(j).getHash().equals(blocks.get(i).getPrevHash())) {
                    System.out.println((blocks.get(j).getHash().equals(blocks.get(i).getPrevHash())));

                }


            }

        }
        return true;
    }
}