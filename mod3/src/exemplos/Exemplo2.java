package exemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exemplo2 {

    public static void main(String[] args) {
        Exemplo2 exemplo2 = new Exemplo2();

        Batch batch = new NewBatch();

        System.out.println(exemplo2.getMinimunTapeCount(batch));
    }

    public class Tape {

        private int stored;
        private int numberOfFiles;

        public Tape(int stored){
            this.stored = stored;
            this.numberOfFiles = 1;
        }

        public int getStored() {
            return stored;
        }

        public int getNumberOfFiles() {
            return numberOfFiles;
        }

        public void addStorage(int storage){
            this.stored += storage;
        }


        public void addFiles( ){
            this.numberOfFiles++;
        }
    }

    public static class NewBatch implements Batch {
        @Override
        public int[] getFileSizes() {
            return new int[] {
                    70, 10, 20
            };

        }

        @Override
        public int getTapeSize() {
            return 100;
        }
    }

    public interface Batch {
        int[] getFileSizes();

        int getTapeSize();
    }

    public int getMinimunTapeCount( final Batch batch){

        int [] sizes = batch.getFileSizes();
        Arrays.sort(sizes);

        int tapes = 0;

        List<Tape> tapeList = new ArrayList<>();

        for (int i = sizes.length - 1; i > -1; i--){
            boolean stored = false;

            for (Tape tape : tapeList){
                if (((tape.getStored() + sizes[i]) <= batch.getTapeSize()) && (tape.getNumberOfFiles() < 2)){
                    tape.addStorage(sizes[i]);
                    tape.addFiles();
                    stored = true;
                    break;
                }
            }

            if (!stored){
                tapes++;
                tapeList.add(new Tape(sizes[i]));
            }
        }

        return tapes;
    }
}
