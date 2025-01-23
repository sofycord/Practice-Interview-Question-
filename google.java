
public class google {
    public static void givetimemax(String time) {
        char[] time1 = time.toCharArray(); // this makes a string into an array so that it can be indexed

        // if given all ?? --> put max hour
        if (time1[0] == '?' && time1[1] == '?' && time1[3] == '?' && time1[4] == '?') {
            time1[0] = '2';
            time1[1] = '3';
            time1[3] = '5';
            time1[4] = '9';
        } else if (time1[0] == '?') { // if given ?3:45 --> should give you 23:45
            if (time1[1] == '?') { // if both hour slots are ?? --> set it to max hour, 23
                time1[0] = '2';
                time1[1] = '3';
            } else if (time1[1] == '3' || time1[1] == '2' || time1[1] == '1' || time1[1] == '0') { // if second hour number is 3 or smaller, always put a 2
                time1[0] = '2';
            } else if (time1[1] == '4' || time1[1] == '5' || time1[1] == '6' || time1[1] == '7' || time1[1] == '8' || time1[1] == '9') {
                // if it is any number bigger than 3, put a 1.
                time1[0] = '1';
            }
        }

        // second option: time 1 is ? but time 0 is a number
        if (time1[1] == '?' && time1[0] == '2') {
            time1[1] = '3';
            // this sets the hour to 23
        } else if (time1[0] == '1' && time1[1] == '?') {
            time1[1] = '9';
            // this sets the hour to 19
        } else if (time1[0] == '0' && time1[1] == '?') {
            time1[1] = '9';
        }

        // third option: first minute # is ? : ex. 23:?6--> 23:56
        if (time1[3] == '?') {
            time1[3] = '5';
        }

        // fourth option: second # number is a ? : ex. 19:4? --> 19:49
        if (time1[4] == '?') {
            time1[4] = '9';
        }

        System.out.println(time1);
    }




    public static void main(String[] args) {
        givetimemax("23:5?");
        givetimemax("2?:5?");
        givetimemax("??:5?");
        givetimemax("1?:5?");
        givetimemax("1?:6?"); // how do i deal with the 6
        givetimemax("??:3?");
        givetimemax("1?:3?");
        givetimemax("??:0?");
        givetimemax("00:0?");
        System.out.println("break");
        givetimemax("23:5?");// 23:59
        givetimemax("2?:22");// 23:22
        givetimemax("0?:??");// 09:59
        givetimemax("1?:??");// 19:59
        givetimemax("?4:??");// 14:59
        givetimemax("?3:??");// 23:59
        givetimemax("??:??");// 23:59
        givetimemax("?4:5?"); //14:59
        givetimemax("?4:??"); //14:59
        givetimemax("?3:??"); //23:59
        givetimemax("23:5?"); //23:59
        givetimemax("2?:22"); //23:22
        givetimemax("0?:??"); //09:59
        givetimemax("1?:??"); //19:59
        givetimemax("?4:0?"); //14:09
        givetimemax("?9:4?"); //19:49
    }
}
