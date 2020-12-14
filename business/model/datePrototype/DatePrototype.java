package business.model.datePrototype;

public abstract class DatePrototype {
    protected int day;
    protected int month;
    protected int year;

    public abstract String exibirInfo();
    public abstract DatePrototype clonar();

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws Exception{
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws Exception{
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws Exception{
        this.day = day;
    }

}
