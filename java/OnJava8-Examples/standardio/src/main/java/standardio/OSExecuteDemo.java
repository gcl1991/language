package standardio;
// standardio/standardio.OSExecuteDemo.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrates standard I/O redirection
// javap -cp build/classes/java/main standardio.OSExecuteDemo
// {ExcludeFromGradle}
import onjava.*;

public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("ls ./");
    }

}
/* Output:
Compiled from "standardio.OSExecuteDemo.java"
public class standardio.OSExecuteDemo {
  public standardio.OSExecuteDemo();
}
*/
