import java.io.*;

class Day11Task6 {
    public static void main(String args[]) {
        try {
            FileInputStream infile = new FileInputStream("FileName01.txt");
            FileOutputStream outfile = new FileOutputStream("FileName05.txt");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = infile.read(buffer)) != -1) {
                outfile.write(buffer, 0, bytesRead);
            }
            System.out.println("Byte Copied From NewFile01.txt to NewFile06.txt File ");
            infile.close();
            outfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry..!! File Not Found...!!!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}