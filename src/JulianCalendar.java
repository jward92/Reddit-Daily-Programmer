public class JulianCalendar{
    public static void main(String[] args){

        System.out.println(leaps(2016, 2017));
        System.out.println(leaps(2019, 2020));
        System.out.println(leaps(1900, 1901));
        System.out.println(leaps(2000, 2001));
        System.out.println(leaps(2800, 2801));
        System.out.println(leaps(123456, 123456));
        System.out.println(leaps(1234, 5678));
        System.out.println(leaps(123456, 7891011));
        System.out.println(leaps(123456789101112l, 1314151617181920l));
    }

    public static long leaps(long year1, long year2){
        long year1Leaps, year2Leaps;
        year1Leaps = (year1/900)*218 + leapsHelper(year1%900);
        year2Leaps = ((year2-1)/900)*218 + leapsHelper((year2-1)%900);
        if(isLeapYear(year1)){
            return year2Leaps - year1Leaps + 1;
        }
        else{
            return year2Leaps - year1Leaps;
        }
    }

    public static boolean isLeapYear(long year){
        if(year%4==0 && year%100!=0){
            return true;
        }
        else if(year%900 == 200 || year%900 == 600){
            return true;
        }
        else{
            return false;
        }
    }

    private static long leapsHelper(long year){
        long leaps = (year/4) - (year/100);
        if(year>=200){
            leaps++;
        }
        if(year>=600){
            leaps++;
        }
        return leaps;
    }
}