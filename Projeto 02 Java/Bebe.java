import java.util.Scanner;
public class Bebe{

    int fome;
    int sono;
    int forca;
    int energia;
    int energiaMax;
    boolean estaFeliz;
    
    public Bebe(int fome, int sono, int forca, int energia){
        this.fome = fome;
        this.sono = sono;
        this.forca = forca;
        this.energia = energia;
        this.energiaMax = energia;
        this.estaFeliz = true;
    }

    void chora() {
        if(sono < 10){
            sono += 1;
            System.out.println("zzzZzzzZ");
        }

        if(fome > 0){
            System.out.println("Uméeeeeee!! tô com fome :(");
            fome += 1;
        }else{
            System.out.println("Tô cheinho já!!");
        }

        if(forca <= 10 && energia <= 10){
            System.out.println("preciso descansar!!");
            forca -= 1;
            energia -= 1;
        } else{
            System.out.println("tô a 220!!!!!!");
        }
    }

    void mama(){
        fome -= 1;
        System.out.println("hmmm, leite!!!");

        sono += 1;
        System.out.println("que sonhinho...Zzzz");

        forca += 1;
        energia += 2;
    }

    void dorme(){
        // só dorme se tiver com muito sono, ou seja com o sono > 10
        if(sono <= 5){
            System.out.println("já estou a 220! tô sem sonhinhoo");
        }

        sono -= 1;
        forca += 1;
        if(energia < energiaMax){
            energia += 2;
        }
        fome += 1;

    }

    void engatinha(){
        if(energia > 2 && forca > 2 && estaFeliz){
            System.out.println("nha, nha, nhaaa!!");
            energia -= 2;
            forca -= 1;
            estaFeliz = true;
        }else{
            estaFeliz = false;
            System.out.println("nhaw :( preciso é relaxar...");

        }
    }

    public String toString(){
        return "Bebê biel: fome: " + fome + " sono: " + sono + " força: " + forca + " energia: " + energia;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bebe biel = new Bebe(3,8,5,7);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" "); 
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                biel = new Bebe(3,8,5,7);
            } else if(ui[0].equals("show")){
                System.out.println(biel);
            }else if(ui[0].equals("chorar")){
                biel.chora();
                System.out.println(biel);
            }else if(ui[0].equals("mamar")){
                biel.mama();
                System.out.println(biel);
            } else if(ui[0].equals("dormir")){
                biel.dorme();
                System.out.println(biel);
            } else if(ui[0].equals("engatinhar")){
                biel.engatinha();
                System.out.println(biel);
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}