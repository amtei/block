import java.util.ArrayList;
import java.util.Objects;

public class GenerateBlock {
    ArrayList<Block> blocks = new ArrayList<>();

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public String s = "0";

    public void setBlocks() {
        for (int i = 0; blocks.size() < 5; i++) {

            blocks.add(new Block(1092024, s));
            s = blocks.get(i).getHash();

        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenerateBlock that)) return false;
        return Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

    public boolean compareAll() {
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