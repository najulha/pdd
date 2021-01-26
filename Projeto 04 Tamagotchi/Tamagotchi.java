import java.util.Scanner;

public class Tamagotchi {
    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int energia;
    private int saciedade;
    private int limpeza;
    private int diamantes;
    private int idade;
    private boolean vivo;

    public Tamagotchi(int energiaMax, int saciedadeMax, int limpezaMax){
        this.energia = energiaMax;
        this.saciedade = saciedadeMax;
        this.limpeza = limpezaMax;
        this.energiaMax = energiaMax;
        this.saciedadeMax = saciedadeMax;
        this.limpezaMax = limpezaMax;
        this.diamantes = 0;
        this.idade = 0;
        this.vivo = true;
    }

    // sets
    private void setEnergia(int energia) {
        this.energia = energia;
        if(energia <= 0){
            this.energia = 0;
            this.vivo = false;
            System.out.println("erro: seu bichinho morreu de fraqueza!");
        }
        if(energia > energiaMax){
            energia = energiaMax;
        }
    }

    private void setSaciedade(int saciedade) {
        this.saciedade = saciedade;
        if(saciedade <= 0){
            this.saciedade = 0;
            this.vivo = false;
            System.out.println("erro: seu bichinho morreu de fome!");
        }
        if(saciedade > saciedadeMax){
            saciedade = saciedadeMax;
        }

    }

    private void setLimpeza(int limpeza) {
        this.limpeza = limpeza;
        if(limpeza <= 0){
            this.limpeza = 0;
            this.vivo = false;
            System.out.println("erro: seu bichinho morreu de sujeira!");
        }
        if(limpeza > limpezaMax){
            limpeza = limpezaMax;
        }
    }
    
    // gets 
    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getSaciedadeMax() {
        return saciedadeMax;
    }

    public int getLimpezaMax() {
        return limpezaMax;
    }

    public int getEnergia() {
        return energia;
    }

    public int getSaciedade() {
        return saciedade;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public int getDiamantes() {
        return diamantes;
    }

    public int getIdade() {
        return idade;
    }

    public boolean vivo() {
        return vivo;
    }
    
    public String toString(){
        return "E:" + this.getEnergia() + "/" + this.getEnergiaMax() + " S:" + this.getSaciedade() + "/" + this.getSaciedadeMax() + " L:" + this.getLimpeza() + "/" + this.getLimpezaMax() + " D:" + this.getDiamantes() + " I:" + this.getIdade();
    }

    public boolean estaVivo(){
        if(!vivo){
            System.out.println("erro: seu bichinho está morto!");
            return false;
        }
        return true;
    }

    public void brincar(){
        if(!estaVivo()){
            return;
        }
        setEnergia(this.getEnergia() - 2);
        setSaciedade(this.getSaciedade() - 1);
        setLimpeza(this.getLimpeza() - 3);
        this.diamantes += 1;
        this.idade += 1;
    }

    public void banhar(){
        if(!estaVivo()){
            return;
        }
        setEnergia(this.getEnergia() - 3);
        setSaciedade(this.getSaciedade() - 1);
        setLimpeza(this.getLimpezaMax());
        this.idade += 2;
    }

    public void comer(){
        if(!estaVivo()){
            return;
        }
        setEnergia(this.getEnergia() - 1);
        setSaciedade(this.getSaciedadeMax());
        setLimpeza(this.getLimpeza() - 2);
        this.idade += 1;
    }

    public void dormir(){
        if(estaVivo()){
            if(energia > (energiaMax - 5)){
                System.out.println("erro: seu bichinho está sem sono! ");
            }else{
                setEnergia(this.getEnergiaMax());
                setSaciedade(getSaciedade() - 1);
                int turnos = this.energiaMax - this.energia;
                this.idade += turnos;
            }
        }
    }

    public void show(){

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tamagotchi bibi = new Tamagotchi(0, 0, 0);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                bibi = new Tamagotchi(10, 3, 10);
                System.out.println("yay, seu bichinho nasceu!");
            }else if(ui[0].equals("show")){
                System.out.println(bibi);
            }else if(ui[0].equals("brincar")){
                bibi.brincar();
            }else if(ui[0].equals("banhar")){
                bibi.banhar();
            }else if(ui[0].equals("comer")){
                bibi.comer();
            }else if(ui[0].equals("dormir")){
                bibi.dormir();
            }else{
                System.out.println("erro: comando inválido!");
            }
        }
        scanner.close();
    }

}