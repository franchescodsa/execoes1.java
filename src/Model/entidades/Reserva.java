package Model.entidades;

import Model.excecoes.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut){
        if (!checkOut.after(checkIn)) {
            throw new DomainException("A data de Check-Out deve ser posterior a de Check-In");
        }
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duracao() {
        long diferenca = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizarData(Date checkIn, Date checkOut) {

        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Data de reserva para atualizações sejam datas futuras");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("A data de Check-Out deve ser posterior a de Check-In");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }



    @Override
    public String toString() {
        return "Quarto "
                + numeroQuarto +
                ", checkIn: "
                +sdf.format(checkIn)+
                ", checkOut: "
                +sdf.format(checkOut)
                +", "
                +duracao()
                +" noites"
                ;
    }


}
