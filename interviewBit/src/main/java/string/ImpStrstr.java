package string;

public class ImpStrstr {

    class StringUtils
    {
        // Recursive function to implement strstr() function
        public  String strstr(String X, String Y)
        {
            if (Y == null || Y.length() == 0)
                return X;

            for (int i = 0; i < X.length(); i++)
            {
                if (X.charAt(i) == Y.charAt(0))
                {
                    String s = strstr(X.substring(i + 1), Y.substring(1));
                    return (s != null) ? X.charAt(i) + s : null;
                }
            }

            return null;
        }

        // Implement strstr function in Java
        public  void main(String[] args)
        {
            String X = "Techie Delight - Coding made easy";
            String Y = "Coding";

            System.out.println(strstr(X, Y));
        }
    }
}
