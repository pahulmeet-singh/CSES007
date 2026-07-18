public class sierpinskiTriangle {
    public static void drawSierpinskiTriangle(int order, double x, double y, double size) {
        if (order == 0) {
            // Draw a filled triangle
            drawFilledTriangle(x, y, size);
        } else {
            // Calculate the height of the triangle
            double height = Math.sqrt(3) / 2 * size;

            // Recursively draw three smaller triangles
            drawSierpinskiTriangle(order - 1, x, y, size / 2); // Bottom-left triangle
            drawSierpinskiTriangle(order - 1, x + size / 2, y, size / 2); // Bottom-right triangle
            drawSierpinskiTriangle(order - 1, x + size / 4, y + height / 2, size / 2); // Top triangle
        }
    }

    private static void drawFilledTriangle(double x, double y, double size) {
        // This method should contain the logic to draw a filled triangle on the screen.
        // For simplicity, we will just print the coordinates of the triangle's vertices.
        double height = Math.sqrt(3) / 2 * size;
        System.out.printf("Drawing filled triangle at (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f)%n",
                x, y,
                x + size, y,
                x + size / 2, y + height);
    }

    public static void main(String[] args) {
        int order = 3; // Change this value to generate different orders of the Sierpinski Triangle
        double x = 0; // Starting x-coordinate
        double y = 0; // Starting y-coordinate
        double size = 200; // Size of the initial triangle

        drawSierpinskiTriangle(order, x, y, size);
    }
}
