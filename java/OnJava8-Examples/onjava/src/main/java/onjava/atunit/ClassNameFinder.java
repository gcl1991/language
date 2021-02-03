// onjava/src.main.java.onjava.atunit/ClassNameFinder.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java onjava.src.main.java.onjava.atunit.ClassNameFinder}
package onjava.atunit;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import onjava.*;

public class ClassNameFinder {
  public static String thisClass(byte[] classBytes) {
    Map<Integer,Integer> offsetTable = new HashMap<>();
    Map<Integer,String> classNameTable =
      new HashMap<>();
    try {
      DataInputStream data = new DataInputStream(
        new ByteArrayInputStream(classBytes));
      int magic = data.readInt();  // 0xcafebabe
      int minorVersion = data.readShort();
      int majorVersion = data.readShort();
      int constantPoolCount = data.readShort();
      int[] constantPool = new int[constantPoolCount];
      for(int i = 1; i < constantPoolCount; i++) {
        int tag = data.read();
        // int tableSize;
        switch(tag) {
          case 1: // UTF
            int length = data.readShort();
            char[] bytes = new char[length];
            for(int k = 0; k < bytes.length; k++)
              bytes[k] = (char)data.read();
            String className = new String(bytes);
            classNameTable.put(i, className);
            break;
          case 5: // LONG
          case 6: // DOUBLE
            data.readLong(); // discard 8 bytes
            i++; // Special skip necessary
            break;
          case 7: // CLASS
            int offset = data.readShort();
            offsetTable.put(i, offset);
            break;
          case 8: // STRING
            data.readShort(); // discard 2 bytes
            break;
          case 3:  // INTEGER
          case 4:  // FLOAT
          case 9:  // FIELD_REF
          case 10: // METHOD_REF
          case 11: // INTERFACE_METHOD_REF
          case 12: // NAME_AND_TYPE
          case 18: // Invoke Dynamic
            data.readInt(); // discard 4 bytes
            break;
          case 15: // Method Handle
            data.readByte();
            data.readShort();
            break;
          case 16: // Method Type
            data.readShort();
            break;
          default:
            throw
              new RuntimeException("Bad tag " + tag);
        }
      }
      short accessFlags = data.readShort();
      String access = (accessFlags & 0x0001) == 0 ?
        "nonpublic:" : "public:";
      int thisClass = data.readShort();
      int superClass = data.readShort();
      return access + classNameTable.get(
        offsetTable.get(thisClass)).replace('/', '.');
    } catch(IOException | RuntimeException e) {
      throw new RuntimeException(e);
    }
  }
  // Demonstration:
  public static void
  main(String[] args) throws Exception {
    PathMatcher matcher = FileSystems.getDefault()
      .getPathMatcher("glob:**/*.class");
    // Walk the entire tree:
    Files.walk(Paths.get("."))
      .filter(matcher::matches)
      .map(p -> {
          try {
            return thisClass(Files.readAllBytes(p));
          } catch(Exception e) {
            throw new RuntimeException(e);
          }
        })
      .filter(s -> s.startsWith("public:"))
      // .filter(s -> s.indexOf('$') >= 0)
      .map(s -> s.split(":")[1])
      .filter(s -> !s.startsWith("enums."))
      .filter(s -> s.contains("."))
      .forEach(System.out::println);
  }
}
/* Output:
src.main.java.onjava.ArrayShow
onjava.src.main.java.onjava.atunit.AtUnit$TestMethods
onjava.src.main.java.onjava.atunit.AtUnit
onjava.src.main.java.onjava.atunit.ClassNameFinder
onjava.src.main.java.onjava.atunit.Test
onjava.src.main.java.onjava.atunit.TestObjectCleanup
onjava.src.main.java.onjava.atunit.TestObjectCreate
onjava.src.main.java.onjava.atunit.TestProperty
src.main.java.onjava.BasicSupplier
src.main.java.onjava.CollectionMethodDifferences
src.main.java.onjava.ConvertTo
src.main.java.onjava.Count$Boolean
src.main.java.onjava.Count$Byte
src.main.java.onjava.Count$Character
src.main.java.onjava.Count$Double
src.main.java.onjava.Count$Float
src.main.java.onjava.Count$Integer
src.main.java.onjava.Count$Long
src.main.java.onjava.Count$Pboolean
src.main.java.onjava.Count$Pbyte
src.main.java.onjava.Count$Pchar
src.main.java.onjava.Count$Pdouble
src.main.java.onjava.Count$Pfloat
src.main.java.onjava.Count$Pint
src.main.java.onjava.Count$Plong
src.main.java.onjava.Count$Pshort
src.main.java.onjava.Count$Short
src.main.java.onjava.Count
src.main.java.onjava.CountingIntegerList
src.main.java.onjava.CountMap
src.main.java.onjava.Countries
src.main.java.onjava.Enums
src.main.java.onjava.FillMap
src.main.java.onjava.HTMLColors
src.main.java.onjava.MouseClick
src.main.java.onjava.Nap
src.main.java.onjava.Null
src.main.java.onjava.Operations
src.main.java.onjava.OSExecute
src.main.java.onjava.OSExecuteException
src.main.java.onjava.Pair
src.main.java.onjava.ProcessFiles$Strategy
src.main.java.onjava.ProcessFiles
src.main.java.onjava.Rand$Boolean
src.main.java.onjava.Rand$Byte
src.main.java.onjava.Rand$Character
src.main.java.onjava.Rand$Double
src.main.java.onjava.Rand$Float
src.main.java.onjava.Rand$Integer
src.main.java.onjava.Rand$Long
src.main.java.onjava.Rand$Pboolean
src.main.java.onjava.Rand$Pbyte
src.main.java.onjava.Rand$Pchar
src.main.java.onjava.Rand$Pdouble
src.main.java.onjava.Rand$Pfloat
src.main.java.onjava.Rand$Pint
src.main.java.onjava.Rand$Plong
src.main.java.onjava.Rand$Pshort
src.main.java.onjava.Rand$Short
src.main.java.onjava.Rand$String
src.main.java.onjava.Rand
src.main.java.onjava.Range
src.main.java.onjava.Repeat
src.main.java.onjava.RmDir
src.main.java.onjava.Sets
src.main.java.onjava.Stack
src.main.java.onjava.Suppliers
src.main.java.onjava.TimedAbort
src.main.java.onjava.Timer
src.main.java.onjava.Tuple
src.main.java.onjava.Tuple2
src.main.java.onjava.Tuple3
src.main.java.onjava.Tuple4
src.main.java.onjava.Tuple5
src.main.java.onjava.TypeCounter
*/
