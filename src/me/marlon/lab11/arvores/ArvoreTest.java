
package me.marlon.lab11.arvores;

import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by nolram on 09/11/15.
 */

public class ArvoreTest extends TestCase {

    @Test
    public void testPrintTreeExample01() throws Exception {

        /**
         * Teste 6,4,5,2,8,9,7
         */

        Arvore arvore = new Arvore();
        int valores1[] = {6,4,5,2,8,9,7};
        for (int i=0; i<valores1.length; i++){
            arvore.addBST(valores1[i]);
        }
        String expected = "   |-6-|\n  |4| |8|\n  2 5 7 9\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample02() throws Exception {

        /**
         * Teste 215,220,110,308,200,50,218
         */

        Arvore arvore = new Arvore();
        int valores2[] = {215,220,110,308,200,50,218};
        for (int i=0; i<valores2.length; i++){
            arvore.addBST(valores2[i]);
        }
        String expected = "      |-----215-----|\n   |--110--|   |--220--|\n   50    200   218   308\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample03() throws Exception {

        /**
         * Teste 75,80,60,95,110,90,3,67,1,25,61,70,77,76,79
         */

        Arvore arvore = new Arvore();
        int valores3[] = {75,80,60,95,110,90,3,67,1,25,61,70,77,76,79};
        for (int i=0; i<valores3.length; i++){
            arvore.addBST(valores3[i]);
        }
        String expected = "       |-------75-------|\n   |---60---|      |---80---|\n  |3-|   |-67-|  |-77-|  |-95--|\n  1  25  61  70  76  79  90   110\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample04() throws Exception {

        /**
         * Teste 7,9,26,50,5,11,1,6
         */

        Arvore arvore = new Arvore();
        int valores4[] = {7,9,26,50,5,11,1,6};
        for (int i=0; i<valores4.length; i++){
            arvore.addBST(valores4[i]);
        }

        String expected = "   |-7|\n  |5| 9---|\n  1 6   |-26-|\n        11  50\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample05() throws Exception {

        /**
         * Teste 10,15,5,1,7,12,20,25,6,13
         */

        Arvore arvore = new Arvore();
        int valores5[] = {10,15,5,1,7,12,20,25,6,13};
        for (int i=0; i<valores5.length; i++){
            arvore.addBST(valores5[i]);
        }
        String expected = "   |---10-----|\n  |5-|   |---15-|\n  1 |7   12-|  20-|\n    6      13    25\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample06() throws Exception {

        /**
         * Teste 12,11,10,5,13,14
         */

        Arvore arvore = new Arvore();
        int valores6[] = {12,11,10,5,13,14};
        for (int i=0; i<valores6.length; i++){
            arvore.addBST(valores6[i]);
        }
        String expected = "      |-12-|\n    |-11  13-|\n  |-10      14\n  5\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample07() throws Exception {

        /**
         * Teste 2000,5,3000,2900,2950,2500
         */

        Arvore arvore = new Arvore();
        int valores7[] = {2000,5,3000,2900,2950,2500};
        for (int i=0; i<valores7.length; i++){
            arvore.addBST(valores7[i]);
        }
        String expected = "  |---2000---------------|\n  5           |-------3000\n          |---2900---|\n          2500    2950\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample08() throws Exception {

        /**
         * Teste 20,15,18,16,17
         */

        Arvore arvore = new Arvore();
        int valores8[] = {20,15,18,16,17};
        for (int i=0; i<valores8.length; i++){
            arvore.addBST(valores8[i]);
        }

        String expected = "   |-------20\n   15-----|\n     |---18\n     16-|\n       17\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample09() throws Exception {

        /**
         * Teste 30,27,33,28,31
         */

        Arvore arvore = new Arvore();
        int valores9[] = {30,27,33,28,31};
        for (int i=0; i<valores9.length; i++){
            arvore.addBST(valores9[i]);
        }

        String expected = "   |---30---|\n   27-|  |-33\n     28  31\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }

    @Test
    public void testPrintTreeExample10() throws Exception {

        /**
         * Teste 0,30,25,33,23,15,18
         */

        Arvore arvore = new Arvore();
        int valores10[] = {0,30,25,33,23,15,18};
        for (int i=0; i<valores10.length; i++){
            arvore.addBST(valores10[i]);
        }

        String expected = "  0---------|\n          |-30-|\n        |-25  33\n    |---23\n    15-|\n      18\n";
        String actual = arvore.printTreeJB();
        assertEquals("Estrutura diferente!", expected, actual);
    }
}
