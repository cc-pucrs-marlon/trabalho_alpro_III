package me.marlon.lab11.arvores;

/**
 * Created by nolram on 25/09/15.
 */
public class Main {

    public static void main(String[] args){
        //26280332316429735373115199276325346367241431922202903181031171206255452343852241
        /*Arvore arvore = new Arvore();
        HashMap<Integer, Integer> avoidDuplicates = new HashMap<>();
        int[] matriz = new int[1000];
        int number;
        int cont = 0;
        int contInter = 0;
        do {
            while (contInter<cont) {
                number = ThreadLocalRandom.current().nextInt(1, 1000);
                if(!avoidDuplicates.containsKey(number)){
                    arvore.addBST(number);
                    avoidDuplicates.put(number, number);
                    contInter++;
                }
            }
            contInter = 0;
            matriz[cont] = arvore.printTreeJB();
            avoidDuplicates = new HashMap<>();
            arvore = new Arvore();
            cont++;
        }while (cont < 1000);


        BufferedWriter writer = null;
        try {
            //create a temporary file
            String logPath = "operacoes_1.csv";
            File logFile = new File(logPath);
            String line = "";
            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            for(int i=0; i < matriz.length; i++){
                line = Integer.toString(i)+";"+Integer.toString(matriz[i]);
                writer.write(line+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
         */
        Arvore arvore = new Arvore();
        int valores0[] = {262,80,332,3,164,297,353,73,115,199,276,325,346,367,24,143,192,220,290,
                318,10,31,171,206,255,45,234,38,52,241};
        for (int i=0; i<valores0.length; i++){
            arvore.addBST(valores0[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores1[] = {6,4,5,2,8,9,7};
        for (int i=0; i<valores1.length; i++){
            arvore.addBST(valores1[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores2[] = {215,220,110,308,200,50,218};
        for (int i=0; i<valores2.length; i++){
            arvore.addBST(valores2[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores3[] = {75,80,60,95,110,90,3,67,1,25,61,70,77,76,79};
        for (int i=0; i<valores3.length; i++){
            arvore.addBST(valores3[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores4[] = {7,9,26,50,5,11,1,6};
        for (int i=0; i<valores4.length; i++){
            arvore.addBST(valores4[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores5[] = {10,15,5,1,7,12,20,25,6,13};
        for (int i=0; i<valores5.length; i++){
            arvore.addBST(valores5[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores6[] = {12,11,10,5,13,14};
        for (int i=0; i<valores6.length; i++){
            arvore.addBST(valores6[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores7[] = {2000,5,3000,2900,2950,2500};
        for (int i=0; i<valores7.length; i++){
            arvore.addBST(valores7[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores8[] = {20,15,18,16,17};
        for (int i=0; i<valores8.length; i++){
            arvore.addBST(valores8[i]);
        }
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores9[] = {30,27,33,28,31};
        for (int i=0; i<valores9.length; i++){
            arvore.addBST(valores9[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());

        arvore = new Arvore();
        int valores10[] = {0,30,25,33,23,15,18};
        for (int i=0; i<valores10.length; i++){
            arvore.addBST(valores10[i]);
        }
        System.out.println();
        System.out.println(arvore.printTreeJB());
    }
}
