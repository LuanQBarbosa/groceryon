package business.model.datePrototype;

import java.util.Calendar;

public class AnoBissextoPrototype extends DatePrototype {

    protected AnoBissextoPrototype(AnoBissextoPrototype anoBissextoPrototype) {
        this.day = anoBissextoPrototype.getDay();
        this.month = anoBissextoPrototype.getMonth();
        this.year = anoBissextoPrototype.getYear();
    }

    public AnoBissextoPrototype() {
        day = 1;
        month = 1;
        year = 2020;
    }

    public boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    @Override
    public void setYear(int year) throws Exception{
        if (isLeapYear(year)) {
            this.year = year;
        } else {
            throw new Exception(year+" is not a leap year.");
        }
    }

    @Override
    public String exibirInfo() {
        return "Dia: "+ getDay() +"\nMês: "+ getMonth() +"\nAno: "+ getYear();
    }

    @Override
    public AnoBissextoPrototype clonar() {
        return new AnoBissextoPrototype(this);
    }
}