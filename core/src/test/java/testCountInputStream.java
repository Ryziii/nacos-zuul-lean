import java.io.*;

public class testCountInputStream {
    public static void main(String[] args) throws IOException {
        byte[] a = "hello".getBytes();
        try(CountInputStream in = new CountInputStream(new ByteArrayInputStream(a))){
            int n;
            System.out.println(in.getBytesRead());
            while((n = in.read()) != -1){
                System.out.println(n);
            }
            System.out.println("total: " + in.getBytesRead());
        }
    }
}

class CountInputStream extends FilterInputStream {
    private int count = 0;

    protected CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytesRead(){
        return this.count;
    }

    public int read() throws IOException {
        int n = in.read();
        if(n!=-1){
            this.count++;
        }
        return n;
    }


}