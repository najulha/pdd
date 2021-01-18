import java.util.Scanner;

class Grafite {
    public float calibre;
    public String dureza;
    public int tamanho;

    public Grafite(float calibre, String dureza, int tamanho){
        this.calibre = calibre;
        this.dureza = dureza;
        this.tamanho = tamanho;
    }

    public String toString(){
        return "[" + calibre + ":" + dureza + ":" + tamanho + "]"; 
    }

}

public class Lapiseira{
    public float calibre;
    public Grafite graf;

    public Lapiseira(float calibre){
        this.calibre = calibre;
        this.graf = null;
    }

    public void inserir(float calibre, String dureza, int tamanho){
        if(graf != null){
            System.out.println("erro: já tem grafite!");
        }else if(calibre != this.calibre){
            System.out.println("erro: calibres diferentes!");
        }else{
            this.graf = new Grafite(calibre, dureza, tamanho);
            System.out.println("Grafite inserido com sucesso!");
        }
    }

    public Grafite remover(){
        if(graf == null){
            System.out.println("Sem grafite!");
        }else{
        graf = null;
        System.out.println("O grafite foi removido...");
        }
        return graf;
    }
    
    public void rabiscar(){
        if(this.graf.tamanho <= 0){
            System.out.println("erro: não tá dando para rabiscar, o grafite acabou!");
        }
        
        if(this.graf.tamanho > 0){
            System.out.println("rabiscando...");
            if(this.graf.dureza == "HB"){
                this.graf.tamanho -= 1;
                
            }else if(this.graf.dureza  == "2B"){
                this.graf.tamanho -= 2;
                
            }else if(this.graf.dureza  == "4B"){
                this.graf.tamanho -= 4;
                
            }else if(this.graf.dureza  == "6B"){
                this.graf.tamanho -= 6;
                
            }else{
                System.out.println("erro: impossível escrever..");
            }
        }
    }

    public String toString(){
        return "Lapiseira: calibre: " + calibre + " grafite: " + graf;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 'init' para iniciar começar a usar sua lapiseira, \n 'inserir' para inserir um grafite, \n 'remover' para remover o grafite atual, \n 'rabiscar' para rabiscar algo. ");
        Lapiseira pentel = new Lapiseira(0.5f);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                System.out.println("guardando a lapiseira...");
                break;
            }else if(ui[0].equals("init")){
               System.out.println(pentel);
            }else if(ui[0].equals("inserir")){
                pentel.inserir(0.5f, "HB", 10);
                System.out.println(pentel);
            }else if(ui[0].equals("remover")){
                pentel.remover();
                System.out.println(pentel);
            }else if(ui[0].equals("rabiscar")){
                pentel.rabiscar();
                System.out.println(pentel);
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}