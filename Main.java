import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner leia = new Scanner(System.in);
    PartidaXadrez partidaXadrez = new PartidaXadrez();
    
    while (true) {
            try{
            UI.clearScreen();
            UI.printTraculeiro(partidaXadrez.getPecas());
            System.out.println();
            System.out.print("Posicao de origem: ");
            XadrezPosicao source = UI.lerXadrezPosicao(leia);
            
            System.out.println();
            System.out.print("Posica de destinho: ");
            XadrezPosicao target = UI.lerXadrezPosicao(leia);

            XadrezPeca capturaPeca = partidaXadrez.ExecutaMovimentoXadrez(source, target);
            }
            catch (XadrezExeceção e ) {
                System.out.println(e.getMessage());
                leia.nextLine();
            }
            catch (InputMismatchException e ) {
                System.out.println(e.getMessage());
                leia.nextLine();
            }
        }
    }
    
}
