import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server
{
 
    private static Socket socket;
 
    public static void main(String[] args)
    {
        try
        {
            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");
 
            //Server is running always. This is done using this while(true) loop
            while(true)
            {
                //Reading the message from the client

                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String number = br.readLine();
                System.out.println("Message received from client is "+number);
                int num = Integer.parseInt(number);
          
             



                //Multiplying the number by 2 and forming the return message
                //String returnMessage;
                /*try
                {
                    int numberInIntFormat = Integer.parseInt(number);
                    int returnValue = numberInIntFormat*2;
                    returnMessage = String.valueOf(returnValue) + "\n";
                }
                catch(NumberFormatException e)
                {
                    //Input was not a number. Sending proper message back to client.
                    returnMessage = "Please send a proper number\n";
                }*/
 
                //Sending the response back to the client.
               /* OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);*/
                //System.out.println("Message sent to the client is "+returnMessage);
                //bw.flush();
		String params;
		params= "/home/saalim/Downloads/iotivity-1.3.0/out/linux/x86_64/debug/service/scene-manager/sampleapp/linux/sceneserver";
        	//params[1] = "1";
		 Runtime rt = Runtime.getRuntime();
		if(num==2){
            Process ps = rt.exec("tmux new -d -s scene1 ./sct.sh");
            ps.waitFor();
}else{
 Process ps = rt.exec("tmux new -d -s scene2 ./sct2.sh");
            ps.waitFor();
}
		//System.exit(0);
            /*BufferedReader reader = new BufferedReader(
                    new InputStreamReader(ps.getInputStream())
            );
		String line = "";
            while ((line = reader.readLine())!= null) {
                System.out.println(line);
            }
		String command = "tmux new -s";
               command += "export LD_LIBRARY_PATH=/home/saalim/Downloads/iotivity-1.3.0/out/linux/x86_64/debug";
               executeCommand(command);*/
               /*String command = "tmux new -s";
               command += "/home/saalim/Downloads/iotivity-1.3.0/out/linux/x86_64/debug/service/scene-manager/sampleapp/linux/";
              command += "sceneserver";
		//command+=" "+number;
               executeCommand(command);*/
                //System.out.println(output);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e){}
        }
    }

        public static String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
