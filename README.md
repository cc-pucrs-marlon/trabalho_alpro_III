# Trabalho de Algoritmos e Programação III - Prof. Marco Mangan
## Alunos: Marlon Baptista de Quadros e Allan Moreira

### Código desenvolvido no IntelliJ IDEA 14.1.5
### JUnit utilizado 4.7

## Arquivos
* operacoes_1.csv - A coluna esquerda representa a quantidade de nodos e a direita representa a quantidade de operações realizadas
* operacoes_1.ods - Gráfico gerado dos dados do arquivo operacoes_1.csv
* Arvore.java - Contém os métodos da árvore
* Main.java - Classe responsável pela execução dos algoritmos da árvore
* Nodo.java - Classe responsável por armazenar o valor da chave, e os nodos da esquerda e da direita
* ArvoreTest.java - Classe de Teste JUnit com 10 casos. 5 casos simples e 5 casos complexos

## Código utilizado para gerar a contagem e salvar no arquivo .csv
```java

    // Necessita modificar o tipo de retorno dos métodos printTreeJB e printTreeJB0 da classe Arvore para int
    // e retornar o valor armazenado na váriavel contador do método printTreeJB0
    public class Main {
        public static void main(String[] args){
            Arvore arvore = new Arvore();
            HashMap<Integer, Integer> avoidDuplicates = new HashMap<>();
            int[] matriz = new int[1000];
            int number;
            int cont = 0;
            int contInter = 0;
            do {
                while (contInter<cont) {
                    number = ThreadLocalRandom.current().nextInt(1, 1000);
                    if(!avoidDuplicates.containsKey(number)){
                        arvore.addObjectNonAVL(number);
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
        }
    }


```