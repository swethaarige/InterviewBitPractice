import java.util.ArrayList;

public class ValidIpAddresses {
    public static void main (String[] args) {
        String str = "25525511135";
        ArrayList<String> ipAddressesFound = ipAddressesFound(str);
        for (String str1 : ipAddressesFound) {
            System.out.println("IP Address found is  " + str1);
        }
    }
    public static ArrayList<String> ipAddressesFound(String A) {
        ArrayList<String> ipAddressesFound = new ArrayList<>();
        String[] ipAddressParts = new String[] {"", "", "", ""};
        for (int i = 1; i < Math.min((int)A.length(), 4); i++) {
            ipAddressParts[0] = A.substring(0, i);
            if (!isValidPart(ipAddressParts[0])) {
                continue;
            }
            for (int j = i + 1; j < i + Math.min((int)A.length() - i, 4); j++) {
                ipAddressParts[1] = A.substring(i, j);
                if (!isValidPart(ipAddressParts[1])) {
                    continue;
                }
                for (int k = j + 1; k < j + Math.min((int)A.length() - j, 4); k++) {
                    ipAddressParts[2] = A.substring(j, k);
                    ipAddressParts[3] = A.substring(k);
                    if (isValidPart(ipAddressParts[2]) && isValidPart(ipAddressParts[3])) {
                        ipAddressesFound.add(join(ipAddressParts));
                    }
                }
            }
        }
        return ipAddressesFound;
    }
    public static boolean isValidPart(String str) {
        int value = Integer.parseInt(str);
        if (value > 255) {
            return false;
        }
        return str.length() == Integer.toString(value).length();
    }
    public static String join(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i < strings.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
