package Section2.DailyCoding;

public class _20_compressString {
    public static void main(String[] args) {
        System.out.println(compressString("dsafdasfffffsgaaaaabbbscccdd"));
        System.out.println(compressString("EQTWVOQQQVDVRC"));
    }

    static String compressString(String str) {
        // TODO:
        if(str.length() == 0) return "";
        int count=1;
        String result = "";

        while(str.length() != 0){
            String now = str.substring(0,1);
            str = str.substring(1,str.length());
            if(str.length() ==0) result += now;

            for(int i=0; i<str.length(); i++){
                if(str.substring(i,i+1).equals(now)){
                    count++;
                }else{
                    if(count >= 3) result =result + count + now;
                    else result = result + now.repeat(count);
                    str = str.substring(i,str.length());
                    count = 1;
                    break;
                }

                if(i == str.length()-1){
                    if(count >= 3) result = result + count + now;
                    else result = result + now.repeat(count);
                    str = "";
                }
            }
        }
        return result;
    }

}

//p ppp