public class swapBits {

    // Function to swap odd and even bits 23 - 00010111
    public static int swapBits(int n) {
        // Get all even bits of x
        int even_bits = n & 0xAAAAAAAA;

        // Get all odd bits of x
        int odd_bits = n & 0x55555555;

        // Right shift even bits
        even_bits >>= 1;

        // Left shift odd bits
        odd_bits <<= 1;

        // Combine even and odd bits
        return (even_bits | odd_bits);

    }

    public static void main(String[] args) {
        int result = swapBits(23);
        System.out.println(result);
    }
}
