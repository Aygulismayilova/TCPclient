
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        while (true) {
            Socket socket = new Socket("127.0.0.1", 7500);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            byte[] bytes = new Scanner(System.in).nextLine().getBytes();

            //Files.readAllBytes(Paths.get("\\Users\\Zamin\\Desktop\\imrs.jpeg"));

            dos.writeInt(bytes.length);
            dos.write(bytes);
//read begin
            DataInputStream datastream = new DataInputStream(socket.getInputStream());
            int mssLen = datastream.readInt();
            byte[] arr = new byte[mssLen];
            datastream.readFully(arr);
            System.out.println(new String(arr));

        }
    }
}
