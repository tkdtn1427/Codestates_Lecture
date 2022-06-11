package Section2.Data_Structure;

public class _13_barcode_DFS {
    public static void main(String[] args) {
        String output = barcode(20);
        System.out.println(output);
    }

    static String barcode(int len){
        return Add_str("",len);
    }

    static String Add_str(String str, int len) {
        // TODO:
        if(str.length() == len) return str;

        for(int i=1; i<=3; i++){
            String temp = str + i;
            if(valid(temp)){
                String return_str = Add_str(temp,len);
                if(return_str != null) return return_str;
            }
        }
        return null;
    }

    static boolean valid(String result){
        for(int i=1; i<=result.length()/2; i++){
            String first = result.substring(result.length()-i,result.length());
            String second = result.substring(result.length()-2*i,result.length()-i);
            if(first.equals(second)) return false;
        }
        return true;
    }
}


