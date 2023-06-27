package programa;

import Model.entidades.Reserva;
import Model.excecoes.DomainException;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/* Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. O programa não deve aceitar dados
inválidos para a reserva, conforme as seguintes regras:
- Alterações de reserva só podem ocorrer para datas futuras
- A data de saída deve ser maior que a data de entrada*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Numero do Quarto: ");
            int numero= sc.nextInt();
            System.out.print("Check-in data (dd/MM/yyyy): ");
            Date checkIn= sdf.parse(sc.next());
            System.out.print("Check-in data (dd/MM/yyyy): ");
            Date checkOut= sdf.parse(sc.next());



            Reserva reserva= new Reserva(numero,checkIn,checkOut);
            System.out.println("Reserva: "+ reserva);

            System.out.println();
            System.out.println("Atuaize Datas: ");
            System.out.print("Check-in data (dd/MM/yyyy): ");
            checkIn= sdf.parse(sc.next());
            System.out.print("Check-in data (dd/MM/yyyy): ");
            checkOut= sdf.parse(sc.next());

            reserva.atualizarData(checkIn, checkOut);
            System.out.println("Reserva: "+reserva);

        } catch (ParseException e){
            System.out.println("Formato de data invalido");
        }
        catch (DomainException e){
            System.out.println("Erro em Reserva; "+ e.getMessage());
        } catch (RuntimeException e){
            System.out.println(" Erro Inesperaado");
        }





sc.close();


    }
}